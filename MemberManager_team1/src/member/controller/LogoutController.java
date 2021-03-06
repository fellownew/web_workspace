package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		return new AttributeAndView(true, "/MemberManager_team1/index.jsp");
	}

}
