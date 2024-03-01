package edu.kh.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.model.vo.UserDTO;
import edu.kh.test.service.UserService;


@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final UserService userService;
       

    public SelectUserServlet() {
    	userService = new UserService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String userNo = request.getParameter("userNo");
			
			UserDTO findUser = userService.findOne(userNo);
			
			if(findUser == null) {
				throw new Exception();
			}
			request.setAttribute("user", findUser);
			request.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "조회 결과가 없습니다.");
			request.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(request, response);
		}
	}

}
