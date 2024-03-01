package com.kh.app.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.HomeServlet;


@WebServlet("/member/login")
public class LoginServlet extends HomeServlet {
	private static final long serialVersionUID = 1L;
     private final MemberService memberService;
     
     public LoginServlet() {
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
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("result", "로그인 결과");
			String id = request.getParameter("memberId");
			String pwd = request.getParameter("memberPwd");
			MemberVo findMember = memberService.login(new MemberVo(id, pwd, null, null));
			
			if(findMember == null) {
				throw new Exception("아이디또는 비밀번호가 다릅니다");
			}
			
			request.getSession().setAttribute("userData", findMember);
			
			request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("reason", e.getMessage());
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(request, response);
		}
	}
	

}
