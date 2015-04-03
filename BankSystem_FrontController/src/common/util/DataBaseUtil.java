package common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DataBaseUtil{
	private static DataBaseUtil inst = new DataBaseUtil();
	private BasicDataSource dataSource;

	private DataBaseUtil() {}
	
	public static DataBaseUtil getInstance(){
		return inst;
	}
	public void setDataSource(BasicDataSource dataSource){
		this.dataSource=dataSource;
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void close(ResultSet rset, Statement stmt, Connection conn)throws SQLException {
		if (rset != null) {
			rset.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}	
	public void close(Statement stmt, Connection conn)throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	
}
