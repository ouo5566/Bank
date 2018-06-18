package domain;

public class SalaryBean {
	public static final String DEPT = "인턴십";
	protected String dept, name;
	protected int sal;
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSal(String sal) {
		this.sal = Integer.parseInt(sal);
	}
	public String getDept() {
		return dept;
	}
	public String getName() {
		return name;
	}
	public int getSal() {
		return sal;
	}
	public String toString() {
		return String.format("| %s | %s | %d |\n", dept, name, sal);
	}
}
