package com.cxrus.mvpexample.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cxrus.mvpexample.db.SharedPreference;
import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.Login;
import com.cxrus.mvpexample.model.RequestToken;
import com.cxrus.mvpexample.model.Session;
import com.cxrus.mvpexample.model.Token;
import com.cxrus.mvpexample.ui.home.HomeActivity;
import com.cxrus.mvpexample.util.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.et_username)
    EditText mUsername;
    @BindView(R.id.et_password)
    EditText mPassword;
    @BindView(R.id.tv_warningUsername)
    TextView warningUsername;
    @BindView(R.id.tv_warningPassword)
    TextView warningPassword;
    @BindView(R.id.mProgressBarLogin)
    ProgressBar mProgressBar;
    @BindView(R.id.btn_Login)
    Button btnLogin;

    private LoginContract.Presenter mPresenter;
    private SharedPreference sharedPreference;
    private Login login;
    private RequestToken requestToken;
    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreference = new SharedPreference(this);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
        mPresenter.getReqToken();
        mProgressBar.setVisibility(View.GONE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                String tokens = sharedPreference.getValueString("REQ_TOKEN");

                if (username.isEmpty() && password.isEmpty()) {
                    warningUsername.setVisibility(View.VISIBLE);
                    warningPassword.setVisibility(View.VISIBLE);
                } else {
                    login = new Login(username, password, tokens);
                    mPresenter.getToken(login);
                    mPresenter.getSessionId(requestToken);

                    Log.d("LoginActivity", "onClick...");
                }

            }
        });
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Something is wrong....", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showReqToken(Token token) {
        String reqToken = token.getRequestToken();
        requestToken = new RequestToken(reqToken);
        sharedPreference.save("REQ_TOKEN", reqToken);

        Log.d("LoginActivity", "showReqToken : " + token.getRequestToken());
    }

    @Override
    public void showToken(Token token) {
        Log.d("LoginActivity", "showToken : " + token.getRequestToken());
    }

    @Override
    public void showSessionId(Session session) {
        sessionId = session.getSessionId();
        sharedPreference.save("SESSION", sessionId);

        if (session.isSuccess()) {
            ActivityUtils.openActivity(this, HomeActivity.class);
            finish();
        } else {
            loginFailed();
        }

        Log.d("LoginActivity", "showSessionId : " + sessionId);
    }

}
