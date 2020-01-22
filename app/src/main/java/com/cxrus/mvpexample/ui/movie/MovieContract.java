package com.cxrus.mvpexample.ui.movie;

import com.cxrus.mvpexample.model.Results;

import java.util.List;

public interface MovieContract {
    //view ini yang akan tampil pada activity
    /**
     * Untuk view ini semisal ada penambahan fugsi maka di buat di interface View dimana akan di tampilan pada activity
     */
    interface View {
        void initView();
        void showImage(List<Results> movieList);
        void showLoading();
        void hideLoading();
    }
    //Presenter ini adalah fungsi yang akan di jalankan
    /**
     * Jadi kalo semisal setiap ada penambahan fungsi pada activity (bisnis logic) maka di buat di presenter
     */
    interface Presenter{
        void getMovie();
        void Start();
    }
}
