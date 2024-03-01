package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

public class MemberDao {

	public int join(MemberVo memberVo, Connection conn) throws SQLException {
		String query = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberVo.getId());
		pstmt.setString(2, memberVo.getPwd());
		pstmt.setString(3, memberVo.getNick());
		
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		
		return result;
	}


}
