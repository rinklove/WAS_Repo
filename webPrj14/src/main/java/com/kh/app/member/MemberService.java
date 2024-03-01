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
		if(!member.getMemberPwd().equals(member.getMemberPwd2())) {
			throw new Exception("비밀번호가 일치하지 않습니다");
		}
		
		Connection con = JDBCTemplate.getConnection();
		
		int result  = memberDao.join(member, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		return result;
	}

	public MemberVo login(MemberVo member) throws Exception {
		Connection con = JDBCTemplate.getConnection();
		
		MemberVo findMember = memberDao.login(member, con);
		
		JDBCTemplate.close(con);
		return findMember;
	}

}
