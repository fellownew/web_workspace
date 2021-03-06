package member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.vo.Member;

import common.controller.AttributeAndView;
import common.controller.Controller;

public class MemberListController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MemberService ms = MemberService.getInstance();
		ArrayList<Member> members = ms.getMemberList();
		
		return new AttributeAndView(false, "/WEB-INF/view/member/member_list.jsp","members",members);
	}

}
