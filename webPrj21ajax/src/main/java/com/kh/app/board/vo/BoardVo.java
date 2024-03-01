package com.kh.app.board.vo;

public class BoardVo {

	private String boardNo;
	private String title;
	private String content
	;
	public BoardVo(String boardNo, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}
	
	public String getBoardNo() {
		return boardNo;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
		return "BoardVo [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
}
