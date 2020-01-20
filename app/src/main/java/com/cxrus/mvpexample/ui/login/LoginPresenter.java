package com.cxrus.mvpexample.ui.login;

import android.util.Log;

import com.cxrus.mvpexample.model.Login;
import com.cxrus.mvpexample.model.RequestToken;
import com.cxrus.mvpexample.model.Session;
import com.cxrus.mvpexample.model.Token;
import com.cxrus.mvpexample.network.ApiService;
import com.cxrus.mvpexample.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getReqToken() {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getReqToken().enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                mView.showLoading();
//                Log.d("getReqToken", "Token : " + response.body().getRequestToken());
                if (response.isSuccessful() && response.body() !=null){
                    mView.showReqToken(response.body());
                    mView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.d("getReqToken", "Failure" +t);
            }
        });
    }

    @Override
    public void getToken(Login login) {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getToken(login).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                mView.showLoading();
//                Log.d("getToken", "Token : " + response.body().getRequestToken());
                if (response.isSuccessful() && response.body() !=null){
                    mView.showToken(response.body());
                    mView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.d("getToken", "Failure" +t);
            }
        });
    }

    @Override
    public void getSessionId(RequestToken requestToken) {
        ApiService service = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        service.getSession(requestToken).enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {
                Log.d("LoginPresenter", "onResponse...");
                mView.showLoading();
//                Log.d("getSession", "Session : " + response.body().getSessionId());
                if (response.isSuccessful() && response.body() !=null){
                    mView.showSessionId(response.body());
                    mView.hideLoading();

                    Log.d("LoginPresenter", "true...");
                }
            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                Log.d("getSession", "Failure" +t);
                Log.d("LoginPresenter", "onFailure...");
            }
        });
    }

}
