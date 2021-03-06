package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet  extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//실행 시점의 일시를 쿠키로 전송
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//클라이언트가 HTTP 요청정보의 Header를 이용해 전송한 쿠키값들 조회
		Cookie[] cookies=request.getCookies();
		out.println("<html><head><title>쿠키조회</title></head><body>");
		
		if(cookies==null){
			out.println("전송된 쿠키값이 하나도 없습니다.");
		}
		for(int i=0;i<cookies.length;i++){
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			if(name.equals("name")){ // 특정 쿠키값 조회 후 작업.
				value=URLDecoder.decode(value, "UTF-8");
			}
			out.println(name+" : "+value+"<br/>");
		}
		
		out.println("<a href='/myweb/setcookie1'>set Cookie1</a><br/>");
		out.println("<a href='/myweb/setcookie2'>set Cookie2</a>");
		out.println("</body></html>");
	}
}
