package com.mia.miablog.vo;

public class AttachfileVO {
	private int idx;
	private String attach_file_org;
	private String attach_file;
	private int board_idx;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getAttach_file_org() {
		return attach_file_org;
	}
	public void setAttach_file_org(String attach_file_org) {
		this.attach_file_org = attach_file_org;
	}
	public String getAttach_file() {
		return attach_file;
	}
	public void setAttach_file(String attach_file) {
		this.attach_file = attach_file;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
}
