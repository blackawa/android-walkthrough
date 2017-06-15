package jp.blackawa.moodkoro.domain

import jp.blackawa.moodkoro.entity.MoodEntity

data class Mood(
        val id: Int = 0,
        val solution: String = ""
) {
    constructor(entity: MoodEntity) : this(id = entity.id, solution = entity.solution)
}
