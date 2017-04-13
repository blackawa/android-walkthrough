package jp.blackawa.moodkoro;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jp.blackawa.moodkoro.databinding.ActivityHistoryBinding;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ActivityHistoryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_history);
        binding.setGreet("Hello, world!");
    }
}
