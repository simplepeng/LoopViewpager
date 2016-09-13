package com.simplepeng.library.infiniteviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 无限的viewpager
 */
public class InfiniteViewPager extends ViewPager {

    public OnPageChangeListener mOutOnPageChangeListener;
    private int realCount;

    public InfiniteViewPager(Context context) {
        this(context, null);
    }

    public InfiniteViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOnPageChangeListener(mOnPagerChangeListener);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        if (adapter instanceof InfiniteViewPagerAdapter) {
            realCount = ((InfiniteViewPagerAdapter) adapter).getRealCount();
            setCurrentItem(Integer.MAX_VALUE / 2);
        }
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        mOutOnPageChangeListener = listener;
    }

    private OnPageChangeListener mOnPagerChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset
                , int positionOffsetPixels) {
            if (mOutOnPageChangeListener != null) {
                mOutOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            int realPosition = position % realCount;
            Log.e("simple", realPosition + "=====realPosition");
            if (mOutOnPageChangeListener != null) {
                mOutOnPageChangeListener.onPageSelected(realPosition);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (mOutOnPageChangeListener != null) {
                mOutOnPageChangeListener.onPageScrollStateChanged(state);
            }
        }
    };


}
