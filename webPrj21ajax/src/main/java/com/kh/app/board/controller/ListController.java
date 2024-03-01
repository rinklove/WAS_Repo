package com.kh.app.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;


@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final BoardService boardService;

    public ListController() {
        super();
        boardService = new BoardService();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		super.service(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			List<BoardVo> list = new ArrayList<BoardVo>();
			list.add(new BoardVo("1", "제목1", "내용1"));
			list.add(new BoardVo("2", "제목2", "내용2"));
			list.add(new BoardVo("3", "제목3", "내용3"));
			list.add(new BoardVo("4", "제목4", "내용4"));
			list.add(new BoardVo("5", "제목5", "내용5"));
			
			Gson g = new Gson();
			String json = g.toJson(list);
			
			out.write(json);
			
		} catch(Exception e) {
			
		}
	}

}
