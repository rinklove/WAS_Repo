package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

public class BoardDao {

	public int upload(BoardVo board, Connection conn) throws SQLException {
		String query = "INSERT INTO BOARD(TITLE, CONTENT) VALUES (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

}
