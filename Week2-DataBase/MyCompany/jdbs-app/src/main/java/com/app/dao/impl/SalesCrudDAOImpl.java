package com.app.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.SalesCrudDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.CompanyException;
import com.app.model.Sales;

public class SalesCrudDAOImpl implements SalesCrudDAO{

	
	@Override
	public int createSales(Sales sales) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			String sql = "INSERT INTO my_company.sales_info "
					+ "(sales_id, employee_id, client_id, date, sales_amount) "
					+ "VALUES(?,?,?,?,?); ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,sales.getSalesId());
			preparedStatement.setInt(2,sales.getEmployeeId());
			preparedStatement.setInt(3,sales.getClientId());
			preparedStatement.setDate(4, new java.sql.Date(sales.getDateOfSale().getTime()));
			preparedStatement.setBigDecimal(5,sales.getAmount());
			
			result = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return result;
	}

	
	@Override
	public void deleteSales(int id) throws CompanyException {
		String sql = "DELETE FROM my_company.sales_info WHERE sales_id = ?;";
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		
	}

	
	@Override
	public int updateSalesEmployeeId(int id, int newEmployeeId) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.sales_info "
					+ "SET employee_id = ? "
					+ "WHERE sales_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newEmployeeId);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateSalesClientId(int id, int clientId) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.sales_info "
					+ "SET client_id = ? "
					+ "WHERE sales_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, clientId);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateDateOfSale(int id, Date newDateOfSale) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.sales_info "
					+ "SET date = ? "
					+ "WHERE sales_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, newDateOfSale);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateSalesAmount(int id, BigDecimal newAmount) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.sales_info "
					+ "SET sales_amount = ? "
					+ "WHERE sales_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBigDecimal(1, newAmount);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public Sales getSalesById(int id) throws CompanyException {
		Sales sales = null;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			String sql = "SELECT sales_id, employee_id, client_id, date, sales_amount "
					+ "FROM my_company.sales_info "
					+  "WHERE sales_id = ?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				sales = new Sales();
				sales.setSalesId(id);
				sales.setEmployeeId(resultSet.getInt("employee_id"));
				sales.setClientId(resultSet.getInt("client_id"));
				sales.setDateOfSale(resultSet.getDate("date"));
				
				sales.setAmount(resultSet.getBigDecimal("sales_amount"));
			}else {
				throw new CompanyException("No sale is found with ID: " + id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return sales;
	}


	@Override
	public List<Sales> getAllSales() throws CompanyException {
		List<Sales> salesList = new ArrayList<Sales>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT sales_id, employee_id, client_id, date, sales_amount "
					+ "FROM my_company.sales_info ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Sales temp = new Sales();
				temp.setSalesId(resultSet.getInt("sales_id"));
				temp.setEmployeeId(resultSet.getInt("employee_id"));
				temp.setClientId(resultSet.getInt("client_id"));
				temp.setDateOfSale(resultSet.getDate("date"));
				temp.setAmount(resultSet.getBigDecimal("sales_amount"));
				salesList.add(temp);
			}
			
			if(salesList.size()==0) {
				throw new CompanyException("No Sale in the DB so far");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return salesList;
	}
	
}