package servlet.dispatch;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicDispatchTestServlet extends HttpServlet{
	//요청 파라미터 page값을 조회
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		//page=one : one.html, page=two : two.jsp 로 요청디스패치 방식으로 수행을 이동.
		String page = request.getParameter("page");
		String url = null;
		if(page.equals("one")){
			url="/dispatch/one.html";
		}else if(page.equals("two")){
			url="/dispatch/two.jsp";
			request.setAttribute("message", "이것은 서블릿에서 설정한 메세지입니다.");
			request.setAttribute("time", new Date());
		}else if(page.equals("three")){
			url="/WEB-INF/jsp/response.jsp";
		}
		//요청 디스패치 방식으로 이동 처리.
		//1. RequestDispatcher 객체 조회
		RequestDispatcher rd = request.getRequestDispatcher(url);
		//2. 이동 처리.
		rd.forward(request, response);
		
	}

}
