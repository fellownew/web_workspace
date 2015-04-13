package customer.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AttributeAndView;
import common.controller.Controller;
import common.vo.Customer;

import customer.model.service.CustomerService;

public class CustomerListController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustomerService ms = CustomerService.getInstance();
		ArrayList<Customer> customers = ms.getCustomerList();
		
		return new AttributeAndView(false, "/WEB-INF/view/customer/customer_list.jsp","customers",customers);
	}

}
