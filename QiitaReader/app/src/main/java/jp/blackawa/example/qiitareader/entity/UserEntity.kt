package jp.blackawa.example.qiitareader.entity

import com.google.gson.annotations.SerializedName

class UserEntity(
        val description: String = "",
        @SerializedName("facebook_id")
        val facebookId: String = "",
        @SerializedName("followees_count")
        val followeesCount: Long = 0,
        @SerializedName("followers_count")
        val followersCount: Long = 0,
        @SerializedName("github_login_name")
        val githubLoginName: String = "",
        val id: String = "",
        @SerializedName("items_count")
        val itemsCount: Long = 0,
        @SerializedName("linkedin_id")
        val linkedinId: String = "",
        val location: String = "",
        val name: String = "",
        val organization: String = "",
        @SerializedName("permanent_id")
        val permanentId: Long = 0,
        @SerializedName("profile_image_url")
        val profileImageUrl: String = "",
        @SerializedName("twitter_screen_name")
        val twitterScreenName: String = "",
        @SerializedName("website_url")
        val websiteUrl: String = ""
)
