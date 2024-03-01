package com.kh.app.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.page.vo.PageVo;

public class BoardDao {

	private String query;
	
	public List<BoardVo> getBoardList(PageVo pageVo, Connection con) throws SQLException {
		query = "SELECT A.*, C.NAME CATEGORY_NAME, M.NICK WRITER_NICK FROM ( SELECT ROW_NUMBER() OVER(ORDER BY B.ENROLL_DATE DESC) RNUM, B.* FROM BOARD B WHERE B.STATUS = 'O' ) A INNER JOIN MEMBER M ON A.WRITER_NO = M.NO INNER JOIN CATEGORY C ON A.CATEGORY_NO = C.NO WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(1, pageVo.getStartRow());
		pstmt.setInt(2, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("CATEGORY_NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			int hit = rs.getInt("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			boardList.add(new BoardVo(no, categoryNo, categoryName, title, content, writerNo, writerNick, hit, enrollDate, modifyDate, status));
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return boardList;
	}
	
	
	public int addBoard(BoardVo board, Connection con) throws SQLException {
		query = "INSERT INTO BOARD(NO, CATEGORY_NO, TITLE, CONTENT, WRITER_NO) VALUES (SEQ_BOARD_NO.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, board.getCategoryNo());
		pstmt.setString(2, board.getTitle());
		pstmt.setString(3, board.getContent());
		pstmt.setString(4, board.getWriterNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}


	public BoardVo getOne(String no, Connection con) throws SQLException {
		query = "SELECT B.*, M.NICK WRITER_NICK, C.NAME CATEGORY_NAME FROM BOARD B INNER JOIN MEMBER M ON B.WRITER_NO = M.NO INNER JOIN CATEGORY C ON B.CATEGORY_NO = C.NO WHERE B.NO =? AND B.STATUS = 'O'";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		BoardVo findBoard = null;
		if(rs.next()) {
			String findNo = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("CATEGORY_NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			Integer hit = rs.getInt("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			findBoard = new BoardVo(findNo, categoryNo, categoryName, title, content, writerNo, writerNick, hit, enrollDate, modifyDate, status);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return findBoard;
	}


	public int increaseHit(String no, Connection con) throws SQLException {
		query = "UPDATE BOARD SET HIT = HIT+1 WHERE NO = ? AND STATUS = 'O'";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}


	public int updateStatus(String no, Connection con) throws SQLException {
		query ="UPDATE BOARD SET STATUS = 'X'  WHERE NO = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
		
	}


	public int getTotalBoardCount(Connection con) throws SQLException {
		query = "SELECT COUNT(NO) COUNT FROM BOARD WHERE STATUS = 'O'";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		if(rs.next()) {
			count = rs.getInt("COUNT");
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return count;
	}


	public int editBoard(BoardVo board, Connection con) throws SQLException {
		query = "UPDATE BOARD SET TITLE =?, CATEGORY_NO =?,CONTENT = ?  WHERE NO= ? AND STATUS = 'O'";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getCategoryNo());
		pstmt.setString(3, board.getContent());
		pstmt.setString(4, board.getNo());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}


	public List<CategoryVo> getAllCategory(Connection con) throws SQLException {
		query ="SELECT * FROM CATEGORY";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryName = rs.getString("NAME");
			
			list.add(new CategoryVo(no, categoryName));
		}
		return list;
	}
	
	public int getTotalBoardCountBySearch(Map<String, String> map, Connection con) throws SQLException {
		query = "SELECT COUNT(NO) COUNT FROM BOARD WHERE STATUS = 'O' AND " + map.get("searchType").toUpperCase() + " LIKE '%'|| ? ||'%' ";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,  map.get("searchValue"));
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		if(rs.next()) {
			count = rs.getInt("COUNT");
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return count;
	}

	public List<BoardVo> getBoardListBySearch (Map<String, String> map,  PageVo pageVo, Connection con) throws SQLException {
		query = "SELECT A.*, C.NAME CATEGORY_NAME, M.NICK WRITER_NICK FROM ( SELECT ROW_NUMBER() OVER(ORDER BY B.ENROLL_DATE DESC) RNUM, B.* FROM BOARD B WHERE B.STATUS = 'O' AND B." + map.get("searchType").toUpperCase() + " LIKE '%'|| ? ||'%') A INNER JOIN MEMBER M ON A.WRITER_NO = M.NO INNER JOIN CATEGORY C ON A.CATEGORY_NO = C.NO WHERE  A.STATUS = 'O' AND A." + map.get("searchType").toUpperCase() + " LIKE '%'|| ? ||'%' AND RNUM BETWEEN ? AND ? ORDER BY A.ENROLL_DATE DESC";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1,  map.get("searchValue"));
		pstmt.setString(2,  map.get("searchValue"));
		pstmt.setInt(3, pageVo.getStartRow());
		pstmt.setInt(4, pageVo.getLastRow());
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("CATEGORY_NAME");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			int hit = rs.getInt("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String status = rs.getString("STATUS");
			
			boardList.add(new BoardVo(no, categoryNo, categoryName, title, content, writerNo, writerNick, hit, enrollDate, modifyDate, status));
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return boardList;
	}
}
