package jp.blackawa.moodkoro

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.blackawa.moodkoro.databinding.ActivityMoodEditBinding
import jp.blackawa.moodkoro.domain.Mood
import jp.blackawa.moodkoro.entity.MoodEntity
import jp.blackawa.moodkoro.entity.OrmaDatabase

class MoodEditActivity : AppCompatActivity() {

    // lateinitしたいけどprimitive型はできない
    private var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mood_edit)
        id = intent.extras.getInt("id")

        val mood: Mood = getMood(id)

        val binding = DataBindingUtil.setContentView<ActivityMoodEditBinding>(this, R.layout.activity_mood_edit)
        binding.mood = mood
    }

    private fun getMood(id: Int): Mood {
        val db = OrmaDatabase.builder(this).build()
        val entity: MoodEntity = db.selectFromMoodEntity().idEq(id).first()
        return Mood(id = entity.id, solution = entity.solution)
    }
}
