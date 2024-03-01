package com.kh.app.board.vo;

public class CategoryVo {

	private String no;
	private String categoryName;
	
	public CategoryVo(String no, String categoryName) {
		super();
		this.no = no;
		this.categoryName = categoryName;
	}
	
	public String getNo() {
		return no;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", categoryName=" + categoryName + "]";
	}
}
