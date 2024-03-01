package com.kh.app.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet{
	

	private final MemberService memberService;
	
	public MemberJoinServlet() {
		memberService  = new MemberService();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "회원가입");
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String memberId = req.getParameter("memberId");
			System.out.println("memberId = " + memberId);
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			
			int result = memberService.join(new MemberVo(memberId, memberPwd, memberPwd2, memberNick));
			
			req.setAttribute("title","회원 가입 결과");
			if(result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			} else {
				throw new SQLException();
			}
		} catch (Exception e) {			
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);			
		}
		
		
	}
}
