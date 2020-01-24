package com.cxrus.mvpexample.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.MovieItem;

import java.util.List;

public class UpcomingAdapter extends PagerAdapter {
    Context context;
    private List<MovieItem> pagerList;

    public UpcomingAdapter(Context context) {
        this.context = context;
    }

    public void setUpcomingAdapter(List<MovieItem> pagerList) {
        this.pagerList = pagerList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return pagerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        try {
            MovieItem item = pagerList.get(position);
            View view = LayoutInflater.from(context).inflate(R.layout.item_homeslider, container, false);
            ImageView mBannerImage = view.findViewById(R.id.mBannerImage);
            Glide.with(context).load("https://image.tmdb.org/t/p/w500" + item.getBackdropPath()).into(mBannerImage);
            container.addView(view);
            return view;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return container;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
