package jp.blackawa.example.githubrepositorysearcher.domain;

public class SourceCodeRepository {
    private String ownerAvatarUrl; // owner.avatar_url
    private String ownerName; // owner.login
    private String name;
    private String htmlUrl;
    private int stargazersCount;

    public SourceCodeRepository(String ownerAvatarUrl, String ownerName, String name, String htmlUrl, int stargazersCount) {
        this.ownerAvatarUrl = ownerAvatarUrl;
        this.ownerName = ownerName;
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.stargazersCount = stargazersCount;
    }

    public String getOwnerAvatarUrl() {
        return ownerAvatarUrl;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getName() {
        return name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }
}
