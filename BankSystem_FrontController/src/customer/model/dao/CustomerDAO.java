package customer.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DataBaseUtil;
import common.vo.Account;
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
		String sql="insert into customer values(?,?,?,?,?,?,?,?,?,?)";

		try{
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getName());
			pstmt.setObject(4,null);
			pstmt.setInt(5, customer.getCreditRating());
			pstmt.setString(6, customer.getJob());
			pstmt.setInt(7, customer.getAge());
			pstmt.setBoolean(8, customer.isSex());
			pstmt.setString(9, customer.getPhoneNumber());
			pstmt.setString(10, customer.getAddress());
			
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
		String sql="select *from customer";
		ArrayList<Customer> customers=new ArrayList<>();
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				customers.add(new Customer(rset.getString(1),rset.getString(2),rset.getString(3),(ArrayList<Account>)rset.getObject(4),rset.getInt(5),rset.getString(6),rset.getInt(7),rset.getBoolean(8),rset.getString(9),rset.getString(10)));
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
		return customers;
	}
	
	public Customer selectCustomerById(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = null;
		String sql="select *from customer where customer_id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()){
				customer = new Customer(rset.getString(1),rset.getString(2),rset.getString(3),(ArrayList<Account>)rset.getObject(4),rset.getInt(5),rset.getString(6),rset.getInt(7),rset.getBoolean(8),rset.getString(9),rset.getString(10));
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
		return customer;
	}
	
	public int updateCustomer(Customer customer){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="update customer set customer_password=?,customer_name=?,customer_job=?,customer_age=?,customer_sex=?,customer_phoneNumber=?,customer_address =? where customer_id=?";
		int count = 0;
		try{
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, customer.getPassword());
			pstmt.setString(2, customer.getName());
			pstmt.setString(3, customer.getJob());
			pstmt.setInt(4, customer.getAge());
			pstmt.setBoolean(5, customer.isSex());
			pstmt.setString(6, customer.getPhoneNumber());
			pstmt.setString(7, customer.getAddress());
			pstmt.setString(8, customer.getId());
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
		String sql="delete from customer where customer_id=?";
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
