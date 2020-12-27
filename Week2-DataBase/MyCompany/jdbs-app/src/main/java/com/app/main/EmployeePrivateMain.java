package com.app.main;

import java.util.List;

import com.app.dao.EmployeePrivateCrudDAO;
import com.app.dao.impl.EmployeePrivateCrudDAOImpl;
import com.app.exception.CompanyException;
import com.app.model.EmployeePrivate;

public class EmployeePrivateMain {

	public static void main(String[] args) {
		EmployeePrivateCrudDAO dao = new EmployeePrivateCrudDAOImpl();
		EmployeePrivate employeePrivate = new EmployeePrivate(2001, "701-36-4776", "AT81 5133 9814 FMAI R5AE JGHG",
				"sanbar", "7aoTiMQSzz21");
		
		try {
			if(dao.createEmployeePrivate(employeePrivate) != 0) {
				System.out.println("Employee private information created succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.deleteEmployeePrivate(2001);
			System.out.println("Employee Private information deleted succesfully...");
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateSocialSecurityNumber(2000, "700-36-4776") != 0) {
				System.out.println("Employee social security number updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateAccountNumber(2000, "AD81 5133 9814 FMAI R5AE JGHG") != 0) {
				System.out.println("Employee account number updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateUserName(2000, "bneashamrr") != 0) {
				System.out.println("Employee user name updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updatePassword(2000, "7aoTiMQSzz") != 0) {
				System.out.println("Employee password updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			employeePrivate = dao.getEmployeePrivateById(2000);
			if (employeePrivate != null) {
				System.out.println("Details of employee private information: ");
				System.out.println(employeePrivate.toString());
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<EmployeePrivate> employeePrivateList=dao.getAllEmployeePrivate();
			if(employeePrivateList!=null && employeePrivateList.size()!=0) {
				System.out.println("\n\nFound "+employeePrivateList.size()+" no of employees in DB.... Printing private information all");
				for(EmployeePrivate emp:employeePrivateList) {
					System.out.println(emp);
				}
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}

	}

}
