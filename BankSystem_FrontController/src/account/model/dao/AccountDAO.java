package account.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.util.DataBaseUtil;
import common.vo.Account;

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

}
