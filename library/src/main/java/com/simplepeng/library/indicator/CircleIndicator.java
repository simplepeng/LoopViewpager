package com.simplepeng.library.indicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.simplepeng.library.loopviewpager.LoopViewPagerAdapter;
import com.simplepeng.library.loopviewpager.LoopViewpager;
import com.simplepeng.library.R;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class CircleIndicator extends LinearLayout implements ViewPager.OnPageChangeListener {

    private final String TAG = "CircleIndicator";
    private List<View> rbList = new ArrayList<>();
    private LoopViewpager mViewPager;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    int margin = (int) getResources().getDimension(R.dimen.indicator_margin);

    public CircleIndicator(Context context) {
        this(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER);

    }

    public void setViewPager(ViewPager viewPager) {
        int count = 0;
        if (viewPager == null) {
            return;
        }
        if (viewPager.getAdapter() == null) {
            throw new NullPointerException("adapter of view must be not null");
        }
        if (viewPager instanceof LoopViewpager) {
            mViewPager = (LoopViewpager) viewPager;
            count = ((LoopViewPagerAdapter) mViewPager.getAdapter()).getRealCount();
        }

        if (count == 0) {
            return;
        }

        for (int i = 0; i < count; i++) {
            ImageView iv = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout
                    .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(margin, margin, margin, margin);
            iv.setLayoutParams(layoutParams);

            iv.setBackgroundDrawable(getResources().getDrawable(R.drawable.indicatorselector));

            rbList.add(i, iv);
            this.addView(iv, i);
        }
//        requestLayout();
        rbList.get(0).setSelected(true);
        mViewPager.setOnPageChangeListener(this);
    }

    private int curPosition = 0;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        Log.e(TAG, "onPageSelected: " + position);
        if (curPosition == position) {
            return;
        }
        rbList.get(position).setSelected(true);
        rbList.get(curPosition).setSelected(false);
        curPosition = position;
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrollStateChanged(state);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }
}
