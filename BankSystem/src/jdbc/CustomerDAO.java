package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


public class CustomerDAO {
	private static CustomerDAO dao = new CustomerDAO();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();
	private BasicDataSource dataSource;
	
	private CustomerDAO(){}
	
	public static CustomerDAO getInstance(){	
		return dao;
	}
	
	public void setDataSource(BasicDataSource dataSource){
		this.dataSource=dataSource;
	}
	
	public int insertCustomer(String id,String password,String name,String sex,int age,String job,String address,String phoneNum) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into customer values (?,?,?,?,?,?,?,?,?)";
		int count;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password );
			pstmt.setString(3, name);
			pstmt.setInt(4, 9);//신용등급 9등급
			pstmt.setString(5, job);
			pstmt.setInt(6, age);
			pstmt.setString(7, sex);
			pstmt.setString(8, address);
			pstmt.setString(9, phoneNum);
			count = pstmt.executeUpdate();
		} finally {
			dbUtil.close(null, pstmt, conn);
		}
		return count;
	}
	
	public int findCustomer(String id) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		String sql = "select *from customer where customer_id=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()){
				count = 1;
			}
			
		} finally {
			dbUtil.close(rset, pstmt, conn);
		}
		return count;
	}
	
	
	
	public int loginCheckCustomer(String id,String password) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select customer_id,customer_pwd from customer where customer_id=?";
		int count=0;
		try {

			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()){
				if(rset.getString(1).equals(id)){
					if(rset.getString(2).equals(password)){
						count=1;
					}else{
						count=0;
					}
				}else{
					count=0;
				}		
			}else{
				count=0;
			}
			
		} finally {
			dbUtil.close(rset, pstmt, conn);
		}
		return count;		
	}
}
