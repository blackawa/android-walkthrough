package jp.blackawa.example.qiitareader.entity;

import com.google.gson.annotations.SerializedName;

public class GroupEntity {
    @SerializedName("created_at")
    private String createdAt;
    private Long id;
    private String name;
    @SerializedName("private")
    private String private1;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("url_name")
    private String urlName;

    public GroupEntity() {
    }

    public GroupEntity(String createdAt, Long id, String name, String private1, String updatedAt, String urlName) {
        this.createdAt = createdAt;
        this.id = id;
        this.name = name;
        this.private1 = private1;
        this.updatedAt = updatedAt;
        this.urlName = urlName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrivate1() {
        return private1;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUrlName() {
        return urlName;
    }
}
