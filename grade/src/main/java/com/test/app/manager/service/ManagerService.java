package com.test.app.manager.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.db.util.JDBCTemplate;
import com.test.app.manager.repository.ManagerRepository;
import com.test.app.manager.vo.ManagerVo;
import com.test.app.student.vo.StudentVo;

public class ManagerService {

	private final ManagerRepository managerRepository;
	
	public ManagerService() {
		managerRepository = new ManagerRepository();
	}
	
	public int registManager(ManagerVo managerVo) throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = managerRepository.registManager(managerVo, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		
		return result;
	}
	
	public List<ManagerVo> readManagerList() throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		List<ManagerVo> list = managerRepository.readAllManagers(con);
		
		JDBCTemplate.close(con);
		return list;
	}
	
	public int updateManager(ManagerVo managerVo) throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = managerRepository.updateManager(managerVo, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		
		return result;
	}
	
	public int registManager(String managerNumber) throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = managerRepository.deleteManager(managerNumber, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		
		return result;
	}
}
