package controller;

import javax.swing.JOptionPane;

enum Button {EXIT,SALARY,STEFF,OWNER};
public class EmployeeController {
	public static void main(String[] args) {
		Button[] button = {Button.EXIT, Button.SALARY, Button.STEFF, Button.OWNER};
		while(true) {
			switch((Button)JOptionPane.showInputDialog(null,"직급선택","BIT_COMPANY",JOptionPane.QUESTION_MESSAGE,null,button,null)) {
			case EXIT : return;
			case SALARY :
				
				break;
			case STEFF : break;
			case OWNER : break;
			}
		}
	}
}
