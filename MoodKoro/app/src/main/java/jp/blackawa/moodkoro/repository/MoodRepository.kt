package jp.blackawa.moodkoro.repository

import jp.blackawa.moodkoro.entity.MoodEntity

object MoodRepository {
    fun findAll(): List<MoodEntity> {
        return arrayListOf(
                MoodEntity(id = 1, solution = "帰宅後、紅茶を飲む"),
                MoodEntity(id = 2, solution = "笑い話をひとつ持ち帰る"),
                MoodEntity(id = 3, solution = "お金の心配を共有する"),
                MoodEntity(id = 4, solution = "窓を開けて酸欠にならないように寝る")
        )
    }
}
