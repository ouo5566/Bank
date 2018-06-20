package service;
import java.util.List;
import domain.*;

public interface AccountService {
	public void createBasic(AccountBean account);
	public void createMinus(AccountBean account);
	public String createAccountNo(String random);
	public String createRandom(int start, int end);
	public String createDate();
	public List<AccountBean> list();
	public List<AccountBean> searchWord(String param);
	public AccountBean search(AccountBean account);
	public int selectCount();
	public void updateAccount(AccountBean account);
	public void deleteAccount(AccountBean account);
	public List<AccountBean> minusList();
}
