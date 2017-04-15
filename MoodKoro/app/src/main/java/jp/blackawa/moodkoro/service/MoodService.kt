package jp.blackawa.moodkoro.service

import jp.blackawa.moodkoro.domain.Mood
import jp.blackawa.moodkoro.repository.MoodRepository

object MoodService {
    fun fetchMoods(): List<Mood> = MoodRepository.findAll().map(::Mood)
}
