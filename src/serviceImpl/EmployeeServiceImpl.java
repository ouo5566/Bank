package serviceImpl;

import domain.SalaryBean;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	SalaryBean[] list;
	int count;

	public EmployeeServiceImpl() {
		list = new SalaryBean[10];
		count = 0;
	}

	@Override
	public SalaryBean createSalary(String dept, String name, String sal) {
		SalaryBean salary = new SalaryBean();
		salary.setDept(dept);
		salary.setName(createName(dept, name));
		salary.setSal(sal);
		return salary;
	}

	public void addList(SalaryBean salaryBean) {
		list[count++] = salaryBean;
	}

	public SalaryBean[] list() {
		return list;
	}

	@Override
	public int calculateBonus() {
		return 0;
	}

	@Override
	public int calculateShare() {
		return 0;
	}

	@Override
	public String createName(String dept, String name) {
		return (dept.equals("이사회")) ? name.substring(0, 1) + "이사"
				: (dept.equals("정직원")) ? name.substring(0, 1) + "직원" : name.substring(0, 1) + "인턴";
	}
	
	public String showResult() {
		String result = "";
		for(int i = 0 ; i < count ; i++) {
			result += list()[i] + "\n";
		}
		return result;
	}
}
