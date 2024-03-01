package com.test.app.student.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.app.db.util.JDBCTemplate;
import com.test.app.student.repository.StudentRepostiory;
import com.test.app.student.vo.StudentVo;

public class StudentService {
	
	private final StudentRepostiory studentRepository;
	
	public StudentService() {
		studentRepository = new StudentRepostiory();
	}

	/**
	 * 등록
	 * @param studentVo
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int registStudent(StudentVo studentVo) throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = studentRepository.registStudent(studentVo, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		
		return result;
	}
	
	/**
	 * 목록
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<StudentVo> readStudentList() throws ClassNotFoundException, SQLException {
		Connection con = JDBCTemplate.getConnection();
		
		List<StudentVo> list = studentRepository.readAllStudents(con);
		
		JDBCTemplate.close(con);
		return list;
	}
	
	public int updateStudent(StudentVo studentVo) throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = studentRepository.updateStudent(studentVo, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		
		return result;
	}
	
	public int deleteStudent(String studentNumber) throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCTemplate.getConnection();
		
		int result = studentRepository.deleteStudent(studentNumber, con);
		
		if(result == 1) JDBCTemplate.commit(con);
		else JDBCTemplate.rollback(con);
		
		JDBCTemplate.close(con);
		
		return result;
	}
	
}
