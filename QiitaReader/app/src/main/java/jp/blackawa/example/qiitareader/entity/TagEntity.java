package jp.blackawa.example.qiitareader.entity;

import java.util.List;

public class TagEntity {
    private String title;
    private List<String> versions;

    public TagEntity() {
    }

    public TagEntity(String title, List<String> versions) {
        this.title = title;
        this.versions = versions;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getVersions() {
        return versions;
    }
}
