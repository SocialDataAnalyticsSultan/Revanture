package com.app.main;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Date;
import java.util.List;

import com.app.dao.SalesCrudDAO;
import com.app.dao.impl.SalesCrudDAOImpl;
import com.app.exception.CompanyException;
import com.app.model.Sales;

public class SalesMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SalesCrudDAO dao = new SalesCrudDAOImpl();;
		Date date = new Date(2009, 5, 5);
		Sales sales = new Sales(4001, 1870, 113,date , new BigDecimal(6000.0));
		
		try {
			if(dao.createSales(sales) != 0) {
				System.out.println("Sales information created succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.deleteSales(4001);
			System.out.println("Sales information deleted succesfully...");
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateSalesEmployeeId(4000, 1870) != 0) {
				System.out.println("Sales employee id updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateSalesClientId(4000, 113) != 0) {
				System.out.println("Sales client id updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			date = new Date(2009, 5, 5);
			if(dao.updateDateOfSale(4000, new java.sql.Date(date.getTime())) != 0) {
				System.out.println("Sales date updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateSalesAmount(4000, new BigDecimal(8718.07)) != 0) {
				System.out.println("Sales amount updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			
			sales = dao.getSalesById(4000);
			
			if (sales != null) {
				System.out.println("Details of sale: ");
				System.out.println(sales.toString());
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Sales> salesList=dao.getAllSales();
			if(salesList!=null && salesList.size()!=0) {
				System.out.println("\n\nFound "+salesList.size()+" no of sales in DB.... Printing them all");
				for(Sales sal:salesList) {
					System.out.println(sal);
				}
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
