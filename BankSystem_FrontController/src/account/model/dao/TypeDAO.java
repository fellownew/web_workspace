package account.model.dao;

import common.util.DataBaseUtil;

public class TypeDAO {
	private static TypeDAO inst = new TypeDAO();
	private DataBaseUtil dbUtil = DataBaseUtil.getInstance();
	private TypeDAO(){}
	
	public static TypeDAO getInstance(){
		return inst;
	}
	
}
