package test.vo;

public class BoardVo {
	
	private String title;
	private String content;
	@Override
	public String toString() {
		return "{\"title\":\""+title+"\",\"content\":\""+content+"\"}";
	}
	public BoardVo(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
	 
}
