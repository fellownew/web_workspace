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
		Date date = new Date();
		Member registerMember = new Member(id,password,name,email,date);
		String url = "";
		try {
			ms.joinMember(registerMember);
			url = "/MemberManager_team1/controller?command=registerSuccess&id="+id;
			
		} catch (DuplicationIdException e) {
			String failMessage = e.getMessage();
			url = "/MemberManager_team1/controller?command=link&path=/WEB-INF/view/member/register_form.jsp&failMessage="+e.getMessage();
			HttpSession session = request.getSession();
			session.setAttribute("failMessage", e.getMessage());
			e.printStackTrace();
		}
		

		return new AttributeAndView(true, url);
	}
}