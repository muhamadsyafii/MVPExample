package com.cxrus.mvpexample.network;

import com.cxrus.mvpexample.model.MovieItem;
import com.cxrus.mvpexample.model.TvItem;
import com.cxrus.mvpexample.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("movie/now_playing" + Constants.API_KEY)
    Call<MovieItem> getNowPlayingMovie();

    @GET("tv/airing_today" + Constants.API_KEY)
    Call<TvItem> getTvAiringToday();
}
