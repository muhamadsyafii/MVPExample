package com.cxrus.mvpexample.ui.tv;

import android.util.Log;

import com.cxrus.mvpexample.model.MovieItem;
import com.cxrus.mvpexample.model.Results;
import com.cxrus.mvpexample.model.TvItem;
import com.cxrus.mvpexample.network.ApiService;
import com.cxrus.mvpexample.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvPresenter implements TvContract.Presenter{

    TvContract.View mView;

    public TvPresenter(TvContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getTv() {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getTvAiringToday().enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                Log.d("onResponeTv","Respone"+ response.body());
                mView.showLoading();
                if (response.isSuccessful() && response.body() !=null){
                    mView.showTv(response.body().getResults());
                    mView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<MovieItem> call, Throwable t) {
                Log.d("onFailureTv","Failure"+ t);
            }
        });

    }

    @Override
    public void start() {
        mView.initView();
    }
}
