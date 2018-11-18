package com.mia.miablog.vo;

public class UserVO {
	private int idx;
	private String userId;
	private String email;
	private String userName;
	private String userPwd;
	private String regDate;
	private int userGrade;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getuserPwd() {
		return userPwd;
	}
	public void setuserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getregDate() {
		return regDate;
	}
	public void setregDate(String regDate) {
		this.regDate = regDate;
	}
	public int getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
}
