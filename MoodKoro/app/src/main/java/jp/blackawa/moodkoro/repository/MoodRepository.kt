package jp.blackawa.moodkoro.repository

import jp.blackawa.moodkoro.entity.Mood

class MoodRepository {
    fun findAll(): List<Mood> {
        return arrayListOf(
                Mood(id = 1, solution = "帰宅後、紅茶を飲む"),
                Mood(id = 2, solution = "笑い話をひとつ持ち帰る"),
                Mood(id = 3, solution = "お金の心配を共有する"),
                Mood(id = 4, solution = "窓を開けて酸欠にならないように寝る")
        )
    }
}
