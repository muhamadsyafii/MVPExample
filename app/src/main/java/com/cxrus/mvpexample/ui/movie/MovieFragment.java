package com.cxrus.mvpexample.ui.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.Results;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements MovieContract.View{

    private MovieContract.Presenter presenter;
    private MovieAdapter movieAdapter;

    @BindView(R.id.rv_movie)
    RecyclerView movieRecycleView;
//    @BindView(R.id.mProgressBarMovie)
//    ProgressBar mProgressBar;
    @BindView(R.id.lottie_loading)
    LottieAnimationView animationView;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this, view);
        presenter = new MoviePresenter(this);
        presenter.getMovie();
        presenter.Start();
        return view;
    }

    @Override
    public void initView() {
        movieAdapter = new MovieAdapter(getContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        movieRecycleView.setLayoutManager(manager);
    }

    @Override
    public void showImage(List<Results> movieList) {
        movieAdapter.setMovieAdapter(movieList);
        movieRecycleView.setAdapter(movieAdapter);
    }

    @Override
    public void showLoading() {
//        mProgressBar.setVisibility(View.VISIBLE);
        animationView.playAnimation();
    }

    @Override
    public void hideLoading() {
//        mProgressBar.setVisibility(View.GONE);
        animationView.setVisibility(View.GONE);
    }
}
