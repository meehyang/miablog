package com.mia.miablog.vo;

public class BoardVO {
	private int idx;
	private String title;
	private String content;
	private String insertDate;
	private int userIdx;
	private String userName;
	
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getinsertDate() {
		return insertDate;
	}
	public void setinsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getuserIdx() {
		return userIdx;
	}
	public void setuserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
}
