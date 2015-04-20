package common.controller;

import customer.controller.LoginController;
import customer.controller.LoginCustomerInfoController;
import customer.controller.LogoutController;
import customer.controller.CustomerListController;
import customer.controller.ModifyFormController;
import customer.controller.ModifyCustomerController;
import customer.controller.RegisterController;
import customer.controller.RegisterSuccessController;
import customer.controller.RemoveCustomerController;
import account.controller.AccountManagerController;
import account.controller.CreateAccountController;

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
				controller = new LoginCustomerInfoController();
			}else if(command.equals("customerAllList")){
				//전체조회 컨트롤러 호출
				controller = new CustomerListController();
			}else if(command.equals("modify")){
				//수정 컨트롤러 호출
				controller = new ModifyFormController();
			}else if(command.equals("completeModify")){
				//수정완료 컨트롤러 호출
				controller = new ModifyCustomerController();
			}else if(command.equals("removeCustomer")){
				//삭제 컨트롤러 호출
				controller = new RemoveCustomerController();
			}else if(command.equals("accountManager")){
				//통장관리 컨트롤러 호출
				controller = new AccountManagerController();
			}else if(command.equals("accountManager")){
				//통장생성 컨트롤러 호출
				controller = new CreateAccountController();
			}else if(command.equals("createAccount")){
				//통장생성 컨트롤러 호출
				controller = new CreateAccountController();
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
