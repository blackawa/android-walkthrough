package jp.blackawa.moodkoro.domain

import jp.blackawa.moodkoro.entity.MoodEntity

class Mood(val id: Int, val solution: String) {
    constructor(entity: MoodEntity) : this(entity.id, entity.solution)
}
