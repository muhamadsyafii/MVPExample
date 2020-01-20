package com.cxrus.mvpexample.network;

import com.cxrus.mvpexample.model.Login;
import com.cxrus.mvpexample.model.RequestToken;
import com.cxrus.mvpexample.model.Session;
import com.cxrus.mvpexample.model.Token;
import com.cxrus.mvpexample.model.MovieItem;
import com.cxrus.mvpexample.model.TvItem;
import com.cxrus.mvpexample.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("movie/now_playing" + Constants.API_KEY)
    Call<MovieItem> getNowPlayingMovie();

    @GET("tv/airing_today" + Constants.API_KEY)
    Call<TvItem> getTvAiringToday();

    @GET("authentication/token/new" + Constants.API_KEY)
    Call<Token> getReqToken();

    @POST("authentication/token/validate_with_login" + Constants.API_KEY)
    Call<Token> getToken(@Body Login login);

    @POST("authentication/session/new"+ Constants.API_KEY)
    Call<Session> getSession(@Body RequestToken requestToken);
}
