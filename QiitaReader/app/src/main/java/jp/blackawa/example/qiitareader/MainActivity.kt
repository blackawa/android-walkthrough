package jp.blackawa.example.qiitareader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import jp.blackawa.example.qiitareader.data.Post
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val mPostRecyclerView: RecyclerView = findViewById(R.id.rv_posts) as RecyclerView
    private var mAdapter: PostAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPostRecyclerView.layoutManager = LinearLayoutManager(this)

        mPostRecyclerView.adapter = mAdapter

        fetchQiitaItems()
    }

    private fun updateRecyclerView(posts: List<Post>) {
        mAdapter.setPosts(posts)
    }

    private fun fetchQiitaItems() {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://qiita.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        val service = retrofit.create<QiitaService>(QiitaService::class.java)
        val observable = service.listItems(1, 20)

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { postEntities ->
                    val posts = postEntities.map {
                        Post(it.title, it.user.name, it.createdAt)
                    }
                    updateRecyclerView(posts)
                }
    }
}
