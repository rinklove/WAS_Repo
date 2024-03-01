package com.kh.app.member;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

public class MemberService {
	
	private final MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}

	public int join(MemberVo memberVo) throws Exception {
		
		if(!memberVo.getPwd().equals(memberVo.getPwd2()))
			throw new Exception("비밀번호가 일치하지 않습니다");
		Connection conn = JDBCTemplate.getConnection();
		
		int result = memberDao.join(memberVo ,conn);
		
		if(result == 1)
			JDBCTemplate.commit(conn);
		else 
			JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}


}
