package jp.blackawa.moodkoro

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import jp.blackawa.moodkoro.databinding.ActivityMoodBinding

class MoodActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood)
        binding = DataBindingUtil.setContentView<ActivityMoodBinding>(this, R.layout.activity_mood)

        binding.buttonSaveMood.setOnClickListener {
            val solution: String = binding.editTextSolution.text.toString()
            Log.d(this.javaClass.simpleName, "save button clicked.")
            Toast.makeText(this, "EditText is \"${solution}\"", Toast.LENGTH_LONG).show()
            finish()
        }
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
}
