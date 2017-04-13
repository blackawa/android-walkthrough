package jp.blackawa.moodkoro.domain

import jp.blackawa.moodkoro.entity.MoodEntity

class Mood(entity: MoodEntity) {
    val id: Int = entity.id
    val solution: String = entity.solution
}
