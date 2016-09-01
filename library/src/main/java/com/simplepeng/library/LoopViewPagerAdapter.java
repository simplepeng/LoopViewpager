package com.simplepeng.library;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LoopViewPagerAdapter extends PagerAdapter {

    private static final String TAG = "LoopViewPagerAdapter";

    private Context mContext;
    private List<View> mViews = new ArrayList<>();

    public LoopViewPagerAdapter(Context context) {
        this.mContext = context;
    }

    public void setDataFromUrl(String... imgUrls) {
        if (imgUrls == null || imgUrls.length == 0) {
            throw new NullPointerException("imgUrls must be not null and not empty");
        }
        List<String> imgUrlList = new ArrayList<>();
        for (String imgUrl : imgUrls) {
            imgUrlList.add(imgUrl);
        }
        setDataFromUrl(imgUrlList);
    }

    public void setDataFromUrl(List<String> imgUrlList) {
        if (imgUrlList == null || imgUrlList.isEmpty()) {
            throw new NullPointerException("imgUrls must be not null and not empty");
        }
        String firstUrl = imgUrlList.get(0);
        String lastUrl = imgUrlList.get(imgUrlList.size() - 1);
        imgUrlList.add(0, lastUrl);
        imgUrlList.add(firstUrl);
        for (String imgUrl : imgUrlList) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(mContext)
                    .load(imgUrl)
                    .into(imageView);
            mViews.add(imageView);
        }
    }

//    public void setDataFromView(List<View> views) {
//        if (views == null || views.isEmpty()) {
//            throw new NullPointerException("views must be not null and not empty");
//        }
//        ImageView firstImageView = (ImageView) views.get(0);
//        ImageView lastImageView = (ImageView) views.get(views.size() - 1);
//        ImageView firstView = new ImageView(mContext);
//        ImageView lastView = new ImageView(mContext);
//        lastView.setImageDrawable(firstImageView.getDrawable());
//        firstView.setImageDrawable(lastImageView.getDrawable());
//        mViews.add(0, lastImageView);
//        mViews.add(firstImageView);
//    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem==" + (position + 1));
//        position = position >= mViews.size() ? position - mViews.size() : position;
        View view = mViews.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d(TAG, "destroyItem==" + (position + 1));
        container.removeView((View) object);
//        position = position >= mViews.size() ? position - mViews.size() : position;
//        container.removeView(mViews.get(position));
    }
}

