package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieItem {
    @SerializedName("results")
    List<Results> results;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }
}
