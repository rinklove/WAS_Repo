package sku.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 * 
 * web.xml문서
 *  <filter>
 *  
 *  </filter>
 *  
 *  <fiter-mapping>
 *  
 *  </fiter-mapping>
 */
@WebFilter("/*") 
		
public class EncodingFilter  implements Filter {

       
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전처리
		request.setCharacterEncoding("utf-8");
		
		chain.doFilter(request, response);
		
		//사후처리 
		
		
	}

	
	

}








