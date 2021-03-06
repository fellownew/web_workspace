package member.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.exception.DuplicationIdException;
import member.model.service.MemberService;
import member.vo.Member;
import common.controller.AttributeAndView;
import common.controller.Controller;

public class RegisterController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberService ms = MemberService.getInstance();
		String id =  request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Member registerMember = new Member(id,password,name,email,new Date());
		String url = "";
		try {
			ms.joinMember(registerMember);
			url = "/MemberManager_team1/controller?command=registerSuccess";
			HttpSession session = request.getSession();
			session.setAttribute("registerSuccess", id);
			
		} catch (DuplicationIdException e) {
			url = "/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/register_form.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("failMessage", e.getMessage());
			e.printStackTrace();
		}
		return new AttributeAndView(true, url);
	}
}
