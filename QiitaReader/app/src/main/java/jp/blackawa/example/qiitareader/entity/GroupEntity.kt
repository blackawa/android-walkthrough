package jp.blackawa.example.qiitareader.entity

import com.google.gson.annotations.SerializedName

class GroupEntity(
        @SerializedName("created_at")
        val createdAt: String = "",
        val id: Long = 0,
        val name: String = "",
        @SerializedName("private")
        val private1: String = "",
        @SerializedName("updated_at")
        val updatedAt: String = "",
        @SerializedName("url_name")
        val urlName: String = ""
)
