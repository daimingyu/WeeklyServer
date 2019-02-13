package com.weekly.bean;

public class User {
	String userId;
	String userName;
	String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.userId + '-' + this.userName + '-' + this.password;
	}
}
