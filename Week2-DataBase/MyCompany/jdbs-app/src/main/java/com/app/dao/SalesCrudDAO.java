package com.app.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.app.exception.CompanyException;
import com.app.model.Sales;

public interface SalesCrudDAO {
	
	public int createSales(Sales sales) throws CompanyException;
	public void deleteSales(int id) throws CompanyException;
	
	public int updateSalesEmployeeId(int id, int newEmployeeId) throws CompanyException;
	public int updateSalesClientId(int id, int clientId) throws CompanyException;
	public int updateDateOfSale(int id, Date newDateOfSale) throws CompanyException;
	public int updateSalesAmount(int id, BigDecimal newAmount) throws CompanyException;
	
	public Sales getSalesById(int id) throws CompanyException;
	public List<Sales> getAllSales() throws CompanyException;

}