package com.simplepeng.library.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class BasePagerAdapter extends PagerAdapter {

    protected Context mContext;
    protected List<View> mViews = new ArrayList<>();

    public BasePagerAdapter(Context context, String... imgUrls) {
        if (imgUrls == null || imgUrls.length == 0) {
            throw new NullPointerException("imgUrls must be not null and not empty");
        }
        this.mContext = context;
    }

    public BasePagerAdapter(Context context, List<String> imgUrlList) {
        if (imgUrlList == null || imgUrlList.isEmpty()) {
            throw new NullPointerException("imgUrls must be not null and not empty");
        }
        this.mContext = context;
    }

    public abstract int getRealCount();

    protected void addViews(List<String> imgUrlList) {
        for (String imgUrl : imgUrlList) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(mContext)
                    .load(imgUrl)
                    .into(imageView);
            mViews.add(imageView);
        }
    }
}
