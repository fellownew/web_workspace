package common.util;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


public class BasicDataSourceListener implements ServletContextListener{

	//BasicDataSource 객체를 생성.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		BasicDataSource dataSource = new BasicDataSource();
		ServletContext ctx = event.getServletContext();
		dataSource.setUrl(ctx.getInitParameter("url"));
		dataSource.setUsername(ctx.getInitParameter("user"));
		dataSource.setPassword(ctx.getInitParameter("password"));
		dataSource.setMaxActive(10);
		dataSource.setInitialSize(8);
		
		ctx.setAttribute("dataSource", dataSource);
		
		DataBaseUtil dbUtil = DataBaseUtil.getInstance();
		dbUtil.setDataSource(dataSource);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//BasicDataSource객체.close()이것은 반납처리가 아닌 정말 close()함
		ServletContext ctx = event.getServletContext();
		BasicDataSource dataSource = (BasicDataSource) ctx.getAttribute("dataSource");
		if(dataSource!=null){
			try {
				dataSource.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("리스너의 뭔가 안닫힘");
				e.printStackTrace();
			}
		}
	}
}
