package controller;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum Butt {EXIT,BASIC_ACCOUNT,MINUS_ACCOUNT,LIST,MINUS_LIST,FIND_BY_ID,FIND_BY_NAME,CHANGE_PASSWORD,DELETE_ACCOUNT};
public class AccountController {
	public static void main(String[] args) {
		AccountBean account = null;
		AccountService service = new AccountServiceImpl();
		Butt[] button = {Butt.EXIT, Butt.BASIC_ACCOUNT, Butt.MINUS_ACCOUNT, Butt.LIST, Butt.MINUS_LIST, Butt.FIND_BY_ID, Butt.FIND_BY_NAME, Butt.CHANGE_PASSWORD, Butt.DELETE_ACCOUNT};
		while(true) {
			switch((Butt)JOptionPane.showInputDialog(null,"무엇을 도와드릴까요?","BIT_BANK",JOptionPane.QUESTION_MESSAGE,null,button,null)) {
			case EXIT : return;
			case BASIC_ACCOUNT :
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("이릅"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPassWord(JOptionPane.showInputDialog("비밀번호"));
				service.createBasic(account);
				break;
			case MINUS_ACCOUNT :
				account = new MinusAccountBean();
				account.setName(JOptionPane.showInputDialog("이릅"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPassWord(JOptionPane.showInputDialog("비밀번호"));
				((MinusAccountBean) account).setLimit(JOptionPane.showInputDialog("대출한도"));
				service.createMinus(account);
				break;
			case LIST :
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case MINUS_LIST :
				JOptionPane.showMessageDialog(null,service.minusList());
				break;
			case FIND_BY_ID :
				account = new AccountBean();
				account.setUid((JOptionPane.showInputDialog("아이디")));
				account.setPassWord(JOptionPane.showInputDialog("패스워드"));
				JOptionPane.showMessageDialog(null,service.search(account));
				break;
			case FIND_BY_NAME :
				JOptionPane.showMessageDialog(null,service.searchWord(JOptionPane.showInputDialog("이름")));
				break;
			case CHANGE_PASSWORD :
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPassWord(JOptionPane.showInputDialog("비밀번호") + "/" + JOptionPane.showInputDialog("새비밀번호"));
				service.updateAccount(account);
				break;
			case DELETE_ACCOUNT :
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPassWord(JOptionPane.showInputDialog("비밀번호") + "/" + JOptionPane.showInputDialog("비밀번호확인"));
				service.deleteAccount(account);
				break;
			}
		}
	}
}
