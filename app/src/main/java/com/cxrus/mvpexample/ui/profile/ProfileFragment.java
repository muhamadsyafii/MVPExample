package com.cxrus.mvpexample.ui.profile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.Account;
import com.cxrus.mvpexample.model.Session;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileContract.View{

    private ProfileContract.Presenter presenter;
    private String session;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        presenter = new ProfilePresenter(this);
        presenter.start();

        return view;
    }

    @Override
    public void initView() {

    }

    @Override
    public void showAccount(Session session) {
        presenter.getAccount(session);
        showAccount(session);
        Log.d("ProfileFragment", "Session" + session.getSessionId());
    }

}
