package com.test.app.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.app.student.service.StudentService;
import com.test.app.student.vo.StudentVo;


@WebServlet("/student/list")
public class StudentReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final StudentService studentService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReadController() {
        studentService = new StudentService();
    }

    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		super.service(request, response);
	}
	
	/**
	 * 목록 조회 주소
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
