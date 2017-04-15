package jp.blackawa.moodkoro

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import jp.blackawa.moodkoro.adapter.HistoryListItemAdapter
import jp.blackawa.moodkoro.databinding.ActivityHistoryBinding
import jp.blackawa.moodkoro.service.MoodService

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val binding = DataBindingUtil.setContentView<ActivityHistoryBinding>(this, R.layout.activity_history)
        binding.recyclerMoods.adapter = HistoryListItemAdapter(MoodService.fetchMoods())
        binding.recyclerMoods.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_add -> {
                startActivity(Intent(this, MoodActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
