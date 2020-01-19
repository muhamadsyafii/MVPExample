package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvItem {
    @SerializedName("results")
    List<Tv> tv;

    public List<Tv> getTv() {
        return tv;
    }

    public void setTv(List<Tv> tv) {
        this.tv = tv;
    }
}
