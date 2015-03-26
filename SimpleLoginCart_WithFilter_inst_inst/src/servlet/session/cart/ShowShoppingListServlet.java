package servlet.session.cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowShoppingListServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		로그인 체크 : filter에서 처리
		HttpSession session = request.getSession();
		String url = null;
		
//		상품목록을 DB에서 조회
		url = "/WEB-INF/jsp/cart/list.jsp";
		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);
		
	}
}








