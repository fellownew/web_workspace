package customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;

import customer.model.service.CustomerService;

public class RemoveCustomerController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustomerService ms = CustomerService.getInstance();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("login_info");
		ms.removeCustomerById(id);
		session.invalidate();
		return new AttributeAndView(true, "/BankSystem_FrontController/index.jsp");
	}

}
