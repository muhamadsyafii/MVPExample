package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("title")
    String title;
    @SerializedName("poster_path")
    String poster_path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
