package servlet.initparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextInitParamServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request,response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//<context-param>으로 등록된 초기 파라미터 조회
		//servletContext객체 조회
		response.setContentType("text/html;charset=UTF-8");
		ServletContext context = getServletContext();
		String address = context.getInitParameter("address");
		String phoneNumber = context.getInitParameter("phone number");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>ServletContext</title></head><body>");
		out.println("주소 : "+address+"<br/>전화번호 : "+phoneNumber);
		out.println("</body></html>");
	}

}
