package domain;
public class AccountBean {
	public final static String BANK_NAME="비트뱅크";
	public final static String ACCOUNT_TYPE="기본통장";
	public final static String WITHDRAW_SUCCESS="출금성공";
	public final static String WITHDRAW_FAIL="잔액부족";
	public final static String DEPOSIT_SUCCESS="입금성공";
	public final static String DEPOSIT_FAIL="적합한 입력값이 아님";
	protected int money;
	protected String name, uid, password, accountType, accountNo, createDate;
	public void setMoney(String money) {
		this.money = Integer.parseInt(money);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPassWord(String password) {
		this.password = password;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getMoney() {
		return money;
	}
	public String getName() {
		return name;
	}
	public String getUid() {
		return uid;
	}
	public String getPassWord() {
		return password;
	}
	public String getAccountType() {
		return accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public String toString() {
		return String.format("[%s]\n %s\n 생성일 : %s\n 계좌번호 : %s\n 이름 : %s\n", BANK_NAME,accountType,createDate,accountNo,name);
	}
}
