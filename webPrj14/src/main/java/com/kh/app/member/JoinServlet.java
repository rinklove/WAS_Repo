package com.kh.app.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.HomeServlet;

@WebServlet("/member/join")
public class JoinServlet extends HomeServlet{
	private static final long serialVersionUID = 1L;
	private final MemberService memberService;
	
	public JoinServlet() {
		memberService = new MemberService();
	}
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("result", " 회원가입 결과");
			String memberId = request.getParameter("memberId");
			String memberPwd = request.getParameter("memberPwd");
			String memberPwd2 = request.getParameter("memberPwd2");
			String memberNick = request.getParameter("memberNick");
			
			int result = memberService.join(new MemberVo(memberId, memberPwd, memberPwd2, memberNick));	
			
			if(result != 1) {
				throw new Exception();
			}
			
			
			request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("reason", e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
		}
	}

}
