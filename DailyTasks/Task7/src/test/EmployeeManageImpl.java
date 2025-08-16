package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeManageImpl implements EmployeeManagement{

	@Override
	public void addEmployee(Employee e) {
		String query = "INSERT INTO employee(EmpName, age, gender, department, salary) values(?,?,?,?,?)";
		
		try(Connection conn = DBConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setString(1, e.getName());
			stmt.setInt(2, e.getAge());
			stmt.setString(3, e.getGender());
			stmt.setString(4, e.getDepartment());
			stmt.setDouble(5, e.getSalary());
			
			int rowsInserted = stmt.executeUpdate();
            if(rowsInserted > 0)  System.out.println("Employee added successfully!");
            else System.out.println("Failed to add Employee Data.");
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}

	@Override
	public void removeEmployee(int id) {
		String query = "DELETE FROM employee where empId = ?";
		
		try(Connection conn = DBConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setInt(1, id);
			
			int rowsDeleted = stmt.executeUpdate();
            if(rowsDeleted > 0)  System.out.println("Employee deleted successfully!");
            else System.out.println("Failed to delete Employee Data.");
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		
	}

	@Override
	public void updateEmployee(int id, double sal) {
		String query = "UPDATE employee set salary = ? where id = ?";
		try(Connection conn = DBConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)){
			stmt.setDouble(1, sal);
			stmt.setInt(2, id);
			
			int rowsUpdated = stmt.executeUpdate();
            if(rowsUpdated > 0)  System.out.println("Employee updated successfully!");
            else System.out.println("Failed to update Employee Data.");
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> lists = new ArrayList<>();
		String query = "Select * from employee";
		try(Connection conn = DBConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery()){
						
			
			while(rs.next()) {
				Employee e = new Employee(
					rs.getInt(0),
					rs.getString(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDouble(5)
				);
				lists.add(e);
			}
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		
		return lists;
	}

}
