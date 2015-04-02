package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.vo.Member;

import common.controller.AttributeAndView;
import common.controller.Controller;

public class LoginMemberInfoController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberService ms = MemberService.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("login_info");
		Member member = ms.getMemberById(id);	
		
		return new AttributeAndView(false, "/WEB-INF/view/member/member_info.jsp","info",member);
	}

}
