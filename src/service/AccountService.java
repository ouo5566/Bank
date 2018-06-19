package service;
import domain.*;

public interface AccountService {
	public void createAccount(AccountBean accountBean);
	public void createMinusAccount(AccountBean accountBean,String limit);
	public void addList(AccountBean accountBean);
	public AccountBean[] list();
	public String createAccountNum(String random);
	public String createRandom(int start, int end);
	public String createDate();
	public String showResult(AccountBean[] beanArr);
	public AccountBean findById(AccountBean accountBean);
	public int countSameWord(String word);
	public AccountBean[] findByName(String name);
	public int countMinusList();
	public AccountBean[] findMinusList();
	public String changePassWord(AccountBean accountBean);
	public String deleteAccount(AccountBean accountBean);
}
