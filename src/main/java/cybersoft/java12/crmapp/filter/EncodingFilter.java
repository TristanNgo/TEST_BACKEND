package cybersoft.java12.crmapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.crmapp.util.UrlConst;

@WebFilter(urlPatterns= {UrlConst.ROOT})
public class EncodingFilter implements Filter {
	private int requestCount = 1;
	@Override
	public void doFilter(ServletRequest request, ServletResponse respone, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) respone;
		int count = requestCount++;
		//Xử lý request
		System.out.println("Request count >>>> "+ requestCount++);
		req.setCharacterEncoding("UTF-8");
		System.out.println("Set charset for Request. req:"+count);
		chain.doFilter(request, respone);
		
		//Xử lý respone
		resp.setCharacterEncoding("UTF-8");
		System.out.println("Set charset for Respone. resp: "+count);
		}
	
}
