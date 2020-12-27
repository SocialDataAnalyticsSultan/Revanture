package com.app.main;


import java.util.List;
import java.util.Date;

import com.app.dao.EmployeeCrudDAO;
import com.app.dao.impl.EmployeeCrudDAOImpl;
import com.app.exception.CompanyException;
import com.app.model.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		
		EmployeeCrudDAO dao = new EmployeeCrudDAOImpl();
		
		@SuppressWarnings("deprecation")
		Employee employee = new Employee("Sultan", "Anbar", "Female", "111-222-3333", "sanbar@com", 2001, new Date(1982,1,1), 
				"Washington", "Norwood", "Massachusetts", "United States", 101);
		
		try {
			if(dao.createEmployee(employee) != 0) {
				System.out.println("Employee created succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.deleteEmployee(2001);
			System.out.println("Employee deleted succesfully...");
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateEmployeePhoneNumber(2000, "202-000-1287") != 0) {
				System.out.println("Employee phone number updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateEmployeeEmail(2000, "shamrr@microsoft.com") != 0) {
				System.out.println("Employee email updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateEmployeeStreet(2000, "6000 Northview Junction") != 0) {
				System.out.println("Employee street updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateEmployeeCity(2000, "Westwood") != 0) {
				System.out.println("Employee city updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateEmployeeState(2000, "Florida") != 0) {
				System.out.println("Employee state updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateEmployeeCountry(2000, "United States") != 0) {
				System.out.println("Employee country updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			employee = dao.getEmployeeById(2000);
			if (employee != null) {
				System.out.println("Details of employee: ");
				System.out.println(employee.toString());
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Employee> employeeList=dao.getAllEmployee();
			if(employeeList!=null && employeeList.size()!=0) {
				System.out.println("\n\nFound "+employeeList.size()+" no of employees in DB.... Printing them all");
				for(Employee emp:employeeList) {
					System.out.println(emp);
				}
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
