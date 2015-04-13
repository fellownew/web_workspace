package customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AttributeAndView;
import common.controller.Controller;
import common.vo.Customer;
import customer.model.service.CustomerService;

public class LoginController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		CustomerService ms = CustomerService.getInstance();
		String id =  request.getParameter("id");
		String password = request.getParameter("password");
		String url = null;
		Customer customer = new Customer(id,password);
		boolean login = ms.loginCustomer(customer); // B.L 호출
		if(login){
			customer = ms.getCustomerById(id);
			HttpSession session = request.getSession();
			session.setAttribute("login_info", customer);
			url = "/WEB-INF/view/customer/main.jsp";
		}else{
			request.setAttribute("failMessage", "아이디 또는 비밀번호가 맞지 않습니다.");
			url="/WEB-INF/view/customer/login_form.jsp";
		}
		return new AttributeAndView(false, url);
	}

}
