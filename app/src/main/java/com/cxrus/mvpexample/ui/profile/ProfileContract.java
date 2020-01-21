package com.cxrus.mvpexample.ui.profile;

import com.cxrus.mvpexample.model.Session;

public interface ProfileContract {
    interface View {
        void initView();
        void showAccount(Session session);
    }

    interface Presenter {
        void getAccount(Session session);
        void start();
    }
}
