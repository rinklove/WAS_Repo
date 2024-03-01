package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONObject;

import test.vo.BoardVo;

/**
 * Servlet implementation class TestController
 */
@WebServlet("/test")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getMethod().toLowerCase()) {
		case "put":
			doPut(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json");
		System.out.println("요청 받았음");
		PrintWriter out = response.getWriter();
		Map<Integer, BoardVo> list = new HashMap<>();
		list.put(1, new BoardVo("제목1", "내용1"));
		list.put(2, new BoardVo("제목2", "내용2"));
		list.put(3, new BoardVo("제목3", "내용3"));
		list.put(4, new BoardVo("제목4", "내용4"));
		list.put(5, new BoardVo("제목4", "내용4"));
		list.put(6, new BoardVo("제목4", "내용4"));
//		System.out.println(list.toArray(new::BoardVo[]));
		out.write(JSONObject.toJSONString(list));
	}

}
