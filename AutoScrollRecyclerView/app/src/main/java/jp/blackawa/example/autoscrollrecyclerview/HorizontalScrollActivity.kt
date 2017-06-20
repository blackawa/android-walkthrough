package jp.blackawa.example.autoscrollrecyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView

class HorizontalScrollActivity : BaseScrollActivity() {
    override fun getLayoutManager(): LinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    override fun setSnapHelper(recyclerView: RecyclerView) {
        LinearSnapHelper().attachToRecyclerView(recyclerView)
    }

    override fun scrollToPrevious(recyclerView: RecyclerView) {
        recyclerView.smoothScrollBy(-100, 0)
    }

    override fun scrollToNext(recyclerView: RecyclerView) {
        recyclerView.smoothScrollBy(100, 0)
    }
}
