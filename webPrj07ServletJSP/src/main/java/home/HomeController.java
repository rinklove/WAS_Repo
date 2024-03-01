package home;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.JDBCTemplate;

@WebServlet("/home")
public class HomeController extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		super.service(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter out = resp.getWriter();
//		out.write("<h1>홈페이지</h1>");
		String result = null;
		try {
    		Connection con = new JDBCTemplate().getConnection();
    		String query = "select 1 from dual";
    		PreparedStatement pstmt =  con.prepareStatement(query);
    		ResultSet rs = pstmt.executeQuery();
    		if(rs.next()) 
    	 	result = rs.getString("1");
    		JDBCTemplate.close(con);
    		JDBCTemplate.close(pstmt);
    		JDBCTemplate.close(rs);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
		
		req.setAttribute("k01", "ddd");
		req.setAttribute("result", result);
		req.setAttribute("color", "버건디");
		req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
	}
}
