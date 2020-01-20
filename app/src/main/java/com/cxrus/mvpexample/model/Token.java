package com.cxrus.mvpexample.model;


import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("expires_at")
    private String expiresAt;

    @SerializedName("success")
    private boolean success;

    @SerializedName("request_token")
    private String requestToken;

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public String getRequestToken() {
        return requestToken;
    }

}