package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DataBaseUtil{
	private static DataBaseUtil inst = new DataBaseUtil();
//	private static BasicDataSource dataSource= new BasicDataSource();

	private DataBaseUtil() {}
	
	public static DataBaseUtil getInstance(){
		return inst;
	}

//	public static Connection getConnection() throws SQLException {
//		return dataSource.getConnection();
//	}

	public void close(ResultSet rset, Statement stmt, Connection conn)
			throws SQLException {
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
}
