package member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.CustomerDAO;

public class RegisterServlet extends HttpServlet {
	private CustomerDAO dao = CustomerDAO.getInstance();
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//회원가입 받은 모든 파라미터를 받아 회원 가입 시킴.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		System.out.println(sex);
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		String address = request.getParameter("address");
		String phoneNum = request.getParameter("phone0")+request.getParameter("phone1")+request.getParameter("phone2");
		int count=0;
		try {
			count = dao.insertCustomer(id, password, name, sex, age, job, address, phoneNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count==1){
			response.sendRedirect("/BankSystem/register/success?path=/WEB-INF/confirm/register_success.jsp");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/login/register_form.jsp");
			rd.forward(request, response);
		}
	}
}
