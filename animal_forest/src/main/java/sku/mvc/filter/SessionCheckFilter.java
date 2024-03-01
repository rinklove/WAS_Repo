package sku.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionCheckFilter
 */
@WebFilter("/front")
public class SessionCheckFilter  implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//�궗�쟾泥섎━ : �씤利앸맂 �궗�슜�옄 �씤吏�瑜� 泥댄겕�븳�떎. 
		String key = request.getParameter("key");
		
		if(key==null || key.equals("elec")) {
			//Elec�젒洹쇳븳�떎.
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			if(session.getAttribute("loginUser") ==null) {
				//�씤利앹븞�릺�뿀�떎!!
				req.setAttribute("errorMsg", "로그인하고 이용해주세요.^^");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				return;//硫붿냼�뱶瑜� 鍮좎졇�굹媛��씪.
			}
		}
		chain.doFilter(request, response);
		
		
		//�궗�썑泥섎━
	}

	

}
