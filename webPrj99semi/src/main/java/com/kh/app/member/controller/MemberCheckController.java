package com.kh.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.app.member.service.MemberService;

/**
 * Servlet implementation class MemberCheckController
 */
@WebServlet("/member/check/id")
public class MemberCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private final MemberService memberService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCheckController() {
        super();
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
		try {
			System.out.println("요청 받음 처리 시작");
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-Type", "application/json");
			
			String inputId = request.getParameter("inputId");
			System.out.println("inputId = " + inputId);
			String findId = memberService.getIdOne(inputId);
			
			PrintWriter out = response.getWriter();
			Map<String, String> map = new HashMap<String, String>();
			if(findId != null) {
				map.put("msg", "사용불가합니다");			
			} else {
				map.put("msg", "사용가능합니다");					
			}
			out.write(JSONObject.toJSONString(map));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
