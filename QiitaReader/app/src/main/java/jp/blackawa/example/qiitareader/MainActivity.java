package jp.blackawa.example.qiitareader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.blackawa.example.qiitareader.data.Post;
import jp.blackawa.example.qiitareader.entity.PostEntity;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

        fetchQiitaItems();
    }

    private void updateRecyclerView(List<Post> posts) {
        mAdapter.setPosts(posts);
    }

    private void fetchQiitaItems() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://qiita.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        QiitaService service = retrofit.create(QiitaService.class);
        Observable<List<PostEntity>> observable = service.listItems(1, 20);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<PostEntity>>() {
                    @Override
                    public void call(List<PostEntity> postEntities) {
                        List<Post> posts = new ArrayList<>();
                        for (PostEntity post : postEntities) {
                            posts.add(new Post(post.getTitle(), post.getUser().getName(), post.getCreatedAt()));
                        }
                        updateRecyclerView(posts);
                    }
                });
    }
}
