package jp.blackawa.example.photogallery;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import jp.blackawa.example.photogallery.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.pagerDescriptions.setAdapter(new SlidePagerAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onBackPressed() {
        ViewPager pager = binding.pagerDescriptions;
        if (pager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            pager.setCurrentItem(pager.getCurrentItem());
        }
    }
}
