package com.simplepeng.library.infiniteviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.simplepeng.library.base.BasePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InfiniteViewPagerAdapter extends BasePagerAdapter {

    public InfiniteViewPagerAdapter(Context context, String... imgUrls) {
        super(context, imgUrls);
        List<String> imgUrlList = new ArrayList<>();
        for (String imgUrl : imgUrls) {
            imgUrlList.add(imgUrl);
        }
        addViews(imgUrlList);
    }

    public InfiniteViewPagerAdapter(Context context, List<String> imgUrlList) {
        super(context, imgUrlList);
        addViews(imgUrlList);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getRealCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position % mViews.size());
        if (view.getParent() != null) {
            ((ViewPager) view
                    .getParent()).removeView(view);
        }
        container.addView(
                view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


}
