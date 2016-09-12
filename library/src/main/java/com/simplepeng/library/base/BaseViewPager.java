package com.simplepeng.library.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 *
 */
public abstract class BaseViewPager extends ViewPager {

    public BaseViewPager(Context context) {
        this(context, null);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
