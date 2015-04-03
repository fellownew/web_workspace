package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return new AttributeAndView(false, "/error.jsp","failMessage","잘못된 접근입니다.");
	}

}
