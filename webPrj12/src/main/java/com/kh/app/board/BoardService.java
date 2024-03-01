package com.kh.app.board;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

public class BoardService {
	
	private final BoardDao boardDao;
	
	public BoardService() {
		boardDao = new BoardDao()
	}

	public int upload(BoardVo board) throws Exception {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = boardDao.upload(board, conn);
		
		if(result == 1) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		
		return result;
	}

}
