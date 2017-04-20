package jp.blackawa.example.githubrepositorysearcher.service;

import java.util.ArrayList;
import java.util.List;

import jp.blackawa.example.githubrepositorysearcher.domain.SourceCodeRepository;

/**
 * ActivityにDIするサービスクラス.
 */
public class GitHubService {
    public List<SourceCodeRepository> searchRepositories(String query) {
        return new ArrayList<SourceCodeRepository>() {{
            add(new SourceCodeRepository(null, "alackawa", "repo1", null, 1));
            add(new SourceCodeRepository(null, "blackawa", "repo2", null, 1));
            add(new SourceCodeRepository(null, "clackawa", "repo3", null, 1));
        }};
    }
}
