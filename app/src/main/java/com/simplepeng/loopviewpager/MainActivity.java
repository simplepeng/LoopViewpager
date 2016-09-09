package com.simplepeng.loopviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.simplepeng.library.indicator.CircleIndicator;
import com.simplepeng.library.infiniteviewpager.InfiniteAdapter;
import com.simplepeng.library.loopviewpager.LoopViewPagerAdapter;
import com.simplepeng.library.loopviewpager.LoopViewpager;

public class MainActivity extends AppCompatActivity {

    private LoopViewpager viewPager;
    private CircleIndicator indicator;

    private ViewPager infiniteViewPager;
    private String[] imgUrls = {
//            "https://avatars1.githubusercontent.com/u/12198830?v=3&s=460",
            "https://avatars0.githubusercontent.com/u/66577?v=3&s=460",
            "https://avatars3.githubusercontent.com/u/2503423?v=3&s=460",
            "https://avatars1.githubusercontent.com/u/12198830?v=3&s=460",
//            "https://avatars0.githubusercontent.com/u/66577?v=3&s=460"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (LoopViewpager) findViewById(R.id.viewPager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);

        LoopViewPagerAdapter adapter = new LoopViewPagerAdapter(this);
        adapter.setDataFromUrl(imgUrls);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);


        infiniteViewPager = (ViewPager) findViewById(R.id.infiniteViewPager);
        InfiniteAdapter infiniteAdapter = new InfiniteAdapter(this);
        infiniteAdapter.setDataFromUrl(imgUrls);
        infiniteViewPager.setAdapter(infiniteAdapter);
        infiniteViewPager.setCurrentItem(500);
    }
}
