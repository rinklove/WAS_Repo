package com.kh.app.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.member.vo.MemberVo;

import home.HomeController;

/**
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/board/write")
public class BoardWriteController extends HomeController {
	private static final long serialVersionUID = 1L;
	private final BoardService boardService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
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
			MemberVo sessionMember = ((MemberVo) request.getSession().getAttribute("loginMember"));
			
			if(sessionMember == null) {
				throw new Exception("회원만 이용가능합니다.");
			}
			
			List<CategoryVo> categoryList = boardService.getAllCategory();
			
			request.setAttribute("list", categoryList);
			request.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "게시글 작성 실패");
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MemberVo sessionMember = ((MemberVo) request.getSession().getAttribute("loginMember"));
			
			if(sessionMember == null) {
				throw new Exception("회원만 이용가능합니다.");
			}
			
			String category = request.getParameter("category");
			String title = request.getParameter("title");

			String content = request.getParameter("content");
			 
			int result = boardService.addBoard(new BoardVo(category, title, content, sessionMember.getNo()));
			
			if(result != 1) {
				throw new Exception();
			}	
			
			request.getSession().setAttribute("alertMsg", "게시글 작성 성공~");
			response.sendRedirect(request.getContextPath() +"/board/list");
		} catch (Exception e) {
			request.setAttribute("error", "게시글 작성 실패");
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);			
		}
		
	}

}
