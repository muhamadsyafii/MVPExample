package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

public class Tv {
    @SerializedName("original_name")
    String original_name;
    @SerializedName("backdrop_path")
    String backdrop_path;
    @SerializedName("overview")
    String overview;
    @SerializedName("first_air_date")
    String first_air_date;

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

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
