package servlet.lifecycle;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleServlet extends HttpServlet{
	public LifecycleServlet(){
		System.out.println("LifecycleServlet.생성자 () 호출");
	}
	
	//객체 생성 직후 호출 되는 메소드
	public void init(){
		System.out.println("LifecycleServlet.init() 호출");
	}
	
	//서블릿 객체 소멸 직전에 호출되는 메소드
	public void destroy(){
		System.out.println("LifecycleServlet.destroy() 호출");
	}
	//HttpServlet에서 service()를 대신하는 메소드로 GET 방식 요청을 처리하는 메소드
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		System.out.println("LifecycleServlet.service() : doGet() 호출");
		
	}
}
