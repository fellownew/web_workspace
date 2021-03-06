package common.controller;

import member.controller.LoginController;
import member.controller.LoginMemberInfoController;
import member.controller.LogoutController;
import member.controller.MemberListController;
import member.controller.ModifyFormController;
import member.controller.ModifyMemberController;
import member.controller.RegisterController;
import member.controller.RegisterSuccessController;
import member.controller.RemoveMemberController;

public class HandlerMapping {
	
	public static Controller getController(String command){
		Controller controller=null;
		if(command==null){
			controller = new ErrorController();
		}else{
			if(command.equals("register")){
				//등록 컨트롤러 호출
				controller = new RegisterController();
			}else if(command.equals("registerSuccess")){
				//조회 컨트롤러 호출
				controller = new RegisterSuccessController();
			}else if(command.equals("login")){
				//로그인 컨트롤러 호출
				controller = new LoginController();
			}else if(command.equals("logout")){
				//로그아웃 컨트롤러 호출
				controller = new LogoutController();
			}else if(command.equals("info")){
				//조회 컨트롤러 호출
				controller = new LoginMemberInfoController();
			}else if(command.equals("memberAllList")){
				//조회 컨트롤러 호출
				controller = new MemberListController();
			}else if(command.equals("modify")){
				//조회 컨트롤러 호출
				controller = new ModifyFormController();
			}else if(command.equals("completeModify")){
				//조회 컨트롤러 호출
				controller = new ModifyMemberController();
			}else if(command.equals("removeMember")){
				//조회 컨트롤러 호출
				controller = new RemoveMemberController();
			}else if(command.equals("link")){
				//WEB-INF 내로 링크 걸기 위한 컨트롤러 호출
				controller = new LinkController();
			}else{
				controller = new ErrorController();
			}
		}
		return controller;
	}
}
