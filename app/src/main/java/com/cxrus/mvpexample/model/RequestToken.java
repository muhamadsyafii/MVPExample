package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

public class RequestToken {

    @SerializedName("request_token")
    private String requestToken;

    public RequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public String getRequestToken() {
        return requestToken;
    }

}