package domain;

public class MinusAccount extends Account{
	public final static String ACCOUNT_TYPE="마이너스통장";
	public MinusAccount(String name, String uid, String password) {
		super(name,uid,password);
	}
}
