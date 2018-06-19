package serviceImpl;

import domain.*;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	MemberBean[] list;
	int count;

	public MemberServiceImpl() {
		list = new MemberBean[10];
		count = 0;
	}

	@Override
	public void creatUser(MemberBean memberBean) {
		((UserBean) memberBean).setCreditRating("7");
		addList(memberBean);
	}

	@Override
	public void creatSteff(MemberBean memberBean) {
		((SteffBean) memberBean).setAccessNum("123456");
		addList(memberBean);
	}

	@Override
	public void addList(MemberBean memberBean) {
		list[count++] = memberBean;
	}

	@Override
	public MemberBean[] list() {
		return list;
	}

	@Override
	public String showResult(MemberBean[] memberBean) {
		String result = "";
		int count = (this.count < memberBean.length) ? this.count : memberBean.length;
		for (int i = 0; i < count; i++) {
			result += memberBean[i];
		}
		return result;
	}

	@Override
	public MemberBean findById(MemberBean memberBean) {
		MemberBean searchResult = new MemberBean();
		for (int i = 0; i < count; i++) {
			if (memberBean.getUid().equals(list[i].getUid())
					&& memberBean.getPassword().equals(list[i].getPassword())) {
				searchResult = list[i];
				break;
			}
		}
		return searchResult;
	}

	@Override
	public int countSameWord(String word) {
		int countSame = 0;
		for (int i = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				countSame++;
			}
		}
		return countSame;
	}

	@Override
	public MemberBean[] findByWord(String word) {
		int samecount = countSameWord(word);
		MemberBean[] searchResult = new MemberBean[samecount];
		for (int i = 0, j = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				searchResult[j++] = list[i];
			}
		}
		return searchResult;
	}

	@Override
	public String readCount() {
		return String.valueOf(count);
	}

	@Override
	public String updateMember(MemberBean memberBean) {
		String msg = "ERROR_비밀번호불일치";
		String pass = memberBean.getPassword().split("/")[0];
		String newPass = memberBean.getPassword().split("/")[1];
		memberBean.setPassword(pass);
		memberBean = findById(memberBean);
		if (memberBean.getUid() == null) {
			msg = "ERROR_계정정보없음";
		} else if (!newPass.equals(pass)) {
			msg = "변경완료";
			memberBean.setPassword(newPass);
		}
		return msg;
	}

	@Override
	public String withDrawalMember(MemberBean memberBean) {
		String msg = "ERROR_비밀번호불일치";
		String pass = memberBean.getPassword().split("/")[0];
		String confirmPass = memberBean.getPassword().split("/")[1];
		memberBean.setPassword(pass);
		memberBean = findById(memberBean);
		if (memberBean.getUid() == null) {
			msg = "ERROR_계정정보없음";
			return msg;
		} else {
			if (pass.equals(confirmPass)) {
				for (int i = 0; i < count; i++) {
					if (memberBean.getUid().equals(list[i].getUid())
							&& memberBean.getPassword().equals(list[i].getPassword())) {
						list[i] = list[--count];
						msg = "계정삭제완료";
						break;
					}
				}
			}
		}
		return msg;
	}

}
