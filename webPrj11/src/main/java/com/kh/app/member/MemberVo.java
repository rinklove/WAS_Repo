package com.kh.app.member;

public class MemberVo {

	private String id;
	private String pwd;
	private String pwd2;
	private String nick;
	
	public MemberVo(String id, String pwd, String pwd2, String nick) {
		this.id = id;
		this.pwd = pwd;
		this.pwd2 = pwd2;
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", nick=" + nick + "]";
	}

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	String getPwd() {
		return pwd;
	}

	void setPwd(String pwd) {
		this.pwd = pwd;
	}

	String getPwd2() {
		return pwd2;
	}

	void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	String getNick() {
		return nick;
	}

	void setNick(String nick) {
		this.nick = nick;
	}
	
}
