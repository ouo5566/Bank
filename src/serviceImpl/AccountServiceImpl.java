package serviceImpl;

import java.util.Date;
import java.text.SimpleDateFormat;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	private Account[] list;
	private int count;

	public AccountServiceImpl() {
		list = new Account[10];
		count = 0;
	}

	@Override
	public Account createAccount(String name, String uid, String password) {
		Account basic = new Account(name, uid, password);
		basic.setAccountType(basic.ACCOUNT_TYPE);
		basic.setAccountNo(createAccountNum(createRandom(0, 999_999_999)));
		basic.setCreateDate(createDate());
		addList(basic);
		return basic;
	}

	@Override

	public Account createMinusAccount(String name, String uid, String password) {
		Account minus = new MinusAccount(name, uid, password);
		minus.setAccountType(minus.ACCOUNT_TYPE);
		minus.setAccountNo(createAccountNum(createRandom(0, 999_999_999)));
		minus.setCreateDate(createDate());
		addList(minus);
		return minus;
	}

	@Override
	public void addList(Account account) {
		list[count++] = account;
	}

	@Override
	public Account[] list() {
		return list;
	}

	@Override
	public String createAccountNum(String random) {
		return String.format("%s-%s-%s", random.substring(0, 3), random.substring(3, 6), random.substring(6, 9));
	}

	@Override
	public String createRandom(int start, int end) {
		return String.valueOf((int) (Math.random() * (end + 1)) + start);
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public String showResult() {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += list()[i] + "\n";
		}
		return result;
	}
}
