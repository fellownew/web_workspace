package servlet.form;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		request.getParameter("id");
		//TODO 아이디 비교
		request.getParameter("password");
		//TODO 비밀번호 비교
	}
}
