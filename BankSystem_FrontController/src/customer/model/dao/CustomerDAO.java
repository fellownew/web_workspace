package customer.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DataBaseUtil;
import common.vo.Customer;

public class CustomerDAO {
	private static CustomerDAO dao = new CustomerDAO();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();
	
	private CustomerDAO(){}
	
	public static CustomerDAO getInstance(){
		return dao;
	}
	//회원 가입시 DB에 등록할 메소드.
	public void insertCustomer(Customer customer){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="insert into member values(?,?,?,?,?)";
		try{
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getName());
			pstmt.executeUpdate();
			
		}catch(SQLException e ){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
	}
	//모든 회원 리스트 출력 메소드. ArrayList 리턴.
	public ArrayList<Customer> selectAllCustomer(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql="select *from member";
		ArrayList<Customer> members=new ArrayList<>();
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
//				members.add(new Customer(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getDate(5)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(rset, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
		return members;
	}
	
	public Customer selectCustomerById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer member = null;
		String sql="select member_id,member_pwd,member_name,member_email,member_date from member where member_id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()){
//				member =new Customer(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getDate(5));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(rset, pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
		return member;
	}
	
	public int updateCustomer(Customer customer){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="update member set member_pwd=?,member_name=?,member_email=? where member_id=?";
		int count = 0;
		try{
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customer.getPassword());
			pstmt.setString(2, customer.getName());
			pstmt.setString(4, customer.getId());
			count = pstmt.executeUpdate();
			
		}catch(SQLException e ){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public void deleteCustomerById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="delete from member where member_id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(pstmt, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("뭔가 안닫힘");
				e.printStackTrace();
			}
		}
	}
}