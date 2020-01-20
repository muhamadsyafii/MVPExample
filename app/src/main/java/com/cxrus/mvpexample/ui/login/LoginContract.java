package com.cxrus.mvpexample.ui.login;

import com.cxrus.mvpexample.model.Login;
import com.cxrus.mvpexample.model.RequestToken;
import com.cxrus.mvpexample.model.Session;
import com.cxrus.mvpexample.model.Token;

public interface LoginContract {
    interface View{
        void showLoading();
        void hideLoading();
        void loginFailed();
        void showReqToken(Token token);
        void showToken(Token token);
        void showSessionId(Session session);
    }
    interface Presenter{
        void getReqToken();
        void getToken(Login login);
        void getSessionId(RequestToken requestToken);
    }
}
