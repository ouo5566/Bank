package domain;

public class MemberBean {
	protected String uid, password, name, ssn, address, phone, email;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "[회원정보]\n"
				+ "아이디 :" + uid
				+ "\n비밀번호 : " + password
				+ "\n이름  : " + name
				+ "\n주민등록번호 : " + ssn
				+ "\n주소 : " + address
				+ "\n핸드폰번호 : " + phone + "\n";
	}

	
}
