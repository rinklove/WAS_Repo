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
@WebServlet("/member/join")
public class JoinController extends HomeController {
	private static final long serialVersionUID = 1L;
    private final MemberService memberService;
	
    /**
     * @see HomeController#HomeController()
     */
    public JoinController() {
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
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String memberId = request.getParameter("memberId");
			String memberPwd = request.getParameter("memberPwd");
			String memberPwd2 = request.getParameter("memberPwd2");
			String memberNick = request.getParameter("memberNick");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String[] arr = request.getParameterValues("hobbys");
			String hobbys = arr == null? "" : Arrays.stream(arr).collect(Collectors.joining(","));
			
			int result = memberService.join(new MemberVo(memberId, memberPwd, memberPwd2, memberNick, phone, email, address, hobbys));
			
			if(result == 1) {
				request.getSession().setAttribute("alertMsg", "회원가입 성공~");
				response.sendRedirect("/app99/home");
			} else {
				throw new Exception();
			}			
		} catch (Exception e) {
			System.out.println("회원가입 에러 발생");
			System.out.println(e.getMessage());
			request.setAttribute("error", "회원가입 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

}
