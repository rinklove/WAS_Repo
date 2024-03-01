package com.kh.app.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.replay.driver.ReplayLoggerFactory;

@WebServlet("/member/join")
public class MemberJoinViewServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setAttribute("title", "회원가입");
		req.getRequestDispatcher("/WEB-INF/views/member-join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		List<String> memberList = new ArrayList<>();
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberPwd2 = req.getParameter("memberPwd2");
		String memberNick = req.getParameter("memberNick");
		memberList.add(memberId);
		memberList.add(memberPwd);
		memberList.add(memberPwd2);
		memberList.add(memberNick);
		
		req.setAttribute("member", memberList);
		req.setAttribute("title", "회원가입 결과");
		int result = 0;
		if(memberPwd.equals(memberPwd2)) result = 1;
		
		if(result == 1)
		req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
		else 
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);			
	}
}
