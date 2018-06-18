package service;
import domain.SalaryBean;

public interface EmployeeService {
	public SalaryBean createSalary(String dept, String name, String sal);
	public int calculateBonus();
	public int calculateShare();
	public String createName(String dept, String name);
}
