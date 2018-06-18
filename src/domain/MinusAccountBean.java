package domain;

public class MinusAccountBean extends AccountBean{
	public final static String ACCOUNT_TYPE="마이너스통장";
	protected int limit;
	public void setLimit(String limit) {
		this.limit = Integer.parseInt(limit);
	}
	public int getLimit() {
		return limit;
	}
	public String toString() {
		return String.format("[%s]\n %s\n 생성일 : %s\n 계좌번호 : %s\n 이름 : %s\n 대출한도 : -%s\n", BANK_NAME,accountType,createDate,accountNo,name,limit)+"\n";
	}
}
