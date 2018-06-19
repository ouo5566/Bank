package service;

import domain.MemberBean;

public interface MemberService {
	public void creatUser(MemberBean memberBean);
	public void creatSteff(MemberBean memberBean);
	public void addList(MemberBean memberBean);
	public MemberBean[] list();
	public String showResult(MemberBean[] memberBean);
	public MemberBean findById(MemberBean memberBean);
	public int countSameWord(String word);
	public MemberBean[] findByWord(String word);
	public String readCount();
	public String updateMember(MemberBean memberBean);
	public String withDrawalMember(MemberBean memberBean);
}
