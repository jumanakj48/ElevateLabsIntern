package test;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
    private static EmployeeManagement emplManagement = new EmployeeManageImpl();
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Order Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addEmp();
                    break;
                case 2:
                    deleteEmp();
                    break;
                case 3:
                    viewAllEmp();
                    break;
                case 4:
                	updateEmp();
                	break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void updateEmp() {
	    try {
	    	System.out.print("Enter Employee Id to Update: ");
	    
	        int id = sc.nextInt();
	        sc.next();
	
	        System.out.print("Enter Updated Salary: ");
	        double sal = sc.nextDouble();
	        emplManagement.updateEmployee(id, sal);
	    }
	    catch(Exception e) {
	    	System.out.println("Failed to Update Employee");
	    }
		
	}

	private static void addEmp() {
        try {
        	System.out.print("Enter Employee Details \n");
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();
            		
            System.out.print("Department");
            String dept = sc.nextLine();
            
            System.out.print("Salary");
            Double sal = sc.nextDouble();

            Employee e = new Employee(0, name, age, gender, dept, sal);
            emplManagement.addEmployee(e);
            
        } catch (Exception e) {
            System.out.println("Failed to add order: " + e.getMessage());
        }
    }

    private static void deleteEmp() {
        try {
            System.out.print("Enter Employee ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());
            emplManagement.removeEmployee(id);
        } catch (Exception e) {
            System.out.println("Failed to delete order: " + e.getMessage());
        }
    }

    private static void viewAllEmp() {
        List<Employee> emps = emplManagement.getEmployees();
        if (emps.isEmpty()) {
            System.out.println("No Employees found.");
        } else {
            System.out.println("\n--- List of Employees ---");
            for (Employee e : emps) {
                System.out.println(e.toString());
            }
        }
    }
}
