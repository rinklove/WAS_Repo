package com.kh.app.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.member.vo.MemberVo;

/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BoardService boardService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteController() {
        super();
        boardService = new BoardService();
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
			MemberVo sessionMember = (MemberVo) request.getSession().getAttribute("loginMember");
			String no = request.getParameter("no");
			System.out.println("no = "+ no);
			System.out.println("sessionMember.getNo() = " + sessionMember.getNo());
			if(sessionMember== null) {
				throw new Exception("삭제 권한이 없습니다");
			}
			
			int result = boardService.updateStatus(no);
			
			if(result != 1) {
				throw new Exception();
			}
			request.getSession().setAttribute("alertMsg", "게시글 삭제 성공");
			response.sendRedirect("/app99/board/list");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 삭제 에러 발생");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
