package account.model.dao;

public class AccountDAO {
private static AccountDAO inst = new AccountDAO();

public static AccountDAO getInstance(){
	return inst;
}

}
