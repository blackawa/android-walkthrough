package jp.blackawa.example.githubrepositorysearcher;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jp.blackawa.example.githubrepositorysearcher.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        String query = getIntent().getExtras().get("query").toString();
        binding.setViewModel(new ViewModel(query));
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
