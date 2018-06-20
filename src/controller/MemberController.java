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
		MemberBean member = null;
		while (true) {
			switch ((MemberButt) JOptionPane
					.showInputDialog(null, "무엇을 도와드릴까요?", "BIT_BANK", JOptionPane.QUESTION_MESSAGE, null,
							new MemberButt[] { MemberButt.EXIT, MemberButt.JOIN, MemberButt.ADD,
									MemberButt.LIST, MemberButt.FIND_BY_ID, MemberButt.FIND_BY_NAME, MemberButt.COUNT, MemberButt.UPDATE, MemberButt.WITHDRAWAL}, null)) {
			case EXIT:
				return;
			case JOIN :
				break;
			case ADD :
				break;
			case LIST:
				break;
			case FIND_BY_ID:
				break;
			case FIND_BY_NAME:
				break;
			case COUNT:
				break;
			case UPDATE :
				break;
			case WITHDRAWAL :
				break;
			}
		}
	}
}
