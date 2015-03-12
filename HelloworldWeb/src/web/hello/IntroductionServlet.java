package web.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntroductionServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //response에서 Writer를 불러와 PrintWriter를 만듬.
		out.println("<!doctype html><html><head><title>자기소개</title></head><body>");
		out.println("<b>저는 김동휘 입니다.</b><br/> 서블릿 소스는 아래와 같습니다.<br/><br/>");
		out.println("package web.hello;<br/>"
				+ "import java.io.IOException;<br/>"
				+ "import java.io.PrintWriter;<br/>"
				+ "import javax.servlet.http.HttpServlet<br/>"
				+ "import javax.servlet.http.HttpServletRequest;<br/>"
				+ "import javax.servlet.http.HttpServletResponse;<br/><br/>"
				+ "public class IntroductionServlet extends HttpServlet{<br/>"
				+ "　　public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{<br/>"
				+ "　　　　response.setContentType(\"text/html;charset=UTF-8\");<br/>"
				+ "　　　　PrintWriter out = response.getWriter();<br/>"
				+ "　　　　out.println(\"저는 김동휘 입니다.\");<br/>"
				+ "　　}<br/>"
				+ "}<br/>"
				+ "<br/>");
		out.println("web.xml에 쓴 내용은 아래와 같습니다 <br/>");
		out.println("&ltservlet&gt<br/>"
				+ "　　&ltservlet-name&gtintroduction&lt/servlet-name&gt<br/>"
				+ "　　&ltservlet-class&gtweb.hello.IntroductionServlet&lt/servlet-class&gt<br/>"
				+ "&lt/servlet&gt<br/>"
				+ "&ltservlet-mapping&gt<br/>"
				+ "　　&ltservlet-name&gtintroduction&lt/servlet-name&gt<br/>"
				+ "　　&lturl-pattern&gt/introductionServlet&lt/url-pattern&gt<br/>"
				+ "&lt/servlet-mapping&gt<br/><br/>");
		out.println("<img src=\"http://cfile3.uf.tistory.com/original/140735044CA441AA3098A9\">");
		out.println("</body></html>");
	}
	
}
