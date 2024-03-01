package com.kh.app.member.controller;

import home.HomeController;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/member/logout")
public class LogoutController extends HomeController {
	private static final long serialVersionUID = 1L;
    private final MemberService memberService;
	
    /**
     * @see HomeController#HomeController()
     */
    public LogoutController() {
       memberService = new MemberService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이 두개는 서로 다른 세션임
		request.getSession().invalidate();
		request.getSession().setAttribute("alertMsg", "로그아웃 성공...");
		response.sendRedirect("/app99/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
