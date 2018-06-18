package controller;
import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum Butt {EXIT,BASIC_ACCOUNT,MINUS_ACCOUNT,LIST,MINUS_LIST,FIND_BY_ID,FIND_BY_NAME};
public class AccountController {
	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		AccountBean account = null;
		Butt[] button = {Butt.EXIT, Butt.BASIC_ACCOUNT, Butt.MINUS_ACCOUNT, Butt.LIST, Butt.MINUS_LIST, Butt.FIND_BY_ID, Butt.FIND_BY_NAME};
		while(true) {
			switch((Butt)JOptionPane.showInputDialog(null,"무엇을 도와드릴까요?","BIT_BANK",JOptionPane.QUESTION_MESSAGE,null,button,null)) {
			case EXIT : return;
			case BASIC_ACCOUNT :
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPassWord(JOptionPane.showInputDialog("비밀번호"));
				service.createAccount(account);
				break;
			case MINUS_ACCOUNT :
				account = new MinusAccountBean();
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPassWord(JOptionPane.showInputDialog("비밀번호"));
				service.createMinusAccount(account,JOptionPane.showInputDialog("대출한도"));
				break;
			case LIST :
				JOptionPane.showMessageDialog(null,service.showResult(service.list()));
				break;
			case MINUS_LIST :
				JOptionPane.showMessageDialog(null,service.showResult(service.findMinusList()));
				break;
			case FIND_BY_ID :
				// ID 와 PASS 를 받아서 일치하면 계좌내역을 보여줘. 단, 혹시 모르니까 비번은 **** 처리해.
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPassWord(JOptionPane.showInputDialog("비밀번호"));
				JOptionPane.showMessageDialog(null,service.findById(account));
				break;
			case FIND_BY_NAME :
				JOptionPane.showMessageDialog(null,service.showResult(service.findByName(JOptionPane.showInputDialog("이름"))));
				break;
			}
		}
	}
}
