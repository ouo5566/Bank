package domain;

public class SteffSalaryBean extends SalaryBean{
	public static final String DEPT = "정직원";
	protected int bonus;
	public void setBonus(String bonus) {
		this.bonus = Integer.parseInt(bonus);
	}
	public int getBonus() {
		return bonus;
	}
}
