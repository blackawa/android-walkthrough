package jp.blackawa.example.qiitareader.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostEntity {
    @SerializedName("rendered_body")
    private String renderedBody;
    private String body;
    private Boolean coediting;
    @SerializedName("created_at")
    private String createdAt;
    private GroupEntity group;
    private String id;
    @SerializedName("private")
    private Boolean private1;
    private List<TagEntity> tags;
    private String title;
    @SerializedName("updated_at")
    private String updatedAt;
    private String url;
    private UserEntity user;

    public String getRenderedBody() {
        return renderedBody;
    }

    public String getBody() {
        return body;
    }

    public Boolean getCoediting() {
        return coediting;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public String getId() {
        return id;
    }

    public Boolean getPrivate1() {
        return private1;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public UserEntity getUser() {
        return user;
    }

    public PostEntity(String renderedBody, String body, Boolean coediting, String createdAt, GroupEntity group, String id, Boolean private1, List<TagEntity> tags, String title, String updatedAt, String url, UserEntity user) {

        this.renderedBody = renderedBody;
        this.body = body;
        this.coediting = coediting;
        this.createdAt = createdAt;
        this.group = group;
        this.id = id;
        this.private1 = private1;
        this.tags = tags;
        this.title = title;
        this.updatedAt = updatedAt;
        this.url = url;
        this.user = user;
    }

    public PostEntity() {

    }
}
