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

public class SearchByIdServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//request parameter 가져오기
		int id = Integer.parseInt(request.getParameter("id"));
		//DB 접속. 접속 정보 web.xml에서 가져오기.	
		ServletContext context = getServletContext();
		//		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = context.getInitParameter("url"); 
		String user = context.getInitParameter("user");
		String password = context.getInitParameter("password");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		try {
//			Class.forName(driver);
			String sql = "select department_id,department_name,location from department where department_id=?";
			conn = DriverManager.getConnection(url,user,password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()){
				int rId = rset.getInt(1);
				String rName = rset.getString(2);
				String rLocation = rset.getString(3);
				request.setAttribute("id", rId);
				request.setAttribute("name", rName);
				request.setAttribute("location", rLocation);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rset!=null){
				try {
					rset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//RequestDispatch
		RequestDispatcher rd = request.getRequestDispatcher("/department/search_result.jsp");
		rd.forward(request, response);
		
		
	}
}
