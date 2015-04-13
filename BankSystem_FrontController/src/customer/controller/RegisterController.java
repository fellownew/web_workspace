package customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;
import common.vo.Customer;

import customer.exception.DuplicationIdException;
import customer.model.service.CustomerService;

public class RegisterController implements Controller {

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
		
		Customer registerCustomer = new Customer(id,password,name,9,job,age,sex,phoneNumber,address);
		String url = "";
		try {
			ms.joinCustomer(registerCustomer);
			url = "/BankSystem_FrontController/controller?command=registerSuccess";
			HttpSession session = request.getSession();
			session.setAttribute("registerSuccess", id);
			
		} catch (DuplicationIdException e) {
			url = "/BankSystem_FrontController/controller?command=link&path=/WEB-INF/view/customer/register_form.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("failMessage", e.getMessage());
			e.printStackTrace();
		}
		return new AttributeAndView(true, url);
	}
}
