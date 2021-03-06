package department.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import department.jdbc.DataBaseUtil;
import department.vo.Department;

public class SearchByIdServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		DataBaseUtil dbUtil = DataBaseUtil.getInstance();

		//request parameter 가져오기
		int id = Integer.parseInt(request.getParameter("id"));
		//DB 접속. 접속 정보 web.xml에서 가져오기.	
		ServletContext context = getServletContext();
		//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = context.getInitParameter("url"); 
//		String user = context.getInitParameter("user");
//		String password = context.getInitParameter("password");
		BasicDataSource dataSource = (BasicDataSource)context.getAttribute("dataSource");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Department dept = null;
		String responseUrl=null;
		
		
		try {
//			Class.forName(driver);
			String sql = "select department_name,location from department where department_id=?";
//			conn = DriverManager.getConnection(url,user,password);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
//			String name = null;
//			String location =null;
//			
			if(rset.next()){
				dept = new Department(id, rset.getString(1), rset.getString(2));
//				name = rset.getString(1);
//				location = rset.getString(2);
			}
//			request.setAttribute("id", id);
//			request.setAttribute("name", name);
//			request.setAttribute("location", location);
			request.setAttribute("result", dept);
			responseUrl = "/department/search_result.jsp"; //문제 없이 sql 작업이 끝났을때의 위치
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error_message", "조회중 에러 - "+e.getMessage());
			responseUrl = "/error_page.jsp";//SQLException이 발생 했을때의 위치
		}finally{
			try {
				dbUtil.close(rset, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//RequestDispatch
		RequestDispatcher rd = request.getRequestDispatcher(responseUrl);
		rd.forward(request, response);
		
		
	}
}
