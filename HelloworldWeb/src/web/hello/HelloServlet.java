package web.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet { //Servlet 이용을 위한 상속
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd월 HH시 mm분 ss초");
	String now = sdf.format(date);
	public void doGet(HttpServletRequest request, HttpServletResponse response) //요청, 요청받기 매개변수
			throws ServletException, IOException { 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //response에서 Writer를 불러와 PrintWriter를 만듬.
		out.println("HelloWorld<br/>");
		out.println("안녕하세요<br/>");
		out.println("반갑습니다<br/>");
		out.println("HelloServlet<br/>");
		out.println("잘 되나요?<br/>");
		out.println("현재시간 : "+now);
	}
}
