package servlet.session;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLoginServlet extends HttpServlet{
	private HashMap<String , String> userInfo;
	public void init(){
		userInfo = new HashMap<String, String>();
		userInfo.put("id-1", "1111");
		userInfo.put("id-2", "2222");
		userInfo.put("id-3", "3333");
		userInfo.put("id-4", "4444");
		userInfo.put("id-5", "5555");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//파라미터 조회
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String failMessage = null; // 로그인 실패시 넘길 메시지
		
		//비지니스 로직
		if(userInfo.containsKey(id)){
			if(userInfo.get(id).equals(password)){
				HttpSession session = request.getSession();
//				System.out.println(session.isNew()); //jsp가 나온 뒤부터 자동으로 만들어주기때문에 체크가 불가함.
				//따라서 로그인 여부를 체크 할때 사용할 attribute를 session scope에 binding 시켜서 확인 한다.
				session.setAttribute("login_id", id);
				
			}else{
				failMessage = "비밀번호가 틀립니다.";
			}
		}else{
			failMessage = "없는 ID입니다.";
		}
		
		//응답
		
		if(failMessage!=null){//로그인에 실패했다면.
			request.setAttribute("failmessage", failMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/session/login_form.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("/myweb/session/login_success.jsp");
		}
	}
}
