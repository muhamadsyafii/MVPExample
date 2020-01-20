package com.cxrus.mvpexample.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.ui.movie.MovieFragment;
import com.cxrus.mvpexample.ui.tv.TvFragment;
import com.cxrus.mvpexample.util.ActivityUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView mBottomNavigationView;
    boolean isExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new MovieFragment(), R.id.fl_home);
        }
        initView();
    }



    private void initView() {
        mBottomNavigationView = findViewById(R.id.mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        selectActiveTabs(menuItem.getItemId());
        return true;
    }

    private void selectActiveTabs(int menuItem) {
        switch (menuItem){
            case R.id.nav_movie:
                ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new MovieFragment(), R.id.fl_home);
                break;
            case R.id.nav_tv:
                ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new TvFragment(), R.id.fl_home);
                break;
                default:

        }
    }

    @Override
    public void onBackPressed() {
        if (isExit) {
            super.onBackPressed();
        } else {
            isExit = true;
            Toast.makeText(this, "Press once again to close the app..", Toast.LENGTH_SHORT).show();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isExit = false;
                finish();
            }
        }, 2000);
    }



}
