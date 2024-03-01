package edu.kh.test.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

import edu.kh.test.model.dao.UserDao;
import edu.kh.test.model.vo.UserDTO;

public class UserService {
	
	private final UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}

	public UserDTO findOne(String userNo) throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		UserDTO findUser = userDao.findOne(userNo, con);
		
		JDBCTemplate.close(con);
		return findUser;
	}

}
