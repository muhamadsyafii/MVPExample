package com.cxrus.mvpexample.ui.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.MovieItem;
import com.cxrus.mvpexample.util.ActivityUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeContract.View {

    HomeContract.Presenter presenter;

    @BindView(R.id.mRecyclerViewNowPlaying)
    RecyclerView mRecyclerViewNowPlaying;
    @BindView(R.id.mRecyclerViewTopRated)
    RecyclerView mRecyclerViewTopRated;
    @BindView(R.id.mRecyclerViewPopular)
    RecyclerView mRecyclerViewPopular;
    @BindView(R.id.mHomeSlider)
    ViewPager mHomeSlider;

    NowPlayingAdapter nowPlayingAdapter;
    TopRatedAdapter topRatedAdapter;
    PopularAdapter popularAdapter;
    UpcomingAdapter upcomingAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "Ini Home Fragment", Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        presenter = new HomePresenter(this);
        presenter.start();
        presenter.getNowPlaying();
        presenter.getPopular();
        presenter.getUpcoming();
        presenter.getTopRated();
        return root;
    }

    @Override
    public void initView() {
        //inisialisasi
        nowPlayingAdapter = new NowPlayingAdapter(getContext());
        RecyclerView.LayoutManager mNowPlaying = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mRecyclerViewNowPlaying.setLayoutManager(mNowPlaying);

        topRatedAdapter = new TopRatedAdapter(getContext());
        RecyclerView.LayoutManager mTopRated = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mRecyclerViewTopRated.setLayoutManager(mTopRated);

        popularAdapter = new PopularAdapter(getContext());
        RecyclerView.LayoutManager mPopular = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mRecyclerViewPopular.setLayoutManager(mPopular);

        upcomingAdapter = new UpcomingAdapter(getContext());
        mHomeSlider.setClipToPadding(false);
        mHomeSlider.setPadding((int) ActivityUtils.convertDpToPixel(16, getContext()), 0, (int) ActivityUtils.convertDpToPixel(16, getContext()), 0);
        mHomeSlider.setPageMargin((int) ActivityUtils.convertDpToPixel(8, getContext()));


    }

    @Override
    public void showNowPlaying(List<MovieItem> nowPlayingList) {
        nowPlayingAdapter.setNowPlayingAdapter(nowPlayingList);
        mRecyclerViewNowPlaying.setAdapter(nowPlayingAdapter);
    }

    @Override
    public void showTopRated(List<MovieItem> topRatedList) {
        topRatedAdapter.setTopRatedAdapter(topRatedList);
        mRecyclerViewTopRated.setAdapter(topRatedAdapter);


    }

    @Override
    public void showPopular(List<MovieItem> popularList) {
        popularAdapter.setPopularAdapter(popularList);
        mRecyclerViewPopular.setAdapter(popularAdapter);
    }

    @Override
    public void showUpcoming(List<MovieItem> upComingList) {
        upcomingAdapter.setUpcomingAdapter(upComingList);
        mHomeSlider.setAdapter(upcomingAdapter);
    }

    @Override
    public void showLoading() {
//        animationView.playAnimation();
    }

    @Override
    public void hideLoading() {
//        animationView.setVisibility(View.GONE);
    }
}
