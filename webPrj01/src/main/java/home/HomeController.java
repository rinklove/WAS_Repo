package home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.Utf8Encoder;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("id = "+req.getParameter("id"));
		System.out.println("pwd = "+req.getParameter("pwd"));
		System.out.println("nick = "+req.getParameter("nick"));
		//할 거 작성하기
		res.setContentType("text/html;charset=UTF-8");
		res.getWriter().write("<html>");
		res.getWriter().write("<head>");
		res.getWriter().write("</head>");
		res.getWriter().write("<body>");
		res.getWriter().write("<h1>ㅗㅗㅗㅗㅗㅗ</h1>");
		res.getWriter().write("<h3>"+req.getParameter("nick")+"님 어서오세연</h3>");
		res.getWriter().write("<script>");
		res.getWriter().write("alert('"+req.getParameter("nick")+"')");
		res.getWriter().write("</script>");
		res.getWriter().write("</body>");
		res.getWriter().write("</html>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
}
