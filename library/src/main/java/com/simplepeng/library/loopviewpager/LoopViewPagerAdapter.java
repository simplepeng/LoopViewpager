package com.simplepeng.library.loopviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.simplepeng.library.base.BasePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LoopViewPagerAdapter extends BasePagerAdapter {

    private static final String TAG = "LoopViewPagerAdapter";

    public LoopViewPagerAdapter(Context context, String... imgUrls) {
        super(context, imgUrls);
        List<String> imgUrlList = new ArrayList<>();
        for (String imgUrl : imgUrls) {
            imgUrlList.add(imgUrl);
        }
        addViews(addFirstAndEnd(imgUrlList));
    }

    public LoopViewPagerAdapter(Context context, List<String> imgUrlList) {
        super(context, imgUrlList);
        addViews(addFirstAndEnd(imgUrlList));
    }

    public List<String> addFirstAndEnd(List<String> imgUrlList) {
        String firstUrl = imgUrlList.get(0);
        String lastUrl = imgUrlList.get(imgUrlList.size() - 1);
        imgUrlList.add(0, lastUrl);
        imgUrlList.add(firstUrl);
        return imgUrlList;
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public int getRealCount() {
        return mViews.size() - 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}

