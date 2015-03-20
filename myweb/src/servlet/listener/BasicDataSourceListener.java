package servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


public class BasicDataSourceListener implements ServletContextListener{

	//BasicDataSource 객체를 생성.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		BasicDataSource dataSource = new BasicDataSource();
		ServletContext ctx = event.getServletContext();
		dataSource.setUrl(ctx.getInitParameter("url"));
		dataSource.setUsername(ctx.getInitParameter("user"));
		dataSource.setPassword(ctx.getInitParameter("password"));
//		dataSource.setMaxActive(10);
//		dataSource.setInitialSize(8);
		
		ctx.setAttribute("dataSource", dataSource);
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}


	
	

}
