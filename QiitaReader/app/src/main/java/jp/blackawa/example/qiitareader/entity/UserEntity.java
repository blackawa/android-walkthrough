package jp.blackawa.example.qiitareader.entity;

import com.google.gson.annotations.SerializedName;

public class UserEntity {
    public UserEntity() {
    }

    private String description;
    @SerializedName("facebook_id")
    private String facebookId;
    @SerializedName("followees_count")
    private Long followeesCount;
    @SerializedName("followers_count")
    private Long followersCount;
    @SerializedName("github_login_name")
    private String githubLoginName;
    private String id;
    @SerializedName("items_count")
    private Long itemsCount;
    @SerializedName("linkedin_id")
    private String linkedinId;
    private String location;
    private String name;
    private String organization;
    @SerializedName("permanent_id")
    private Long permanentId;
    @SerializedName("profile_image_url")
    private String profileImageUrl;
    @SerializedName("twitter_screen_name")
    private String twitterScreenName;
    @SerializedName("website_url")
    private String websiteUrl;

    public UserEntity(
            String description,
            String facebookId,
            Long followeesCount,
            Long followersCount,
            String githubLoginName,
            String id,
            Long itemsCount,
            String linkedinId,
            String location,
            String name,
            String organization,
            Long permanentId,
            String profileImageUrl,
            String twitterScreenName,
            String websiteUrl
    ) {
        this.description = description;
        this.facebookId = facebookId;
        this.followeesCount = followeesCount;
        this.followersCount = followersCount;
        this.githubLoginName = githubLoginName;
        this.id = id;
        this.itemsCount = itemsCount;
        this.linkedinId = linkedinId;
        this.location = location;
        this.name = name;
        this.organization = organization;
        this.permanentId = permanentId;
        this.profileImageUrl = profileImageUrl;
        this.twitterScreenName = twitterScreenName;
        this.websiteUrl = websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public Long getFolloweesCount() {
        return followeesCount;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public String getGithubLoginName() {
        return githubLoginName;
    }

    public String getId() {
        return id;
    }

    public Long getItemsCount() {
        return itemsCount;
    }

    public String getLinkedinId() {
        return linkedinId;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }

    public Long getPermanentId() {
        return permanentId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }
}
