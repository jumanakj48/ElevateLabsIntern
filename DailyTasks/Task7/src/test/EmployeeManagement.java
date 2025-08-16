package test;

import java.util.List;

public interface EmployeeManagement {
	
	void addEmployee(Employee e);
	void removeEmployee(int id);
	void updateEmployee(int id, double sal);
	List<Employee> getEmployees();
}
