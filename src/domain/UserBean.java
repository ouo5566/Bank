package domain;
import domain.MemberBean;
public class UserBean extends MemberBean{
	private String creditRating;
	
	public String getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
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
				+ "\n신용등급 : " + creditRating + "\n";
	}

}
