package com.cxrus.mvpexample.ui.fragment.tv;

import com.cxrus.mvpexample.model.Tv;

import java.util.List;

public interface TvContract {
    interface View {
        void initView();
        void showImage(List<Tv> tvList);
        void showLoading();
        void hideLoading();
    }
    interface Presenter{
        void getTv();
        void start();
    }
}
