package com.cxrus.mvpexample.ui.movie;

import android.util.Log;

import com.cxrus.mvpexample.model.MovieItem;
import com.cxrus.mvpexample.network.ApiService;
import com.cxrus.mvpexample.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements MovieContract.Presenter{
    MovieContract.View mView;

    public MoviePresenter(MovieContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getMovie() {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getNowPlayingMovie().enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                Log.e("onRespone", "respone :" + response.body());
                mView.showLoading();
                if (response.isSuccessful() && response.body() !=null){
                    mView.showImage(response.body().getMovies());
                    mView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<MovieItem> call, Throwable t) {
                mView.hideLoading();
                Log.d("Movie Presenter", "Failure", t);
            }
        });
    }

    @Override
    public void Start() {
        mView.initView();
    }
}
