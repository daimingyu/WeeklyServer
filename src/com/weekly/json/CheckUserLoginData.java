package com.weekly.json;

public class CheckUserLoginData {
	Boolean loginFlag;
	String userId;
	String userName;
	String password;
	public Boolean getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(Boolean loginFlag) {
		this.loginFlag = loginFlag;
	}
	public String getUserName() {
		return userName;
	}
	public CheckUserLoginData(Boolean loginFlag, String userId, String userName, String password) {
		super();
		this.loginFlag = loginFlag;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public CheckUserLoginData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
