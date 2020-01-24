package com.cxrus.mvpexample.ui.home;

import android.util.Log;

import com.cxrus.mvpexample.model.Results;
import com.cxrus.mvpexample.network.ApiService;
import com.cxrus.mvpexample.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeContract.Presenter {

    HomeContract.View mView;

    public HomePresenter(HomeContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getNowPlaying() {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getNowPlaying().enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
//                mView.showLoading();
                Log.d("HomePresenter", "NowPlaying" +response.body());

                if (response.isSuccessful() && response.body() !=null){
                    mView.showNowPlaying(response.body().getResults());
//                    mView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });
    }

    @Override
    public void getTopRated() {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getTopRated().enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Log.d("HomePresenter", "TopRated" +response.body());
                if (response.isSuccessful() && response.body() !=null){
                    mView.showTopRated(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });
    }

    @Override
    public void getPopular() {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getPopular().enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Log.d("HomePresenter", "Popular" +response.body());
                if (response.isSuccessful() && response.body() !=null){
                    mView.showPopular(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });
    }

    @Override
    public void getUpcoming() {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getUpcoming().enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Log.d("HomePresenter", "Upcoming" +response.body());
                if (response.isSuccessful() && response.body() !=null){
                    mView.showUpcoming(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });

    }

    @Override
    public void start() {
        mView.initView();
    }
}
