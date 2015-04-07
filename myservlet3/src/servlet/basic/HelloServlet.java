package servlet.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet : 서블릿이라고 등록 해주는 Annotaion
//<servlet>, <servlet-mapping>을 해줌., initParams
//@WebInitParam : 초기 파라미터 등록.
@WebServlet(name="hello", urlPatterns={"/hello","/greet"}, initParams=@WebInitParam(name="greeting",value="안녕"),loadOnStartup=1)
public class HelloServlet extends HttpServlet{
	public void init(){
		System.out.println("HellowServlet");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String str = getInitParameter("greeting")+name+"님";
		request.setAttribute("greeting", str);
		RequestDispatcher rd = request.getRequestDispatcher("/response.jsp");
		rd.forward(request, response);
		
		
	}
	
}
