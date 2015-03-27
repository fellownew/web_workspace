package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}
	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		String encodeType = config.getInitParameter("encoding_type");
		request.setCharacterEncoding(encodeType);
		chain.doFilter(request, response);
	}

}
