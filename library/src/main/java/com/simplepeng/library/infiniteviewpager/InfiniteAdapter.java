package com.simplepeng.library.infiniteviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InfiniteAdapter extends PagerAdapter {

    private Context mContext;
    private List<View> mViews = new ArrayList<>();

    public InfiniteAdapter(Context context) {
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
//        String firstUrl = imgUrlList.get(0);
//        String lastUrl = imgUrlList.get(imgUrlList.size() - 1);
//        imgUrlList.add(0, lastUrl);
//        imgUrlList.add(firstUrl);
        for (String imgUrl : imgUrlList) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(mContext)
                    .load(imgUrl)
                    .into(imageView);
            mViews.add(imageView);
        }
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mViews.get(position % mViews.size()).getParent() != null) {
            ((ViewPager) mViews.get(position % mViews.size())
                    .getParent()).removeView(mViews.get(position
                    % mViews.size()));
        }
        ((ViewPager) container).addView(
                mViews.get(position % mViews.size()), 0);
        return mViews.get(position % mViews.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
