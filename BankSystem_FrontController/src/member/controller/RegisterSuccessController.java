package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.vo.Member;

import common.controller.AttributeAndView;
import common.controller.Controller;

public class RegisterSuccessController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberService ms = MemberService.getInstance();
		HttpSession session =request.getSession();
		String id = (String) session.getAttribute("registerSuccess");
//		String id = request.getParameter("id");
//		session.removeAttribute("registerSuccess");
		Member member = ms.getMemberById(id);
		return new AttributeAndView(false, "/WEB-INF/view/member/register_success.jsp","info",member);
	}
}
