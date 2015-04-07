package common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;



public class DatabaseUtil {
	private static DatabaseUtil instance = new DatabaseUtil();
	
	private BasicDataSource bds;
	private DatabaseUtil(){
		bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		bds.setUsername("scott");
		bds.setPassword("tiger");
		bds.setInitialSize(30);
		bds.setMaxIdle(50);
		bds.setMaxActive(100);
		bds.setMaxWait(10000);
	}
	
	public static DatabaseUtil getInstance(){
		return instance;
	}
	public Connection getConnection() throws SQLException{
		return bds.getConnection();
	}
	public void close(Connection conn) throws SQLException{
		if(conn != null){
			conn.close();
		}
	}
	public void close(PreparedStatement pstmt)  throws SQLException{
		
		if(pstmt != null){
			pstmt.close();
		}
		
	}
	public void close(PreparedStatement pstmt, ResultSet rset)  throws SQLException{
		if(rset != null){
			rset.close();
		}
		if(pstmt != null){
			pstmt.close();
		}
	}
	
}
















