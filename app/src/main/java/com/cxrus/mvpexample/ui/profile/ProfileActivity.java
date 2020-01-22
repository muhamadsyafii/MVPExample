package com.cxrus.mvpexample.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.util.CustomToolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        CustomToolbar.setupToolbar(this);
    }
}
