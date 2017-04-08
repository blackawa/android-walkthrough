package jp.blackawa.example.qiitareader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.blackawa.example.qiitareader.data.Post;

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
            List<Post> posts = new ArrayList<>();
            posts.add(new Post("チーム力向上のためのエトセトラ", "kawasima", "2016/12/25"));
            posts.add(new Post("ClojureScript x XhrIo x 非同期通信 でバイナリファイルをダウンロード", "blackawa", "2016/12/18"));
            posts.add(new Post("複数の iframe の読み込み（ load ）を待つ方法", "unknown", "2016/12/31"));
            return posts;
        }

        @Override
        protected void onPostExecute(List<Post> posts) {
            updateRecyclerView(posts);
        }
    }
}
