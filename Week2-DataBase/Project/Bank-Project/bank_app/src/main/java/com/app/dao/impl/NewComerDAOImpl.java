package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.log4j.Logger;

import com.app.dao.NewComerDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;

public class NewComerDAOImpl implements NewComerDAO {

	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);
	
	@Override
	public int NewComerApplication() throws ClassNotFoundException, SQLException {
		
		int customerId = 0;
		try (Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT MAX(customer_id) AS max_id "
					+ "FROM asya_bank.customer;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				customerId = resultSet.getInt("max_id");
			}
		}
		customerId++;
		return customerId;
	}

	@Override
	public void NewComerAccountAndRegistration(Customer newCustomer, CustomerAccount newCustomerAccount) throws ClassNotFoundException, SQLException {
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			
			connection.setAutoCommit(false);
			/*
			String sql = "WITH data (customer_id, first_name, last_name, date_of_birth, gender, marital_status, "
					+ "social_security_number, nationality, phone_number, email, street, city, state, "
					+ "country, zipcode, occupation, yearly_income, credit_score ,username, \"password\", "
					+ "account_type, account_number, open_date, balance, branch_id, approving_employee_id ) AS ("
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?) )  "
					+ ""
					+ ", ins1 AS ("
					+ "INSERT INTO asya_bank.customer "
					+ "(customer_id, first_name, last_name, date_of_birth, gender, marital_status,"
					+ "social_security_number, nationality, phone_number, email, street, city, state, "
					+ "country, zipcode, occupation, yearly_income, credit_score ,username, \"password\") "
					+ "SELECT customer_id, first_name, last_name, date_of_birth, gender, marital_status,"
					+ "social_security_number, nationality, phone_number, email, street, city, state "
					+ "country, zipcode, occupation, yearly_income, credit_score ,username, \"password\" "
					+ "FROM data "
					+ "RETURNING customer_id) "
					+ ""
					+ "INSERT INTO asya_bank.customer_account "
					+ "(customer_id, account_type, account_number, open_date, balance, branch_id, approving_employee_id )"
					+ "SELECT ins.customer_id, account_type, account_number, open_date, balance, branch_id, approving_employee_id "
					+ "FROM data d"
					+ "JOIN ins1 "
					+ "USING (customer_id); ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newCustomer.getCustomerId());
			preparedStatement.setString(2, newCustomer.getFirstName());
			preparedStatement.setString(3, newCustomer.getLastName());
			preparedStatement.setDate(4, new java.sql.Date(newCustomer.getDateOfBirth().getTime()));
			preparedStatement.setString(5, newCustomer.getGender());
			preparedStatement.setString(6, newCustomer.getMaritalStatus());
			preparedStatement.setString(7, newCustomer.getSocialSecurityNumber());
			preparedStatement.setString(8, newCustomer.getNationality());
			preparedStatement.setString(9, newCustomer.getPhoneNumber());
			preparedStatement.setString(10, newCustomer.getEmail());
			preparedStatement.setString(11, newCustomer.getAddress().getStreet());
			preparedStatement.setString(12, newCustomer.getAddress().getCity());
			preparedStatement.setString(13, newCustomer.getAddress().getState());
			preparedStatement.setString(14, newCustomer.getAddress().getCountry());
			preparedStatement.setString(15, newCustomer.getAddress().getZipcode());
			preparedStatement.setString(16, newCustomer.getOccupation());
			preparedStatement.setBigDecimal(17, newCustomer.getYearlyIncome());
			preparedStatement.setInt(18, newCustomer.getCreditScore());
			preparedStatement.setString(19, newCustomer.getUserName());
			preparedStatement.setString(20, newCustomer.getPassword());
			preparedStatement.setString(21, newCustomerAccount.getAccountType());
			preparedStatement.setString(22, newCustomerAccount.getAccountNumber());
			preparedStatement.setBigDecimal(23, newCustomerAccount.getBalance());
			preparedStatement.setInt(24, newCustomerAccount.getBranchId());
			preparedStatement.setInt(25, newCustomerAccount.getApprovingEmployeeId());
			preparedStatement.executeUpdate();
			*/
			
			LocalDate localDate = LocalDate.now();
			String now = localDate.toString();
			
			String sql = "WITH customer_key AS "
					+ "(INSERT INTO asya_bank.customer "
					+ "			(customer_id, first_name, last_name, date_of_birth, gender, marital_status, "
					+ "			social_security_number, nationality, phone_number, email, street, city, state, "
					+ "			country, zipcode, occupation, yearly_income, credit_score ,username, \"password\" ) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?) "
					+ "RETURNING customer_id) "
					+ "INSERT INTO asya_bank.customer_account "
					+ "		(customer_id, account_type,account_number, open_date, balance, branch_id, approving_employee_id) "
					+ "		SELECT customer_key.customer_id, ?, ?, "
					+ "\'" + now + "\', "
					+ "numeric \'" + String.valueOf(newCustomerAccount.getBalance()) + "\', "
					+ "numeric \'" + String.valueOf(newCustomerAccount.getBranchId()) + "\', "
					+ "numeric  \'" + String.valueOf(newCustomerAccount.getApprovingEmployeeId()) + "\'"
					+ "		FROM customer_key;";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newCustomer.getCustomerId());
			preparedStatement.setString(2, newCustomer.getFirstName());
			preparedStatement.setString(3, newCustomer.getLastName());
			preparedStatement.setDate(4, new java.sql.Date(newCustomer.getDateOfBirth().getTime()));
			preparedStatement.setString(5, newCustomer.getGender());
			preparedStatement.setString(6, newCustomer.getMaritalStatus());
			preparedStatement.setString(7, newCustomer.getSocialSecurityNumber());
			preparedStatement.setString(8, newCustomer.getNationality());
			preparedStatement.setString(9, newCustomer.getPhoneNumber());
			preparedStatement.setString(10, newCustomer.getEmail());
			preparedStatement.setString(11, newCustomer.getAddress().getStreet());
			preparedStatement.setString(12, newCustomer.getAddress().getCity());
			preparedStatement.setString(13, newCustomer.getAddress().getState());
			preparedStatement.setString(14, newCustomer.getAddress().getCountry());
			preparedStatement.setString(15, newCustomer.getAddress().getZipcode());
			preparedStatement.setString(16, newCustomer.getOccupation());
			preparedStatement.setBigDecimal(17, newCustomer.getYearlyIncome());
			preparedStatement.setInt(18, newCustomer.getCreditScore());
			preparedStatement.setString(19, newCustomer.getUserName());
			preparedStatement.setString(20, newCustomer.getPassword());
			
			preparedStatement.setString(21, newCustomerAccount.getAccountType());
			preparedStatement.setString(22, newCustomerAccount.getAccountNumber());
			
			preparedStatement.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			}
		}
		
}