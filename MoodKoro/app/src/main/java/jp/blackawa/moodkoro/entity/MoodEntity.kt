package jp.blackawa.moodkoro.entity

import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Table
import io.reactivex.annotations.Nullable

@Table
data class MoodEntity(
        @PrimaryKey(autoincrement = true)
        var id: Int = 0,
        @Column
        @Nullable
        var solution: String = ""
)
