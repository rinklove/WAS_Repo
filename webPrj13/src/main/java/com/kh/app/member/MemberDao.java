package com.kh.app.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

public class MemberDao {
	private String query;
	
	public int join(MemberVo member, Connection conn) throws SQLException {
		query = "INSERT INTO MEMBER(ID, PWD, NICK) VALUES (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberNick());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

	public MemberVo login(String id, String pwd, Connection conn) throws Exception {
		query = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo findMember = null;
		if(rs.next()) {
			String findId = rs.getString("ID");
			String findPwd = rs.getString("PWD");
			String findNick = rs.getString("NICK");
			
			findMember = new MemberVo(findId, findPwd, null, findNick);
		}
		
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(rs);
		return findMember;
	}

}
