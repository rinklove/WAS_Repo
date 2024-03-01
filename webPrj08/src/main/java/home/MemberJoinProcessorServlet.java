package home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join/processor")
public class MemberJoinProcessorServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("회원 가입 처리");
		super.service(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String memberPwd2 = req.getParameter("memberPwd2");
		String memberNick = req.getParameter("memberNick");
		System.out.println(memberId);
		System.out.println(memberPwd);
		System.out.println(memberPwd2);
		System.out.println(memberNick);
		int result = 1;
		
		if(memberId.contains("admin")) {
			result = 0;
		}
		if(result == 0) 
			out.write("<h1>실패</h1>");
		else
		out.write("<h1>ok</h1>");
	}
}
