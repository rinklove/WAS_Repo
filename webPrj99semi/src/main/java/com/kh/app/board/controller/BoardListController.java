package com.kh.app.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

import home.HomeController;

/**
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/board/list")
public class BoardListController extends HomeController {
	private static final long serialVersionUID = 1L;
	private final BoardService boardService;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
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
			int listCount=boardService.getTotalBoardCount();
			int currentPage=request.getParameter("pno") == null ? 1 : Integer.parseInt(request.getParameter("pno"));
			int pageLimit=5;
			int boardLimit=10;
			PageVo pageVo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			List<BoardVo> boardList = boardService.getBoardList(pageVo);
			request.setAttribute("pageVo", pageVo);
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 조회 에러 발생");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
