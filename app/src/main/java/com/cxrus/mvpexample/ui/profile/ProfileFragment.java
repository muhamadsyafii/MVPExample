package com.cxrus.mvpexample.ui.profile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.db.SharedPreference;
import com.cxrus.mvpexample.model.Account;
import com.cxrus.mvpexample.model.Session;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements ProfileContract.View{

    private ProfileContract.Presenter presenter;
    private String session;
    private SharedPreference sharedPreference;
    @BindView(R.id.btn_Logout)
    Button btnLogout;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        sharedPreference = new SharedPreference(getContext());
        presenter = new ProfilePresenter(this);
        presenter.start();
        return view;
    }

    @Override
    public void initView() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreference.clearSharedPreference();
                closefragment();
            }
        });
    }
    private void closefragment() {
        if (getActivity() !=null){
            getActivity().finish();
        }
    }
    @Override
    public void showAccount(Session session) {
        presenter.getAccount(session);
        showAccount(session);
        Log.d("ProfileFragment", "Session" + session.getSessionId());
    }

}
