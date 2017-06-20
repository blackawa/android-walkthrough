package jp.blackawa.example.autoscrollrecyclerview

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import jp.blackawa.example.autoscrollrecyclerview.databinding.ActivityBaseScrollBinding

abstract class BaseScrollActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseScrollBinding

    abstract fun getLayoutManager(): LinearLayoutManager
    abstract fun initRecyclerViewExtra(recyclerView: RecyclerView): Unit
    abstract fun scrollToPrevious(recyclerView: RecyclerView): Unit
    abstract fun scrollToNext(recyclerView: RecyclerView): Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_scroll)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_base_scroll)

        initRecyclerView()
        initButtons()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.memu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_vertical -> {
                startActivity(Intent(this, VerticalScrollActivity::class.java))
            }
            R.id.menu_horizontal -> {
                startActivity(Intent(this, HorizontalScrollActivity::class.java))
            }
            R.id.menu_horizontal_with_clip_to_padding -> {
                startActivity(Intent(this, HorizontalScrollWithClipToPaddingActivity::class.java))
            }
            else -> {
            }
        }
        return true
    }

    private fun initRecyclerView() {
        binding.recycler.adapter = MyAdapter((0..999).map { it.toString() })
        binding.recycler.layoutManager = getLayoutManager()
        initRecyclerViewExtra(binding.recycler)
    }

    private fun initButtons() {
        binding.buttonNext.setOnClickListener {
            disableButton()
            (binding.recycler.adapter as MyAdapter).incrementSelectedItem()
            scrollRecyclerViewIfNeeded()
            updateButtonAvailability()
        }
        binding.buttonPrevious.setOnClickListener {
            disableButton()
            (binding.recycler.adapter as MyAdapter).decrementSelectedItem()
            scrollRecyclerViewIfNeeded()
            updateButtonAvailability()
        }
    }

    private fun disableButton() {
        binding.buttonNext.isEnabled = false
        binding.buttonPrevious.isEnabled = false
    }

    private fun updateButtonAvailability() {
        val selectedItemIndex = (binding.recycler.adapter as MyAdapter).selectedItemIndex
        val itemCount = binding.recycler.adapter.itemCount
        // indexとsizeの比較用に +1
        binding.buttonNext.isEnabled = itemCount != (selectedItemIndex + 1)
        binding.buttonPrevious.isEnabled = 0 != selectedItemIndex
    }

    private fun scrollRecyclerViewIfNeeded() {
        val layoutManager = binding.recycler.layoutManager as LinearLayoutManager
        val firstVisiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition()
        val lastVisiblePosition = layoutManager.findLastCompletelyVisibleItemPosition()
        val selectedItemIndex = (binding.recycler.adapter as MyAdapter).selectedItemIndex

        if (selectedItemIndex < firstVisiblePosition) {
            scrollToPrevious(binding.recycler)
        } else if (lastVisiblePosition < selectedItemIndex) {
            scrollToNext(binding.recycler)
        }
    }
}
