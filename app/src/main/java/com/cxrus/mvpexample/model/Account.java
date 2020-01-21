package com.cxrus.mvpexample.model;


import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("include_adult")
    private boolean includeAdult;

    @SerializedName("iso_3166_1")
    private String iso31661;

    @SerializedName("name")
    private String name;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("id")
    private int id;

    @SerializedName("iso_639_1")
    private String iso6391;

    @SerializedName("username")
    private String username;

    public void setIncludeAdult(boolean includeAdult) {
        this.includeAdult = includeAdult;
    }

    public boolean isIncludeAdult() {
        return includeAdult;
    }

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public String getIso31661() {
        return iso31661;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}