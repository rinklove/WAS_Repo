package edu.kh.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.db.util.JDBCTemplate;

import edu.kh.test.model.vo.UserDTO;

public class UserDao {

	
	public UserDTO findOne(String userNo, Connection con) throws SQLException {
		String query = "SELECT * FROM TB_USER WHERE USER_NO =?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userNo);
		ResultSet rs = pstmt.executeQuery();
		
		UserDTO findUser = null;
		if(rs.next()) {
			String no = rs.getString("USER_NO");
			String id = rs.getString("USER_ID");
			String name = rs.getString("USER_NAME");
			String age = rs.getString("USER_AGE");
			
			findUser = new UserDTO(no, id, name, age);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return findUser;
	}

}
