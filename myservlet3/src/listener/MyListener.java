package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener : <listener>
@WebListener
public class MyListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("MyListener.contextInitalialized()");
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("Mylistener.contextDstroyed()");
	}

}
