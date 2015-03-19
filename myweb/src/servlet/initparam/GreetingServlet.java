package servlet.initparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doGet(request,response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("UTF-8");
		//초기 파라미터 조회
		ServletConfig config = getServletConfig();
		String greeting = config.getInitParameter("greeting");
		String email = getInitParameter("email");	
		//요청파라미터 조회
		String name = request.getParameter("name");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		String address = context.getInitParameter("address");
		String phoneNumber = context.getInitParameter("phone number");
		
		out.println("<html><head><title>ServletConfig</title></head><body>");
		out.println(name+"님"+greeting+"<br/>이메일 : "+email);
		out.println("<br/>주소 : "+address+"<br/>전화번호 : "+phoneNumber);
		out.println("</body></html>");
	}
}
