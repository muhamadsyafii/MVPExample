package com.cxrus.mvpexample.model;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("password")
	private String password;

	@SerializedName("request_token")
	private String requestToken;

	@SerializedName("username")
	private String username;

	public Login(String username, String password, String requestToken) {
		this.password = password;
		this.requestToken = requestToken;
		this.username = username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setRequestToken(String requestToken){
		this.requestToken = requestToken;
	}

	public String getRequestToken(){
		return requestToken;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

}