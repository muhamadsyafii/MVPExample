package com.cxrus.mvpexample.ui.fragment.tv;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cxrus.mvpexample.R;
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
    @BindView(R.id.mProgressBarTv)
    ProgressBar mProgressBar;


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
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        tvRecycleView.setLayoutManager(manager);
    }

    @Override
    public void showImage(List<Tv> tvList) {
        tvRecycleView.setAdapter(tvAdapter);
        tvAdapter.setTvAdapter(tvList);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }
}
