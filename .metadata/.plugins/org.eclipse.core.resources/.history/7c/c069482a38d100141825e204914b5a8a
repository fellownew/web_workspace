package servlet.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//로그인 여부 체크
		HttpSession session = request.getSession();
		Object loginInfo = session.getAttribute("login_Id");
		if(loginInfo==null){//로그인 상태가 아니라면.
			request.setAttribute("failmessage", "로그인을 하세요");
		}else{
			session.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/session/login_form.jsp");
		rd.forward(request, response);
	}
}
