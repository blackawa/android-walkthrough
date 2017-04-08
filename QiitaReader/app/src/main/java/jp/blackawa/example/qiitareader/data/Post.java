package jp.blackawa.example.qiitareader.data;

import java.util.Date;

public class Post {
    private String title;
    private String username;
    private String createdAt;

    public Post(String title, String username, String createdAt) {
        this.title = title;
        this.username = username;
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
