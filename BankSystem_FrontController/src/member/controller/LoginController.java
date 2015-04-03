package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.vo.Member;

import common.controller.AttributeAndView;
import common.controller.Controller;

public class LoginController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberService ms = MemberService.getInstance();
		String id =  request.getParameter("id");
		String password = request.getParameter("password");
		String url = null;
		Member member = new Member(id,password);
		boolean login = ms.loginMember(member); // B.L 호출
		if(login){
			HttpSession session = request.getSession();
			session.setAttribute("login_info", id);
			url = "/WEB-INF/view/member/main.jsp";
		}else{
			request.setAttribute("failMessage", "아이디 또는 비밀번호가 맞지 않습니다.");
			url="/WEB-INF/view/member/login_form.jsp";
		}
		
		return new AttributeAndView(false, url);
	}

}
