package serviceImpl;

import java.util.Date;
import java.text.SimpleDateFormat;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountBean[] list;
	private int count;

	public AccountServiceImpl() {
		list = new AccountBean[10];
		count = 0;
	}

	@Override
	public void createAccount(AccountBean basic) {
		basic.setAccountType(AccountBean.ACCOUNT_TYPE);
		basic.setAccountNo(createAccountNum(createRandom(0, 999_999_999)));
		basic.setCreateDate(createDate());
		addList(basic);
	}

	@Override
	public void createMinusAccount(AccountBean minus, String limit) {
		minus.setAccountType(MinusAccountBean.ACCOUNT_TYPE);
		minus.setAccountNo(createAccountNum(createRandom(0, 999_999_999)));
		minus.setCreateDate(createDate());
		((MinusAccountBean) minus).setLimit(limit);
		addList(minus);
	}

	@Override
	public void addList(AccountBean account) {
		list[count++] = account;
	}

	@Override
	public AccountBean[] list() {
		return list;
	}

	@Override
	public String createAccountNum(String random) {
		return String.format("%s-%s-%s", random.substring(0, 3), random.substring(3, 6), random.substring(6, 9));
	}

	@Override
	public String createRandom(int start, int end) {
		return String.format("%09d", (int) (Math.random() * (end + 1)) + start);
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	@Override
	public String showResult(AccountBean[] beanArr) {
		String result = "";
		int count = (this.count < beanArr.length) ? this.count : beanArr.length;
		for (int i = 0; i < count; i++) {
			result += beanArr[i];
		}
		return result;
	}

	@Override
	public AccountBean findById(AccountBean accountBean) {
		AccountBean searchedAccount = new AccountBean();
		// 배열 list 를 looping 하면서 ID 와 PASS 가 일치한 값을 찾아서 그 객체를 리턴한다.
		// 일치하는 값이 없는 상황은 나중에 처리.
		for (int i = 0; i < count; i++) {
			if (accountBean.getUid().equals(list[i].getUid())
					&& accountBean.getPassWord().equals(list[i].getPassWord())) {
				searchedAccount = list[i];
				break;
			}
		}
		return searchedAccount;
	}

	@Override
	public int countSameWord(String word) {
		int samecount = 0;
		for (int i = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				samecount++;
			}
		}
		return samecount;
	}

	@Override
	public AccountBean[] findByName(String name) {
		AccountBean[] searchedAccount = new AccountBean[countSameWord(name)];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				searchedAccount[j++] = list[i];
			}
		}
		return searchedAccount;
	}
	
	@Override
	public int countMinusList() {
		int count = 0;
		for(int i = 0 ; i < this.count ; i++) {
//			if(MinusAccountBean.ACCOUNT_TYPE.equals(list[i].getAccountType())) {
			if(list[i] instanceof MinusAccountBean) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public AccountBean[] findMinusList() {
		AccountBean[] minusList = new MinusAccountBean[countMinusList()];
		int j = 0;
		for(int i = 0 ; i < this.count ; i++) {
//			if(MinusAccountBean.ACCOUNT_TYPE.equals(list[i].getAccountType())) {
			if(list[i] instanceof MinusAccountBean) {
				minusList[j++] = list[i];
			}
		}
		return minusList;
	}

}
