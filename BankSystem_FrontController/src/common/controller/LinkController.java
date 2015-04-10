package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkController implements Controller{
//단순 링크 처리
	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return new AttributeAndView(false, request.getParameter("path"));
	}
	
}
