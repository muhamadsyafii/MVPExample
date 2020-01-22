package com.cxrus.mvpexample.ui.tv;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.airbnb.lottie.LottieAnimationView;
import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.Results;
import com.cxrus.mvpexample.model.Tv;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment implements TvContract.View{

    private TvContract.Presenter mPresenter;
    private TvAdapter tvAdapter;

    @BindView(R.id.rv_tv)
    RecyclerView tvRecycleView;
    @BindView(R.id.lottie_loading_tv)
    LottieAnimationView animationView;


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        ButterKnife.bind(this, view);
        mPresenter = new TvPresenter(this);
        mPresenter.getTv();
        mPresenter.start();
        return view;
    }


    @Override
    public void initView() {
        tvAdapter = new TvAdapter(getContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        tvRecycleView.setLayoutManager(manager);
    }

    @Override
    public void showTv (List<Results> tvList) {
        tvRecycleView.setAdapter(tvAdapter);
        tvAdapter.setTvAdapter(tvList);
    }

    @Override
    public void showLoading() {
        animationView.playAnimation();
    }

    @Override
    public void hideLoading() {
        animationView.setVisibility(View.GONE);
    }
}
