package jp.blackawa.example.autoscrollrecyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView

class VerticalScrollActivity : BaseScrollActivity() {
    override fun getLayoutManager(): LinearLayoutManager = LinearLayoutManager(this)

    override fun initRecyclerViewExtra(recyclerView: RecyclerView) {
        LinearSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun scrollToPrevious(recyclerView: RecyclerView) {
        recyclerView.smoothScrollBy(0, -150)
    }

    override fun scrollToNext(recyclerView: RecyclerView) {
        recyclerView.smoothScrollBy(0, 150)
    }
}
