package jp.blackawa.moodkoro

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jp.blackawa.moodkoro.databinding.ActivityMoodBinding
import jp.blackawa.moodkoro.entity.MoodEntity
import jp.blackawa.moodkoro.entity.OrmaDatabase

class MoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)
        binding = DataBindingUtil.setContentView<ActivityMoodBinding>(this, R.layout.activity_mood)

        binding.buttonSaveMood.setOnClickListener(onSaveButtonClick)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mood, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_cancel -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private val onSaveButtonClick = fun(_: View) {
        val solution = binding.editTextSolution.text.toString()
        val db: OrmaDatabase = OrmaDatabase.builder(this).build()
        db.prepareInsertIntoMoodEntityAsSingle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.execute(MoodEntity(solution = solution)) }
                .subscribe { _, _ -> finish() }
    }
}
