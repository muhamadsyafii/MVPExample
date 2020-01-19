package com.cxrus.mvpexample.ui.fragment.tv;

import android.util.Log;

import com.cxrus.mvpexample.model.Results;
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
        service.getTvAiringToday().enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Log.d("onResponeTv","Respone"+ response.body());
                mView.showLoading();
                if (response.isSuccessful() && response.body() !=null){
//                    mView.showImage(response.body().getTv());
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                mView.hideLoading();
            }
        });

    }

    @Override
    public void start() {
        mView.initView();
    }
}
