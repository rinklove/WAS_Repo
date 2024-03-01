package home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String method = req.getMethod().toLowerCase();
		res.setContentType("text/html;charset=UTF-8");
		switch(method) {
		case "get": doGet(req, res); break;
		case "post": doPost(req, res); break;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer num = Integer.parseInt(req.getParameter("num"));
		Integer num2 = Integer.parseInt(req.getParameter("num2"));			

		res.getWriter().write("<h1>ㅗㅗㅗㅗㅗㅗ</h1>");
		res.getWriter().write("<h1>"+(num+num2)+"</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
}
