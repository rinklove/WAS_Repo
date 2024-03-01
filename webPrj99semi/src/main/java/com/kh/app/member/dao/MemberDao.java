package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	private String query;
	
	public int join(MemberVo member, Connection con) throws SQLException {
		query = "INSERT INTO MEMBER(NO, ID, PWD, NICK, PHONE, EMAIL, ADDRESS, HOBBYS) VALUES (SEQ_MEMBER_NO.NEXTVAL,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberNick());
		pstmt.setString(4, member.getPhone());
		pstmt.setString(5, member.getEmail());
		pstmt.setString(6, member.getAddress());
		pstmt.setString(7, member.getHobbys());
		
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

	public MemberVo login(MemberVo member, Connection con) throws SQLException {
		query = "SELECT M.* FROM MEMBER M WHERE M.ID = ? AND M.PWD = ?";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		ResultSet rs = pstmt.executeQuery();
		
		MemberVo findMember = null;
		if(rs.next()) {
			String findNo = rs.getString("NO");
			String findId = rs.getString("ID");
			String findPwd = rs.getString("PWD");
			String findNick = rs.getString("NICK");
			String findPhone = rs.getString("PHONE");
			String findEmail = rs.getString("EMAIL");
			String findAddress = rs.getString("ADDRESS");
			String findHobbys = rs.getString("HOBBYS");
			String findEnrollDate = rs.getString("ENROLL_DATE");
			String findModifyDate = rs.getString("MODIFY_DATE");
			String findStatus = rs.getString("STATUS");

			findMember =new MemberVo(findNo, findId, findPwd, findNick, findPhone, findEmail, findAddress, findHobbys, findEnrollDate, findModifyDate, findStatus);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return findMember;
	}

	public String getIdOne(String inputId, Connection con) throws SQLException {
		query = "SELECT M.ID FROM MEMBER M WHERE M.ID = ?";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, inputId);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String findId = rs.getString("ID");
			return findId;
		}
		return null;
	}

}
