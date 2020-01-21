package com.cxrus.mvpexample.ui.profile;

import android.util.Log;

import com.cxrus.mvpexample.model.Account;
import com.cxrus.mvpexample.model.Session;
import com.cxrus.mvpexample.network.ApiService;
import com.cxrus.mvpexample.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter implements ProfileContract.Presenter {
    private ProfileContract.View mView;

    public ProfilePresenter(ProfileContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getAccount(Session session) {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getAccount(session).enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {
                Log.d("ProfilePresenter", "OnRespone" + response.body());
                if (response.isSuccessful() && response.body() != null) {
                    mView.showAccount(response.body());
                }
            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                Log.d("ProfilePresenter", "Failure" +t);
                Log.d("ProfilePresenter", "onFailure...");

            }
        });
    }

    @Override
    public void start() {
        mView.initView();
    }
}
