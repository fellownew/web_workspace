package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookie1Servlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//실행 시점의 일시를 쿠키로 전송
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Date date = new Date();
		String time = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss").format(date);
		//쿠키값 생성
		Cookie cookie = new Cookie("time",time);
		cookie.setMaxAge(60*60);//1시간 동안 쿠키 유지.
		//클라이언트에게 전송 - HTTP응답 정보의 header에 추가.
		response.addCookie(cookie);
			
		out.println("<html><head><title>쿠키전송1</title></head><body>");
		out.println("<a href='/myweb/setcookie2'>set Cookie2</a><br/>");
		out.println("<a href='/myweb/getcookie'>get Cookie</a>");
		out.println("</body></html>");
		
	}
	
}
