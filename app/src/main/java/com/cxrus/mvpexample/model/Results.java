package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    @SerializedName("results")
    List<MovieItem> results;

    public List<MovieItem> getResults() {
        return results;
    }

    public void setResults(List<MovieItem> results) {
        this.results = results;
    }
}
