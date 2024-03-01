package com.kh.app.member.vo;

public class MemberVo {
	
	private String no;
	private String memberId;
	private String memberPwd;
	private String memberPwd2;
	private String memberNick;
	private String phone;
	private String email;
	private String address;
	private String hobbys;
	private String enrollDate;
	private String modifyDate;
	private String status;
	


	public MemberVo(String no, String memberId, String memberPwd, String memberNick, String phone, String email,
			String address, String hobbys, String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNick = memberNick;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.hobbys = hobbys == null ? "" : hobbys;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public MemberVo(String memberId, String memberPwd, String memberPwd2, String memberNick, String phone, String email,
			String address, String hobbys) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberPwd2 = memberPwd2;
		this.memberNick = memberNick;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.hobbys = hobbys == null ? "" : hobbys;
	}
	
	public MemberVo(String memberId, String memberPwd) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
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
	
	public String getNo() {
		return no;
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

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getHobbys() {
		return hobbys;
	}

	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPwd2=" + memberPwd2
				+ ", memberNick=" + memberNick + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", hobbys=" + hobbys + "]";
	}
	
	
}
