package com.kh.app.member;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

public class MemberService {
	
	private final MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}

	public int join(MemberVo member) throws Exception {

		if(member.getMemberId().length() < 4) {	
			throw new Exception("아이디는 4글자 이상으로 입력해주세요");
		}
		
		if(member.getMemberPwd().length() < 4) {
			throw new Exception("비밀번호는 4글자 이상으로 입력해주세요");			
		}
		
		if(!member.getMemberPwd().equals(member.getMemberPwd2())){
			throw new Exception("비밀번호가 일치하지 않습니다");
		}

		if(member.getMemberNick().contains("관리자") || member.getMemberNick().contains("admin") || member.getMemberNick().contains("ADMIN")) {
			throw new Exception("관리자로 닉네임 설정이 불가능합니다.");			
		}
		Connection conn = JDBCTemplate.getConnection();
		
		int result = memberDao.join(member, conn);
		
		if(result == 1) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public MemberVo login(String id, String pwd) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo findMember = memberDao.login(id, pwd , conn);
		
		JDBCTemplate.close(conn);
		
		return findMember;
	}

}
