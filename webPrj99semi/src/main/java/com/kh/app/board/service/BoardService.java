package com.kh.app.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.db.util.JDBCTemplate;
import com.kh.app.page.vo.PageVo;

public class BoardService {
	
	private final BoardDao boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}

	public List<BoardVo> getBoardList(PageVo pageVo) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		List<BoardVo> boardList = boardDao.getBoardList(pageVo, con);
		
		JDBCTemplate.close(con);
		
		return boardList;
	}

	public int addBoard(BoardVo board) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		int result = boardDao.addBoard(board, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		return result;
	}

	public BoardVo getOne(String no) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		int result = boardDao.increaseHit(no, con);
		
		BoardVo findBoard = null;
		if(result == 1) {
			findBoard = boardDao.getOne(no, con);
		}
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		return findBoard;
	}

	public int updateStatus(String no) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		int result = boardDao.updateStatus(no, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public int getTotalBoardCount() throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		int boardCount = boardDao.getTotalBoardCount(con);
		
		JDBCTemplate.close(con);
		return boardCount;
	}

	public int editBoard(BoardVo board) throws SQLException, ClassNotFoundException {
		Connection con = JDBCTemplate.getConnection();
		
		int result = boardDao.editBoard(board, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		return result;
	}

	public List<CategoryVo> getAllCategory() throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		List<CategoryVo> list = boardDao.getAllCategory(con);
		
		JDBCTemplate.close(con);
		return list;
	}

	public int getTotalBoardCountBySearch(Map<String, String> map) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		int boardCount = boardDao.getTotalBoardCountBySearch(map, con);
		
		JDBCTemplate.close(con);
		return boardCount;
	}
	
	public List<BoardVo> getBoardListBySearch(Map<String, String> map, PageVo pageVo) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		List<BoardVo> boardList = boardDao.getBoardListBySearch(map, pageVo, con);
		
		JDBCTemplate.close(con);
		
		return boardList;
	}
	

}
