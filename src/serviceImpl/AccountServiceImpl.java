package serviceImpl;

import java.util.List;
import domain.AccountBean;
import domain.MinusAccountBean;
import service.AccountService;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AccountServiceImpl implements AccountService {
	List<AccountBean> list;

	public AccountServiceImpl() {
		list = new ArrayList<>();
	}

	@Override
	public void createBasic(AccountBean account) {
		account.setAccountNo(createAccountNo(createRandom(0,999_999_999)));
		account.setAccountType(AccountBean.ACCOUNT_TYPE);
		account.setCreateDate(createDate());
		list.add(account);
	}

	@Override
	public void createMinus(AccountBean account) {
		account.setAccountNo(createAccountNo(createRandom(0,999_999_999)));
		account.setAccountType(MinusAccountBean.ACCOUNT_TYPE);
		account.setCreateDate(createDate());
		list.add(account);
	}
	@Override
	public String createAccountNo(String random) {
		return String.format("%s-%s-%s",random.substring(0,3),random.substring(3,6),random.substring(6,9));
	}
	
	@Override
	public String createRandom(int start, int end) {
		return String.format("%09d",((int)(Math.random() * end) + start));
	}
	
	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}
	
	@Override
	public List<AccountBean> list() {
		return list;
	}

	@Override
	public List<AccountBean> searchWord(String param) {
		List<AccountBean> arr = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (param.equals(list.get(i).getName())) {
				arr.add(list.get(i));
			}
		}
		return arr;
	}

	@Override
	public AccountBean search(AccountBean account) {
		AccountBean temp = new AccountBean();
		for (int i = 0; i < list.size(); i++) {
			if (account.getUid().equals(list.get(i).getUid()) && account.getPassWord().equals(list.get(i).getPassWord())) {
				temp = list.get(i);
				break;
			}
		}
		return temp;
	}

	@Override
	public int selectCount() {
		return list.size();
	}

	@Override
	public void updateAccount(AccountBean account) {
		String pass = account.getPassWord().split("/")[0];
		String newPass = account.getPassWord().split("/")[1];
		account.setPassWord(pass);
		list.get(list.indexOf(search(account))).setPassWord(newPass);
	}

	@Override
	public void deleteAccount(AccountBean account) {
		String pass = account.getPassWord().split("/")[0];
		String confirmPass = account.getPassWord().split("/")[1];
		account.setPassWord(pass);
		if(pass.equals(confirmPass)) list.remove(list.indexOf(search(account)));
	}

	@Override
	public List<AccountBean> minusList() {
		List<AccountBean> arr = new ArrayList<>();
		for(int i = 0 ; i < list.size() ; i++ ) {
			if(list.get(i) instanceof MinusAccountBean) {
				arr.add(list.get(i));
			}
		}
		return arr;
	}
}
