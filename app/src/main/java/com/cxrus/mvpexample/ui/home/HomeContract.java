package com.cxrus.mvpexample.ui.home;

import com.cxrus.mvpexample.model.MovieItem;

import java.util.List;

public interface HomeContract {

    interface View{
        void initView();
        void showNowPlaying(List<MovieItem> nowPlayingList );
        void showTopRated(List<MovieItem> topRatedList );
        void showPopular(List<MovieItem> popularList );
        void showUpcoming(List<MovieItem> upComingList );
        void showLoading();
        void hideLoading();

    }
    interface Presenter{
        void getNowPlaying();
        void getTopRated();
        void getPopular();
        void getUpcoming();
        void start();
    }
}
