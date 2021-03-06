package servlet.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
/**
 * 
 * Application(myweb)이 시작되는 시점과 종료되는 시점에 실행될 코드를 작성할 Listener클래스
 * javax.servlet.ServletContextListener 인터페이스 이용.
 * 시작 : contextDestroyed
 * 종료 : contextInitialized
 * 
 * web.xml에 등록해야함.
 * <listener>
 * 	<litener-class>
 * 
 * 
 */
public class MyListener implements ServletContextListener{
	//application 시작시 호출
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// event로부터 ServletContext 객체를 조회
		ServletContext ctx = event.getServletContext();
		String date = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
		ctx.setAttribute("startTime", date); //app 시작 시간을 저장함.
		
		System.out.println("--------------------------------------");
		System.out.println("myweb application 시작"+ctx.getInitParameter("address"));
		System.out.println("--------------------------------------");
		
	}
	
	//application 종료시 호출
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		System.out.println("==========================================");
		System.out.println("myweb application종료 : 시작 된 시간 "+ctx.getAttribute("startTime"));
		System.out.println("==========================================");
	}


	

}
