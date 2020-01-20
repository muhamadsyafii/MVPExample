package com.cxrus.mvpexample.ui.tv;

import com.cxrus.mvpexample.model.Tv;

import java.util.List;

public interface TvContract {
    interface View {
        void initView();
        void showTv(List<Tv> tvList);
        void showLoading();
        void hideLoading();
    }
    interface Presenter{
        void getTv();
        void start();
    }
}
