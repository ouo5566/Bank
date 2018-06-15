package controller;
import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;

enum Butt {EXIT,BASIC_ACCOUNT,MINUS_ACCOUNT,LIST};
public class AccountController {
	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		Butt[] button = {Butt.EXIT, Butt.BASIC_ACCOUNT, Butt.MINUS_ACCOUNT, Butt.LIST};
		while(true) {
			switch((Butt)JOptionPane.showInputDialog(null,"무엇을 도와드릴까요?","BIT_BANK",JOptionPane.QUESTION_MESSAGE,null,button,null)) {
			case EXIT : return;
			case BASIC_ACCOUNT :
				service.createAccount(JOptionPane.showInputDialog("이름"), JOptionPane.showInputDialog("아이디"), JOptionPane.showInputDialog("비밀번호"));
				break;
			case MINUS_ACCOUNT :
				service.createMinusAccount(JOptionPane.showInputDialog("이름"), JOptionPane.showInputDialog("아이디"), JOptionPane.showInputDialog("비밀번호"));
				break;
			case LIST :
				JOptionPane.showMessageDialog(null,service.showResult());
				break;
			}
		}
	}
}
