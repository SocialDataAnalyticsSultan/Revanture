package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.EmployeePrivateCrudDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.CompanyException;
import com.app.model.EmployeePrivate;

public class EmployeePrivateCrudDAOImpl implements EmployeePrivateCrudDAO{

	
	@Override
	public int createEmployeePrivate(EmployeePrivate employeePrivate) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			String sql = "INSERT INTO my_company.employee_private_info\r\n"
					+ "(employee_id, ssn, account_number, username, password)"
					+ "VALUES(?,?,?,?,?); ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,employeePrivate.getEmployeeId());
			preparedStatement.setString(2,employeePrivate.getSocialSecurityNumber());
			preparedStatement.setString(3,employeePrivate.getAccountNumber());
			preparedStatement.setString(4,employeePrivate.getUserName());
			preparedStatement.setString(5,employeePrivate.getPassword());
			
			result = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return result;
	}

	
	@Override
	public void deleteEmployeePrivate(int id) throws CompanyException {
		String sql = "DELETE FROM my_company.employee_private_info WHERE employee_id = ?;";
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
	public int updateSocialSecurityNumber(int id, String newSocialSecurityNumber) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_private_info "
					+ "SET ssn = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newSocialSecurityNumber);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateAccountNumber(int id, String newAccountNumber) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_private_info "
					+ "SET account_number = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newAccountNumber);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateUserName(int id, String newUserName) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_private_info "
					+ "SET username = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newUserName);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updatePassword(int id, String newPassword) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_private_info "
					+ "SET password = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public EmployeePrivate getEmployeePrivateById(int id) throws CompanyException {
		EmployeePrivate employeePrivate = null;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "SELECT employee_id, ssn, account_number, username, password \r\n"
					+ "FROM my_company.employee_private_info\r\n"
					+  "WHERE employee_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				employeePrivate = new EmployeePrivate();
				employeePrivate.setEmployeeId(id);
				employeePrivate.setSocialSecurityNumber(resultSet.getString("ssn"));
				employeePrivate.setAccountNumber(resultSet.getString("account_number"));
				employeePrivate.setUserName(resultSet.getString("username"));
				employeePrivate.setPassword(resultSet.getString("password"));
			}else {
				throw new CompanyException("No Employee is found with ID: " + id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return employeePrivate;
	}

	
	@Override
	public List<EmployeePrivate> getAllEmployeePrivate() throws CompanyException {
		List<EmployeePrivate> employeePrivateList = new ArrayList<EmployeePrivate>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT employee_id, ssn, account_number, username, password \r\n"
					+ "FROM my_company.employee_private_info";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				EmployeePrivate temp = new EmployeePrivate();
				temp.setEmployeeId(resultSet.getInt("employee_id"));
				temp.setSocialSecurityNumber(resultSet.getString("ssn"));
				temp.setAccountNumber(resultSet.getString("account_number"));
				temp.setUserName(resultSet.getString("username"));
				temp.setPassword(resultSet.getString("password"));
				employeePrivateList.add(temp);
			}
			
			if(employeePrivateList.size()==0) {
				throw new CompanyException("No Employee in the DB so far");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return employeePrivateList;
	}

}
