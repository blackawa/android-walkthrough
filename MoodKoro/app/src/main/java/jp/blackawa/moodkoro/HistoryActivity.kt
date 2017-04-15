package jp.blackawa.moodkoro

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import jp.blackawa.moodkoro.adapter.HistoryListItemAdapter
import jp.blackawa.moodkoro.databinding.ActivityHistoryBinding
import jp.blackawa.moodkoro.domain.Mood
import jp.blackawa.moodkoro.entity.OrmaDatabase

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        binding = DataBindingUtil.setContentView<ActivityHistoryBinding>(this, R.layout.activity_history)
        binding.recyclerMoods.adapter = HistoryListItemAdapter(context = this, listener = View.OnClickListener {
            startActivity(Intent(this, MoodEditActivity::class.java))
        })
        binding.recyclerMoods.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        updateHistoryList()
        super.onResume()
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

    private fun updateHistoryList() {
        val db = OrmaDatabase.builder(this).build()
        val moods: List<Mood> = db.selectFromMoodEntity()
                .map { Mood(id = it.id, solution = it.solution) }
        Log.d(this.javaClass.simpleName, moods.toString())
        (binding.recyclerMoods.adapter as HistoryListItemAdapter).updateList(moods)
    }
}
