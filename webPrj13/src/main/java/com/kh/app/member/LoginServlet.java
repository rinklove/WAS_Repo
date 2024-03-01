package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.HomeServlet;

@WebServlet("/member/login")
public class LoginServlet extends HomeServlet {
	
	private final MemberService memberService;
	
	public LoginServlet() {
		memberService = new MemberService();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	/**
	 * 로그인
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("title", "로그인 결과");
			String id = req.getParameter("memberId");
			String pwd = req.getParameter("memberPwd");
			
			MemberVo loginMember = memberService.login(id, pwd);
			
			if(loginMember == null) {
				throw new Exception("로그인 실패");
			}
			req.getSession().setAttribute("userData", loginMember);
			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
		
	}
}
