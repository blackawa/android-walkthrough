package jp.blackawa.example.githubrepositorysearcher;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import jp.blackawa.example.githubrepositorysearcher.databinding.ActivityResultBinding;
import jp.blackawa.example.githubrepositorysearcher.domain.SourceCodeRepository;
import jp.blackawa.example.githubrepositorysearcher.service.GitHubService;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;
    private GitHubService gitHubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        String query = getIntent().getExtras().get("query").toString();
        binding.setViewModel(new ViewModel(query));

        gitHubService = new GitHubService();
        List<SourceCodeRepository> repositories = gitHubService.searchRepositories(query);
        binding.recyclerSearchResult.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerSearchResult.setAdapter(new SearchResultAdapter(repositories));
    }

    public class ViewModel {
        private String query;

        public ViewModel(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    }
}
