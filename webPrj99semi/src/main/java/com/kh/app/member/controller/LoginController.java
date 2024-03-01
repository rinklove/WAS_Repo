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
@WebServlet("/member/login")
public class LoginController extends HomeController {
	private static final long serialVersionUID = 1L;
    private final MemberService memberService;
	
    /**
     * @see HomeController#HomeController()
     */
    public LoginController() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String memberId = request.getParameter("memberId");
			String memberPwd = request.getParameter("memberPwd");

			
			MemberVo findMember = memberService.login(new MemberVo(memberId, memberPwd));
			
			if(findMember != null) {
				request.getSession().setAttribute("alertMsg", "로그인 성공~");
				request.getSession().setAttribute("loginMember", findMember);
				response.sendRedirect("/app99/home");
			} else {
				throw new Exception();
			}			
		} catch (Exception e) {
			System.out.println("로그인 에러 발생");
			e.printStackTrace();
			request.setAttribute("error", "로그인 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
