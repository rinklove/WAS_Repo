package com.kh.app.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.vo.PageVo;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/board/search")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private BoardService boardService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
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
			String searchType = request.getParameter("searchType") == null ? "" : request.getParameter("searchType");
			String searchValue = request.getParameter("searchValue") == null ? "" : request.getParameter("searchValue");
			
			Map<String , String> map = new HashMap<String, String>();
			map.put("searchType", searchType);
			map.put("searchValue", searchValue);
			
			int listCount=boardService.getTotalBoardCountBySearch(map);
			int currentPage=request.getParameter("pno") == null ? 1 : Integer.parseInt(request.getParameter("pno"));
			int pageLimit=5;
			int boardLimit=10;
			PageVo pageVo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
			
			
			List<BoardVo> boardList = boardService.getBoardListBySearch(map, pageVo);
			
			request.setAttribute("searchMap", map);
			request.setAttribute("pageVo", pageVo);
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("/WEB-INF/views/board/search-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "게시글 조회 에러 발생");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);			
		}
	}

}
