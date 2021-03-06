package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet{
	private String dbID="java",dbPwd="servlet";
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//요청 파라미터 조회
		String id=request.getParameter("id");
		String pwd = request.getParameter("password");
		
		boolean flag = false; // 로그인 성공 여부
		String fileMessage=null;
		
		//처리부분
		if(id.equals(dbID)){//ID 일치 여부
			if(pwd.equals(dbPwd)){//pwd 일치 여부
				flag = true;
			}else{//pwd 틀림
				fileMessage ="비밀번호가 틀렸습니다.";
			}
		}else{//id틀림
			fileMessage = "없는 ID 입니다.";
		}
		request.setAttribute("Messeage", fileMessage);//Message라는 이름으로 fileMesseage값 저장.
		//로그인 결과를 응답
		//성공 시 : 리다이렉트 방식으로 login_success.html로 이동
		//실패 시 : 요청디스패치방식으로 login_fail.jsp로 이동.
		if(flag){//성공 시
			response.sendRedirect("/myweb/form/login_success.html");
		}else{
			request.setAttribute("fail_message", fileMessage);
			RequestDispatcher rd= request.getRequestDispatcher("/form/login_fail.jsp");//app기준의 url이기 때문에 /myweb으로 시작하면 안됨.
			rd.forward(request, response);
		}


		
	}
}