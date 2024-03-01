package com.kh.app.board.vo;

public class BoardVo {
	private String no;
	private String categoryNo;
	private String categoryName;
	private String title;
	private String content;
	private String writerNo;
	private String writerNick;
	private Integer hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
	
	public BoardVo(String no, String categoryNo, String title, String content, String writerNo) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
	}

	public BoardVo(String no, String categoryNo, String title, String content, String writerNo, Integer hit,
			String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public BoardVo(String no, String categoryNo, String title, String content, String writerNo, String writerNick,
			Integer hit, String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.writerNick = writerNick;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	
	public BoardVo(String no, String categoryNo, String categoryName, String title, String content, String writerNo,
			String writerNick, Integer hit, String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.writerNick = writerNick;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}


	public BoardVo(String categoryNo, String title, String content, String writerNo) {
		super();
		this.categoryNo = categoryNo;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
	}

	public String getNo() {
		return no;
	}

	public String getCategoryNo() {
		return categoryNo;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriterNo() {
		return writerNo;
	}

	public String getWriterNick() {
		return writerNick;
	}
	
	public Integer getHit() {
		return hit;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", title="
				+ title + ", content=" + content + ", writerNo=" + writerNo + ", writerNick=" + writerNick + ", hit="
				+ hit + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	
	
}
