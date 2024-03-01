package com.kh.app.member;


public class MemberVo {
	
	private String memberId;
	private String memberPwd;
	private String memberPwd2;
	private String memberNick;
	
	public MemberVo(String memberId, String memberPwd, String memberPwd2, String memberNick) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberPwd2 = memberPwd2;
		this.memberNick = memberNick;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public String getMemberPwd2() {
		return memberPwd2;
	}

	public String getMemberNick() {
		return memberNick;
	}

	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPwd2=" + memberPwd2
				+ ", memberNick=" + memberNick + "]";
	}
	

}
