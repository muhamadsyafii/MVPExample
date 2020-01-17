package com.cxrus.mvpexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.Movie;

import java.util.List;

public class MovieActivity extends AppCompatActivity implements MovieContract.View {

    private MovieContract.Presenter presenter;
    private RecyclerView mRecyceview;
    private MovieAdapter movieAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MoviePresenter(this);
        presenter.Start();
        presenter.getMovie();

    }

    @Override
    public void initView() {
        mRecyceview = findViewById(R.id.rv_movie);
        progressBar = findViewById(R.id.progressBar);
        movieAdapter = new MovieAdapter(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecyceview.setLayoutManager(manager);


    }

    @Override
    public void showImage(List<Movie> movieList) {
        movieAdapter.setMovieAdapter(movieList);
        mRecyceview.setAdapter(movieAdapter);

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);

    }
}
