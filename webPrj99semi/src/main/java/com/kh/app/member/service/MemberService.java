package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	private final MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}

	public int join(MemberVo member) throws Exception {
		//아이디 4~12 영문소문자+숫자 조합
		String memberId = member.getMemberId();
		if(!memberId.matches("[a-z0-9]{4,12}")) {
			throw new Exception("아이디를 올바르게 입력하세요");
		}
		//비밀번호 일치 여부체크
		if(!member.getMemberPwd().equals(member.getMemberPwd2())) {
			throw new Exception("비밀번호와 확인란이 다릅니다");
		}
		

		Connection con = JDBCTemplate.getConnection();
		
		int result = memberDao.join(member, con);
		
		if(result == 1)
			JDBCTemplate.commit(con);
		else 
			JDBCTemplate.close(con);
		
		return result;
	}

	public MemberVo login(MemberVo member) throws Exception {
		Connection con = JDBCTemplate.getConnection();
		
		MemberVo findMember = memberDao.login(member, con);
		
		JDBCTemplate.close(con);
		return findMember;
	}

	public String getIdOne(String inputId) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		String findId = memberDao.getIdOne(inputId, con);
		
		JDBCTemplate.close(con);
		return findId;
	}

}
