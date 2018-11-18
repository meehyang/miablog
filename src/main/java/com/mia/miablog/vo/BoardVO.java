package com.mia.miablog.vo;

public class BoardVO {
	private int idx;
	private String title;
	private String content;
	private String insertDate;
	private int userIdx;
	private String userName;
	private int boardIdx;
	private String cate;
	private String attachFile;
	private int prevIdx;
	private int nextIdx;
	private int userGrade;
	
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
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
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public int getPrevIdx() {
		return prevIdx;
	}
	public void setPrevIdx(int prevIdx) {
		this.prevIdx = prevIdx;
	}
	public int getNextIdx() {
		return nextIdx;
	}
	public void setNextIdx(int nextIdx) {
		this.nextIdx = nextIdx;
	}
	public int getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
}
