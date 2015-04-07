package filter.encoding;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter : <filter>, <filter-mapping>
@WebFilter("/*")//속성이 value일때는 생략 가능
public class EncodingFilter implements Filter{
	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("filter 전처리");
		chain.doFilter(request, response);
		System.out.println("filter 후처리");
	}

	@Override
	public void destroy() {
		
	}
	

}
