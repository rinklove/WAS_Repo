package com.test.app.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.app.student.service.StudentService;
import com.test.app.student.vo.StudentVo;


@WebServlet("/student/regist")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final StudentService studentService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteController() {
        studentService = new StudentService();
    }

    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * 등록 기능 주소
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String studentName = request.getParameter("studentName");
		String koreanScore = request.getParameter("koreanScore");
		String englishScore = request.getParameter("englishScore");
		String mathScore = request.getParameter("mathScore");
		
	
	}

}
