package jp.blackawa.example.qiitareader.entity

import com.google.gson.annotations.SerializedName

class PostEntity(
        @SerializedName("rendered_body")
        val renderedBody: String = "",
        val body: String = "",
        val coediting: Boolean = false,
        @SerializedName("created_at")
        val createdAt: String = "",
        val group: GroupEntity = GroupEntity(),
        val id: String = "",
        @SerializedName("private")
        val private1: Boolean = false,
        val tags: List<TagEntity> = arrayListOf(),
        val title: String = "",
        @SerializedName("updated_at")
        val updatedAt: String = "",
        val url: String = "",
        val user: UserEntity = UserEntity()
)
