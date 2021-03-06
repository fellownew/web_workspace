package department.jdbc;

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
	private static BasicDataSource dataSource= new BasicDataSource();

	private DataBaseUtil() {
//		ServletContext context = getServletContext();
		// String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = context.getInitParameter("url");
//		String user = context.getInitParameter("user");
//		String password = context.getInitParameter("password");
//		dataSource = new BasicDataSource();
// dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		dataSource.setUrl(url);
//		dataSource.setUsername(user);
//		dataSource.setPassword(password);
	}
	
	public static DataBaseUtil getInstance(){
		return inst;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
//	public void doGet(HttpServletRequest request, HttpServletResponse response){
//		
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
