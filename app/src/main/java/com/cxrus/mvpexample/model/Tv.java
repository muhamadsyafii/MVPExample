package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

public class Tv {
    @SerializedName("original_name")
    String original_name;
    @SerializedName("backdrop_path")
    String backdrop_path;

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
