package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieItem {
    @SerializedName("results")
    List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
