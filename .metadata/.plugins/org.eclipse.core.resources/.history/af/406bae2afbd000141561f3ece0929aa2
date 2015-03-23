package department.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.jdbc.DataBaseUtil;
import department.vo.Department;

public class RegisterDepartmentServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		DataBaseUtil dbUtil = DataBaseUtil.getInstance();
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into department values (?,?,?)";
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		
		ServletContext context = getServletContext();
		String url = context.getInitParameter("url"); 
		String user = context.getInitParameter("user");
		String password = context.getInitParameter("password");
		
		String responseUrl = "";
		
		try{
//			conn = DataBaseUtil.getConnection();
			conn = DriverManager.getConnection(url,user,password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, location);
			pstmt.executeUpdate();
			request.setAttribute("dept", new Department(id, name, location));
			responseUrl = "/department/register_result.jsp";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error_message", "조회중 에러 - "+e.getMessage());
			responseUrl = "/error_page.jsp";//SQLException이 발생 했을때의 위치
			
		}finally{
			try {
				dbUtil.close(null, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		RequestDispatcher rd = request.getRequestDispatcher(responseUrl);
		rd.forward(request, response);
		
		
	}

}
