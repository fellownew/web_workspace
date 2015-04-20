package account.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.model.service.AccountService;
import common.controller.AttributeAndView;
import common.controller.Controller;
import common.vo.Account;
import common.vo.Customer;

public class AccountManagerController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		AccountService ac = AccountService.getInstance();
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("login_info");
		String id = customer.getId();
		ArrayList<Account> list = ac.accountListById(id);
		
		return new AttributeAndView(false, "/WEB-INF/view/account/account_manager.jsp","accountList",list);
	}
}
