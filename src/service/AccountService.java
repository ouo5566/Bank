package service;
import domain.Account;

public interface AccountService {
	public Account createAccount(String name, String uid, String password);
	public Account createMinusAccount(String name, String uid, String password);
	public void addList(Account account);
	public Account[] list();
	public String createAccountNum(String random);
	public String createRandom(int start, int end);
	public String createDate();
	public String showResult();
}
