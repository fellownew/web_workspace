package calc.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import calc.model.dao.CalcResultDAO;

public class CalculateService {
	private static CalculateService inst = new CalculateService();
	private CalcResultDAO dao;
	private BasicDataSource dataSource;
	private Connection conn;
	
	
	private CalculateService(){
		dao = CalcResultDAO.getInstance();
		dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static CalculateService getInstance(){
		return inst;
	}
	
	
	public int plus(int num1,int num2){
		int result = num1+num2;
		dao.insertResult(result);
		return result;
	}
	
	public int minus(int num1,int num2){
		int result = num1-num2;
		dao.insertResult(result);
		return result;
	}
	
	public int division(int num1,int num2){
		int result = num1/num2;
		dao.insertResult(result);
		return result;
	}
	
}
