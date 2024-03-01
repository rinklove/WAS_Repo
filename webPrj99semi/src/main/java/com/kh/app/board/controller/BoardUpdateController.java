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

import org.json.simple.JSONObject;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.board.vo.CategoryVo;
import com.kh.app.member.vo.MemberVo;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/board/edit")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final BoardService boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
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
			String no = request.getParameter("no");
			
			List<CategoryVo> categoryList = boardService.getAllCategory();
			request.setAttribute("list", categoryList);
			
			BoardVo findBoard = boardService.getOne(no);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("categoryList", categoryList);
			map.put("board", findBoard);
					
			request.setAttribute("board", findBoard);
			request.setAttribute("no", no);
			request.getRequestDispatcher("/WEB-INF/views/board/edit.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			String no = request.getParameter("no");
			System.out.println("no = " + no);
			String category = request.getParameter("category");
			String title = request.getParameter("title");
			String writerNo = sessionMember.getNo();
			
			String content = request.getParameter("content");
			
			
			int result = boardService.editBoard(new BoardVo(no, category, title, content, writerNo));	
			if(result != 1) {
				throw new Exception();
			}	
			
			request.getSession().setAttribute("alertMsg", "게시글 수정 성공~");
			response.sendRedirect(request.getContextPath() +"/board/detail?no=" + no);
		} catch (Exception e) {
			request.setAttribute("error", "게시글 수정 실패");
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);			
		}
	}

}
