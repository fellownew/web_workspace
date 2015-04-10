package customer.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DataBaseUtil;
import common.vo.Customer;

import customer.exception.DuplicationIdException;
import customer.model.dao.CustomerDAO;

public class CustomerService {
	private static CustomerService inst = new CustomerService();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();
	private CustomerDAO dao = CustomerDAO.getInstance();
	
	private CustomerService(){}
	
	public static CustomerService getInstance(){
		return inst;
	}
	//가입
	public void joinCustomer(Customer customer) throws DuplicationIdException{
		Connection conn = null;
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO 회원 가입 DAO 불러오기
		if(customer.getId().trim().equals("")){
			throw new DuplicationIdException("허용되지 않는 아이디입니다.");
		}
		if(dao.selectCustomerById(customer.getId())!=null){
			throw new DuplicationIdException("이미 있는 아이디 입니다.");
		}
		dao.insertCustomer(customer);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//모든 회원정보를 가져옴
	public ArrayList<Customer> getCustomerList(){
		Connection conn = null;
		ArrayList<Customer> members = null;
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		members = dao.selectAllCustomer();
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	return members;
	}
	//로그인 한 사람의 정보를 가져옴
	public Customer getCustomerById(String id){
		Connection conn = null;
		Customer customer = null;
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		customer = dao.selectCustomerById(id);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return customer;
	}
	//회원 정보 갱신
	public void modifyCustomer(Customer customer){
		Connection conn = null;
		
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		int count = dao.updateCustomer(customer);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//회원 탈퇴
	public void removeCustomerById(String id){
		Connection conn = null;
		
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		//TODO DAO 불러오기
		dao.deleteCustomerById(id);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean loginCustomer(Customer customer){
		Connection conn = null;
		boolean flag = false;
		try{
			//TODO DAO 불러오기
			String id = customer.getId();
			if(id==null){
				return flag;
			}
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);			
			Customer selMember = dao.selectCustomerById(id);
			if(selMember!=null&&customer.getPassword().equals(selMember.getPassword())){
				flag = true;
			}
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}
