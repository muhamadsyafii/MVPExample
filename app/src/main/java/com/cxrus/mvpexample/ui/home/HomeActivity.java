package com.cxrus.mvpexample.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.db.SharedPreference;
import com.cxrus.mvpexample.ui.profile.ProfileActivity;
import com.cxrus.mvpexample.util.ActivityUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class HomeActivity extends AppCompatActivity {

    SharedPreference sharedPreference;
    private BottomNavigationView mBottomNavigationView;
    boolean isExit = false;
    @BindView(R.id.btnAccount)
    ImageView btnAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreference = new SharedPreference(this);
        ButterKnife.bind(this);
        ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new HomeFragment(), R.id.fl_home);

        onClick();
    }


    private void onClick() {
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
//                ActivityOptions options = ActivityOptions.makeCustomAnimation(HomeActivity.this, R.anim.anim_left_to_right, R.anim.anim_right_to_left);
//                                ActivityUtils.openActivity(HomeActivity.this, ProfileActivity.class);
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                overridePendingTransition(R.anim.anim_left_to_right, R.anim.anim_right_to_left);
            }
        });
    }

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                    selectActiveTabs(menuItem.getItemId());
//                    return true;
//                }
//            };

//    private void selectActiveTabs(int menuItem) {
//        switch (menuItem) {
//            case R.id.nav_movie:
//                ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new MovieFragment(), R.id.fl_home);
//                fm.beginTransaction().hide(active).show(fragment1).commit();
//                active = fragment1;
//                return;
//            case R.id.nav_tv:
//                ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new TvFragment(), R.id.fl_home);
//                fm.beginTransaction().hide(active).show(fragment2).commit();
//                active = fragment2;
//                break;
//            case R.id.nav_account:
//                if (SharedPreference.isLogin()) {
//                    ActivityUtils.openActivity(this, LoginActivity.class);
//                } else {
//                    ActivityUtils.replaceFragmentActivity(getSupportFragmentManager(), new ProfileFragment(), R.id.fl_home);
//                }
//                fm.beginTransaction().hide(active).show(fragment3).commit();
//                active = fragment3;
//                break;
//            default:
//
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.bottom_navigation_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public void onBackPressed() {
        if (isExit) {
            super.onBackPressed();
        } else {
            isExit = true;
            Toasty.info(this, "Press once again to close the app..", Toasty.LENGTH_SHORT).show();
//            Toast.makeText(this, "Press once again to close the app..", Toast.LENGTH_SHORT).show();
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
