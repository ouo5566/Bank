package domain;

public class StaffBean extends MemberBean{
	private String accessNum;
	
	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}

	@Override
	public String toString() {
		return "[회원정보]\n"
				+ "아이디 :" + uid
				+ "\n비밀번호 : " + password
				+ "\n이름  : " + name
				+ "\n주민등록번호 : " + ssn
				+ "\n주소 : " + address
				+ "\n핸드폰번호 : " + phone
				+ "\n접근번호 : " + accessNum + "\n";
	}
}
