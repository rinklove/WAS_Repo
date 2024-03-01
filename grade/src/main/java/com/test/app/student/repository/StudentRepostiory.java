package com.test.app.student.repository;

import java.sql.Connection;
import java.util.List;

import com.test.app.student.vo.StudentVo;

public class StudentRepostiory {

	private String query;
	public int registStudent(StudentVo studentVo, Connection con) {
		query = "INSERT INTO student(student_no, student_name, korean_score, english_score, math_score) VALUES ()";
		return 0;
	}
	public List<StudentVo> readAllStudents(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	public int updateStudent(StudentVo studentVo, Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int deleteStudent(String studentNumber, Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}

}
