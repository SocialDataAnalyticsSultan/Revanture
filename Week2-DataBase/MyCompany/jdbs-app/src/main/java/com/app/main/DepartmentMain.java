package com.app.main;

import java.util.List;

import com.app.dao.DepartmentCrudDAO;
import com.app.dao.impl.DepartmentCrudDAOImpl;
import com.app.exception.CompanyException;
import com.app.model.Department;

public class DepartmentMain {

	public static void main(String[] args) {
		DepartmentCrudDAO dao = new DepartmentCrudDAOImpl();
		Department department = new Department(121, "Support","Westwood", "New York","United States", 1809);
		
		try {
			if(dao.createDepartment(department) != 0) {
				System.out.println("Department information created succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.deleteDepartment(121);
			System.out.println("Department deleted succesfully...");
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateDepartmentName(120, "Support") != 0) {
				System.out.println("Department name updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateDepartmentCity(120, "Aurora") != 0) {
				System.out.println("Department city updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateDepartmentState(120, "Colorado") != 0) {
				System.out.println("Department state updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateDepartmentCountry(120, "United States") != 0) {
				System.out.println("Department country updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateManagerId(120, 1881) != 0) {
				System.out.println("Department manager updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Department> departmentList=dao.getAllDepartment();
			if(departmentList!=null && departmentList.size()!=0) {
				System.out.println("\n\nFound "+departmentList.size()+" no of department in DB.... Printing them all");
				for(Department dep:departmentList) {
					System.out.println(dep);
				}
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}

	}

}
