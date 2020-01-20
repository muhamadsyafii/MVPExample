package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("title")
    String title;
    @SerializedName("poster_path")
    String poster_path;
    @SerializedName("release_date")
    String release_date;
    @SerializedName("overview")
    String overview;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

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
