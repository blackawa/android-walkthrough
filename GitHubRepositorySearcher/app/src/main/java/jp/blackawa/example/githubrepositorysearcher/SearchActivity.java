package jp.blackawa.example.githubrepositorysearcher;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jp.blackawa.example.githubrepositorysearcher.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        binding.setViewModel(new ViewModel(this));
    }

    public class ViewModel {
        private Context context;

        public ViewModel(Context context) {
            this.context = context;
        }

        public void onClickSearchButton() {
            String query = binding.editTextQuery.getText().toString();
            Intent intent = new Intent(context, ResultActivity.class);
            intent.putExtra("query", query);
            startActivity(intent);
        }
    }
}
