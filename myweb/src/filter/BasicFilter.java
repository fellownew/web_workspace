package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BasicFilter implements Filter{
	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("BasicFilter.init() 호출");
		this.config=config;
	}
	
	@Override
	public void destroy() {
		System.out.println("BasicFilter.destroy() 호출");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		String value = config.getInitParameter("name");
		System.out.println("BasicFilter.doFilter() 호출 - 전처리"+value);
		chain.doFilter(request, response);
		System.out.println("BasicFilter.doFilter() 호출 - 후처리");

	}




}
