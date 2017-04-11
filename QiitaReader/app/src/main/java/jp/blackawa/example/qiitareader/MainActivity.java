package jp.blackawa.example.qiitareader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import jp.blackawa.example.qiitareader.data.Post;
import jp.blackawa.example.qiitareader.entity.PostEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mPostRecyclerView;
    private PostAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPostRecyclerView = (RecyclerView) findViewById(R.id.rv_posts);

        mPostRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PostAdapter();
        mPostRecyclerView.setAdapter(mAdapter);

        new QiitaPostsTask().execute();
    }

    private void updateRecyclerView(List<Post> posts) {
        mAdapter.setPosts(posts);
    }

    private class QiitaPostsTask extends AsyncTask<String, Void, List<Post>> {

        @Override
        protected List<Post> doInBackground(String... params) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://qiita.com/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            QiitaService service = retrofit.create(QiitaService.class);
            Call<List<PostEntity>> call = service.listItems(1, 20);

            final List<Post> posts = new ArrayList<>();
            call.enqueue(new Callback<List<PostEntity>>() {
                @Override
                public void onResponse(Call<List<PostEntity>> call, Response<List<PostEntity>> response) {
                    Log.d(this.getClass().getSimpleName(), "レスポンスを受け取りました. " + response.body().toString());
                    for (PostEntity post : response.body()) {
                        posts.add(new Post(post.getTitle(), post.getUser().getName(), post.getCreatedAt()));
                    }
                }

                @Override
                public void onFailure(Call<List<PostEntity>> call, Throwable t) {
                    Log.e(this.getClass().getSimpleName(), "HTTPリエクストでエラーが発生しました. " + t.getClass().getSimpleName() + ": " + t.getMessage());
                }
            });

            return posts;
        }

        @Override
        protected void onPostExecute(List<Post> posts) {
            updateRecyclerView(posts);
        }
    }
}
