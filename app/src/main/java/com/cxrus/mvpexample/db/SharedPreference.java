package com.cxrus.mvpexample.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.cxrus.mvpexample.util.Constants;

public class SharedPreference {
    private static final String PREF_NAME = "UserPref";
    private static SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SharedPreference(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void save(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.KEY_REQUEST_TOKEN, token);
        editor.apply();
    }

    public void saveSession(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.KEY_SESSION_ID, token);
        editor.putBoolean(Constants.KEY_LOGIN, true);
        editor.apply();
    }

    public static String getRequestToken() {
        return preferences.getString(Constants.KEY_REQUEST_TOKEN, null);
    }

    public static boolean isLogin() {
        return preferences.getBoolean(Constants.KEY_LOGIN, false);
    }

    public void clearSharedPreference() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

}
