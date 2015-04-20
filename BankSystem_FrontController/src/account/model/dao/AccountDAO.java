package account.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DataBaseUtil;
import common.vo.Account;
import common.vo.Type;

public class AccountDAO {
private static AccountDAO inst = new AccountDAO();
private DataBaseUtil dbUtil = DataBaseUtil.getInstance();

private AccountDAO(){}
	public static AccountDAO getInstance(){
		return inst;
	}
	//신규 계좌 
	public void insertAccount(Account account){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="insert into account values(?,?,?,?)";
	
		try{
			conn=dbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account.getAccountId());
			pstmt.setString(2, account.getPassword());
			pstmt.setLong(3, account.getAmount());
			pstmt.setObject(4,account.getType());
	
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
	//해당ID가 보유하고 있는 통장Id 리스트
	public ArrayList<String> selectAllAccountIdByCustomerId(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select account_id from account_list where customer_id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(rset.getString(1));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	//받은 통장 아이디들로 해당 통장들의 정보를 리턴.
	public ArrayList<Account> selectAllAccountByIds(ArrayList<String> ids){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Account> list = new ArrayList<Account>();
		String sql = "select *from account where account_id=?";
		try{
			conn = dbUtil.getConnection();
			for(String id:ids){
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rset = pstmt.executeQuery();
				if(rset.next()){
					list.add(new Account(rset.getString(1), rset.getString(2), rset.getLong(3), (Type)rset.getObject(4)));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
