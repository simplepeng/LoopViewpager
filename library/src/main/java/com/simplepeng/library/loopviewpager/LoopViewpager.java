package com.simplepeng.library.loopviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 循环的viewpager
 */
public class LoopViewpager extends ViewPager {

    private static final String TAG = "LoopViewpager";

    private OnPageChangeListener mOutOnPageChangeListener;

    public LoopViewpager(Context context) {
        this(context, null);
    }

    public LoopViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOnPageChangeListener(mOnPagerChangeListener);
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        mOutOnPageChangeListener = listener;
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        setCurrentItem(1, false);
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
            int realPosition = position;
            if (mOutOnPageChangeListener != null) {
                int count = LoopViewpager.this.getAdapter().getCount();
                int currentPosition = LoopViewpager.this.getCurrentItem();
                if (currentPosition == 0) {
                    realPosition = count - 2;
                } else if (currentPosition == count - 1) {
                    realPosition = 1;
                }
                mOutOnPageChangeListener.onPageSelected(realPosition - 1);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                int count = LoopViewpager.this.getAdapter().getCount();
                int currentPosition = LoopViewpager.this.getCurrentItem();
                if (currentPosition == 0) {
                    LoopViewpager.this.setCurrentItem(count - 2, false);
                } else if (currentPosition == count - 1) {
                    LoopViewpager.this.setCurrentItem(1, false);
                }
            }
            if (mOutOnPageChangeListener != null) {
                mOutOnPageChangeListener.onPageScrollStateChanged(state);
            }
        }
    };

}
