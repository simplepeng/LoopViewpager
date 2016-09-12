package com.simplepeng.loopviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.simplepeng.library.indicator.CircleIndicator;
import com.simplepeng.library.infiniteviewpager.InfiniteViewPager;
import com.simplepeng.library.infiniteviewpager.InfiniteViewPagerAdapter;
import com.simplepeng.library.loopviewpager.LoopViewPagerAdapter;
import com.simplepeng.library.loopviewpager.LoopViewpager;

public class MainActivity extends AppCompatActivity {

    private LoopViewpager loopViewPager;
    private CircleIndicator loopViewPagerIndicator;

    private InfiniteViewPager infiniteViewPager;
    private CircleIndicator infiniteViewPagerIndicator;

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

        loopViewPager = (LoopViewpager) findViewById(R.id.loopViewPager);
        loopViewPagerIndicator = (CircleIndicator) findViewById(R.id.loopViewPagerIndicator);
        LoopViewPagerAdapter adapter = new LoopViewPagerAdapter(this, imgUrls);
        loopViewPager.setAdapter(adapter);
        loopViewPagerIndicator.setViewPager(loopViewPager);
//
        infiniteViewPager = (InfiniteViewPager) findViewById(R.id.infiniteViewPager);
        infiniteViewPagerIndicator =
                (CircleIndicator) findViewById(R.id.infiniteViewPagerIndicator);
        InfiniteViewPagerAdapter infiniteViewPagerAdapter = new InfiniteViewPagerAdapter(this, imgUrls);
        infiniteViewPager.setAdapter(infiniteViewPagerAdapter);
        infiniteViewPagerIndicator.setViewPager(infiniteViewPager);
    }
}
