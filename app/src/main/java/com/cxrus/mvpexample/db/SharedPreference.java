package com.cxrus.mvpexample.db;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private String PREF_NAME = "UserPref";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private String SAVE_TOKEN = "SaveToken";

    public SharedPreference(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void save(String KEY_NAME, String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NAME, token);
        editor.commit();
    }

    public String getValueString(String KEY_NAME) {
        return preferences.getString(KEY_NAME, null);
    }

    public void clearSharedPreference() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

}
