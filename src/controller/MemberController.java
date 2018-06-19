package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum MemberButt {
	//JOIN은 일반유저추가, ADD는 직원추가
	EXIT,
	JOIN, ADD, // void, 서비스에서 생성 : create
	LIST, FIND_BY_ID, FIND_BY_NAME, COUNT, // return값 필요, 정보를 읽음 : read
	//LIST, COUNT(int) : 모든정보(all) FIND_BY_ID : 하나의정보(one) FIND_BY_SOME : 여러 개의 정보(some)
	UPDATE, // void, 정보를 수정 : update
	WITHDRAWAL //void, 정보를 삭제 : delete
}; // 이 4가지의 메소드의 앞 글자를 따서 C.R.U.D. 라고 부른다.

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		while (true) {
			switch ((MemberButt) JOptionPane
					.showInputDialog(null, "무엇을 도와드릴까요?", "BIT_BANK", JOptionPane.QUESTION_MESSAGE, null,
							new MemberButt[] { MemberButt.EXIT, MemberButt.JOIN, MemberButt.ADD,
									MemberButt.LIST, MemberButt.FIND_BY_ID, MemberButt.FIND_BY_NAME, MemberButt.COUNT, MemberButt.UPDATE, MemberButt.WITHDRAWAL}, null)) {
			case EXIT:
				return;
			case JOIN :
				member = new UserBean();
				member.setName(JOptionPane.showInputDialog("이름"));
				member.setSsn(JOptionPane.showInputDialog("주민번호"));
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPassword(JOptionPane.showInputDialog("비밀번호"));
				member.setAddress(JOptionPane.showInputDialog("주소"));
				member.setPhone(JOptionPane.showInputDialog("핸드폰번호"));
				member.setEmail(JOptionPane.showInputDialog("이메일"));
				service.creatUser(member);
				break;
			case ADD :
				member = new SteffBean();
				member.setName(JOptionPane.showInputDialog("이름"));
				member.setSsn(JOptionPane.showInputDialog("주민번호"));
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPassword(JOptionPane.showInputDialog("비밀번호"));
				member.setAddress(JOptionPane.showInputDialog("주소"));
				member.setPhone(JOptionPane.showInputDialog("핸드폰번호"));
				member.setEmail(JOptionPane.showInputDialog("이메일"));
				service.creatSteff(member);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.showResult(service.list()));
				break;
			case FIND_BY_ID:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPassword(JOptionPane.showInputDialog("비밀번호"));
				JOptionPane.showMessageDialog(null,service.findById(member));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null,service.showResult(service.findByWord(JOptionPane.showInputDialog("이름"))));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null,service.readCount());
				break;
			case UPDATE :
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPassword(JOptionPane.showInputDialog("비밀번호")
						+ "/" + JOptionPane.showInputDialog("새비밀번호"));
				JOptionPane.showMessageDialog(null,service.updateMember(member));
				break;
			case WITHDRAWAL :
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPassword(JOptionPane.showInputDialog("비밀번호")
						+ "/" + JOptionPane.showInputDialog("비밀번호확인"));
				JOptionPane.showMessageDialog(null,service.withDrawalMember(member));
				break;
			}
		}
	}
}
