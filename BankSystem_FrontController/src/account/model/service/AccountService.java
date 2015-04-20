package account.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import account.model.dao.AccountDAO;
import common.util.DataBaseUtil;
import common.vo.Account;

public class AccountService {
	private static AccountService inst = new AccountService();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();
	private AccountDAO dao = AccountDAO.getInstance();
	
	public static AccountService getInstance(){
		return inst;
	}
	
	//id가 가지고 있는 통장 리스트를 리턴.
	public ArrayList<Account> accountListById(String id){
		Connection conn = null;
		ArrayList<String> accIdList = null;
		ArrayList<Account> accList = null;
		try{
		conn = dbUtil.getConnection();
		conn.setAutoCommit(false);
		accIdList = dao.selectAllAccountIdByCustomerId(id);
		accList = dao.selectAllAccountByIds(accIdList);
		conn.commit();
		conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return accList;
	}
}