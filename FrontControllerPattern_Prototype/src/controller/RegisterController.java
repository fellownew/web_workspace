package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String info = request.getParameter("info");
		System.out.println("RegisterController에서 Model 호출하여 BL 처리");
		System.out.println("등록정보 : "+ info);
		
		return new AttributeAndView(false, "/WEB-INF/view/response/response1.jsp");
	}

}