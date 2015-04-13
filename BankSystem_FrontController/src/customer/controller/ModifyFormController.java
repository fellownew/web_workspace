package customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AttributeAndView;
import common.controller.Controller;
import common.vo.Customer;
import customer.model.service.CustomerService;

public class ModifyFormController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustomerService ms = CustomerService.getInstance();
		String id =  request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		int age = Integer.parseInt(request.getParameter("age"));
		boolean sex = Boolean.parseBoolean(request.getParameter("sex"));	
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		Customer modifyCustomer = new Customer(id,password,name,job,age,sex,phoneNumber,address);
		ms.modifyCustomer(modifyCustomer);
		
		return new AttributeAndView(true, "/BankSystem_FrontController/controller?command=completeModify");
	}

}
