package jp.blackawa.example.autoscrollrecyclerview

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView

class HorizontalScrollWithClipToPaddingActivity : BaseScrollActivity() {
    override fun getLayoutManager() = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    override fun initRecyclerViewExtra(recyclerView: RecyclerView) {
        LinearSnapHelper().attachToRecyclerView(recyclerView)

        recyclerView.clipToPadding = false
        recyclerView.clipChildren = false
        // 横にpaddingを追加してclipToPaddingでリストと一緒にスクロールさせる.
        recyclerView.setPadding(200, 0, 200, 0)
    }

    override fun scrollToPrevious(recyclerView: RecyclerView) {
        recyclerView.smoothScrollBy(-150, 0)
    }

    override fun scrollToNext(recyclerView: RecyclerView) {
        recyclerView.smoothScrollBy(150, 0)
    }
}
