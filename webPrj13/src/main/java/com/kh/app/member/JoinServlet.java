package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.HomeServlet;
@WebServlet("/member/join")
public class JoinServlet extends HomeServlet {
	
	private final MemberService memberService;
	
	public JoinServlet() {
		memberService = new MemberService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setAttribute("title", "회원가입 결과");
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			
			int result = memberService.join(new MemberVo(memberId, memberPwd, memberPwd2, memberNick));
			if(result == 1) 
				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			else 
				throw new Exception("회원가입에 실패했습니다");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
	}
}
