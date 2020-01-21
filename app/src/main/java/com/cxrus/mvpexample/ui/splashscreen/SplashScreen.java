package com.cxrus.mvpexample.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.db.SharedPreference;
import com.cxrus.mvpexample.ui.home.HomeActivity;
import com.cxrus.mvpexample.ui.login.LoginActivity;
import com.cxrus.mvpexample.util.ActivityUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class SplashScreen extends AppCompatActivity {
    private SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPreference = new SharedPreference(this);

        if (!sharedPreference.isLogin()) {
            ActivityUtils.openActivity(this, LoginActivity.class);
            finish();
        } else {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    ActivityUtils.openActivity(SplashScreen.this, HomeActivity.class);
                    finish();
                }
            }, 3000);
        }
    }
}
