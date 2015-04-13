package customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;
import common.vo.Customer;

import customer.model.service.CustomerService;

public class ModifyCustomerController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustomerService ms = CustomerService.getInstance();
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("login_info");
		customer = ms.getCustomerById(customer.getId());
		session.invalidate();
		return new AttributeAndView(false, "/WEB-INF/view/customer/customer_info.jsp","info",customer);
	}

}
