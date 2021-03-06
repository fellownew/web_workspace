package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private String dbID="java",dbPwd="servlet";
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//요청 파라미터 조회
		String id=request.getParameter("id");
		String pwd = request.getParameter("password");
		
		boolean flag = false; // 로그인 성공 여부
		String fileMesseage=null;
		
		if(id.equals(dbID)){//ID 일치 여부
			if(pwd.equals(dbPwd)){//pwd 일치 여부
				flag = true;
			}else{//pwd 틀림
				fileMesseage ="비밀번호가 틀렸습니다.";
			}
		}else{//id틀림
			fileMesseage = "없는 ID 입니다.";
		}
		
		
		out.println("<html><head><title>로그인</title></head><body>");
		
		
		if(flag){
			out.println(id+"님 로그인 성공");
		}else{
			out.println(fileMesseage+"<br/>");
			out.println("<a href='/myweb/form/login'>다시 로그인</a>");
		}
		
		
		out.println("</body></html>");
		
	}
}