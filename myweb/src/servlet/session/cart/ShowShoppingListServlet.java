package servlet.session.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowShoppingListServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String url = null;
		if(session.getAttribute("login_id")==null){//로그인을 안한 상태라면.
			url = "/session/login_form.jsp";
			request.setAttribute("failmessage", "로그인을 해주세요");
		}else{//로그인을 한 상태라면
			url = "/WEB-INF/jsp/cart/list.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
