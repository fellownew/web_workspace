package calc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class CalcResultDAO {
	private static CalcResultDAO dao = new CalcResultDAO();

	
	private CalcResultDAO(){}
		
	public static CalcResultDAO getInstance(){
		return dao;
	}
	
	public void insertResult(int result){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		conn = dataSource.getConnection();
		
		System.out.println("insert into calc_result (result)구문 처리 완료 ");
		
	}
}