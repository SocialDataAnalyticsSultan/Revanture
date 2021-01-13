package com.app.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.app.model.Address;
import com.app.model.bank.Loan;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerLoan;
import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.BankException;
import com.app.main.BankMain;
import com.app.model.customer.CustomerTransaction;

import jdk.internal.org.jline.utils.Log;

public class CustomerDAOImpl implements CustomerDAO{

	private static Logger log=Logger.getLogger(CustomerDAOImpl.class);
	
	@Override
	public int customerLogIn(String userName, String password) throws ClassNotFoundException, SQLException, BankException {
		int customerId = 0;
		String customerFirstName = null;
		String customerLastName = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, first_name, last_name "
					+ "FROM asya_bank.customer "
					+ "WHERE username = ? AND password = ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				customerId = resultSet.getInt("customer_id");
				customerFirstName = resultSet.getString("first_name");
				customerLastName = resultSet.getString("last_name");
				System.out.println("\nWellcome " + customerFirstName.toUpperCase() + " " + customerLastName.toUpperCase());
			}else {
				throw new BankException("Wrong Login Credentials");
			}
		}
		
		return customerId;
	}

	@Override
	public Customer getCustomerInformation(int customerId) throws ClassNotFoundException, SQLException {
		Customer customer = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, first_name, last_name, date_of_birth, gender, marital_status, "
					+ "social_security_number, nationality, phone_number, email, street, city, state, country, "
					+ "zipcode, occupation, yearly_income, credit_score, username, \"password\" "
					+ "FROM asya_bank.customer "
					+ "WHERE customer_id = ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getInt("customer_id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customer.setGender(resultSet.getString("gender"));
				customer.setMaritalStatus(resultSet.getString("marital_status"));
				customer.setSocialSecurityNumber(resultSet.getString("social_security_number"));
				customer.setNationality(resultSet.getString("nationality"));
				customer.setPhoneNumber(resultSet.getString("phone_number"));
				customer.setEmail(resultSet.getString("email"));
				customer.setAddress(new Address(resultSet.getString("street"), resultSet.getString("city"), 
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("zipcode")));
				customer.setOccupation(resultSet.getString("occupation"));
				customer.setYearlyIncome(resultSet.getBigDecimal("yearly_income"));
				customer.setCreditScore(resultSet.getInt("credit_score"));
				customer.setUserName(resultSet.getString("username"));
				customer.setPassword(resultSet.getString("password"));
			}
		}
		return customer;
	}

	@Override
	public CustomerAccount getCustomerAccount(int customerId) throws ClassNotFoundException, SQLException {
		CustomerAccount customerAccount = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT customer_id, account_type, account_number, "
					+ "open_date, balance, branch_id, approving_employee_id "
					+ "FROM asya_bank.customer_account "
					+ "WHERE customer_id = ?; ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				customerAccount = new CustomerAccount();
				customerAccount.setCustomerId(resultSet.getInt("customer_id"));
				customerAccount.setAccountType(resultSet.getString("account_type"));
				customerAccount.setAccountNumber(resultSet.getString("account_number"));
				customerAccount.setOpenDate(resultSet.getDate("open_date"));
				customerAccount.setBalance(resultSet.getBigDecimal("balance"));
				customerAccount.setBranchId(resultSet.getInt("branch_id"));
				customerAccount.setApprovingEmployeeId(resultSet.getInt("approving_employee_id"));
			}
		}
		return customerAccount;
	}

	@Override
	public List<CustomerTransaction> getCustomerTransaction(int customerId) throws ClassNotFoundException, SQLException {
		List<CustomerTransaction> customerTransactionList = new ArrayList<>();
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "SELECT transaction_id, customer_id, transaction_time, transaction_type, "
					+ "transaction_amount, balance "
					+ "FROM asya_bank.customer_transaction "
					+ "WHERE customer_id = ?; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				CustomerTransaction customerTransactionTemp = new CustomerTransaction();
				customerTransactionTemp.setTransactionId(resultSet.getString("transaction_id"));
				customerTransactionTemp.setCustomerId(resultSet.getInt("customer_id"));
				customerTransactionTemp.setTransactionTime(resultSet.getTimestamp("transaction_time"));
				customerTransactionTemp.setTransactionType(resultSet.getString("transaction_type"));
				customerTransactionTemp.setTransactionAmount(resultSet.getBigDecimal("transaction_amount"));
				customerTransactionTemp.setBalance(resultSet.getBigDecimal("balance"));
				customerTransactionList.add(customerTransactionTemp);
			}
		}
		return customerTransactionList;
	}

	@Override
	public boolean updateCustomerAddress(int customerId, Address address) throws ClassNotFoundException, SQLException {
		int count = 0;
		boolean isAddressUpdate = false;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "UPDATE asya_bank.customer "
					+ "SET street = ? , city =  ? , state = ? , country = ? , zipcode = ?  "
					+ "WHERE customer_id = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getState());
			preparedStatement.setString(4, address.getCountry());
			preparedStatement.setString(5, address.getZipcode());
			preparedStatement.setInt(6, customerId);
			count = preparedStatement.executeUpdate();
		}
		if(count>0) {
			isAddressUpdate = true;
		}
		return isAddressUpdate;
	}

	@Override
	public boolean updateCustomerPhoneNumber(int customerId, String phoneNumber) throws ClassNotFoundException, SQLException {
		int count = 0;
		boolean isPhoneNumberUpdate = false;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "UPDATE asya_bank.customer "
					+ "SET phone_number = ? "
					+ "WHERE customer_id = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phoneNumber);
			preparedStatement.setInt(2, customerId);
			count = preparedStatement.executeUpdate();
		}
		if(count>0) {
			isPhoneNumberUpdate = true;
		}
		return isPhoneNumberUpdate;
	}

	@Override
	public boolean updateCustomerEmail(int customerId, String email) throws ClassNotFoundException, SQLException {
		int count = 0;
		boolean isEmailUpdate = false;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "UPDATE asya_bank.customer "
					+ "SET email = ? "
					+ "WHERE customer_id = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, customerId);
			count = preparedStatement.executeUpdate();
		}
		if(count>0) {
			isEmailUpdate = true;
		}
		return isEmailUpdate;
	}

	@Override
	public boolean updateCustomerPassword(int customerId, String password) throws ClassNotFoundException, SQLException {
		int count = 0;
		boolean isPasswordUpdate = false;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			String sql = "UPDATE asya_bank.customer "
					+ "SET password = ? "
					+ "WHERE customer_id = ? ; ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, customerId);
			count = preparedStatement.executeUpdate();
		}
		if(count>0) {
			isPasswordUpdate = true;
		}
		return isPasswordUpdate;
	}

	@Override
	public boolean makeCustomerDeposit(int customerId, BigDecimal deposit) throws ClassNotFoundException, SQLException, BankException {
		int count1 = 0;
		boolean isDeposit = false;
		BigDecimal oldBalance = new BigDecimal(0.0);
		BigDecimal newBalance = new BigDecimal(0.0);
		CustomerTransaction customerTransaction = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(false);
			
			try {
				String sql1 = "SELECT balance "
						+ "FROM asya_bank.customer_account "
						+ "WHERE customer_id = ? ; ";
				
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
				preparedStatement1.setInt(1, customerId);
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				
				if(resultSet1.next()) {
					oldBalance = resultSet1.getBigDecimal("balance");
					newBalance = oldBalance.add(deposit);
					
					String sql2 = "UPDATE asya_bank.customer_account "
							+ "SET balance = ? "
							+ "WHERE customer_id = ? ; ";
					
					PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
					preparedStatement2.setBigDecimal(1, newBalance);
					preparedStatement2.setInt(2, customerId);
					count1 = preparedStatement2.executeUpdate();
					
					if(count1>0) {
						int minNumber = 1000;
						int maxNumber = 9999;
						Random r = new Random();
						
						String random1 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
						String random3 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
						String random2 = String.valueOf((char) (r.nextInt(26) + 'a'))+ String.valueOf((char) (r.nextInt(26) + 'a')) 
						+ String.valueOf((char) (r.nextInt(26) + 'a')) + String.valueOf((char) (r.nextInt(26) + 'a'));
						
						String transactionId = random1 + "-" + random2.toUpperCase() + "-" + random3;
						Date dateNow = new Date();
						String transactionType = "Deposit";
						
						customerTransaction = new CustomerTransaction(transactionId, customerId, 
								new Timestamp(dateNow.getTime()), transactionType, deposit, newBalance);
						
						String sql3 = "INSERT INTO asya_bank.customer_transaction "
								+ "(transaction_id, customer_id, transaction_time, transaction_type, "
								+ "transaction_amount, balance) "
								+ "VALUES(?,?,?,?,?,?);";
						
						PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
						preparedStatement3.setString(1, customerTransaction.getTransactionId());
						preparedStatement3.setInt(2, customerTransaction.getCustomerId());
						preparedStatement3.setTimestamp(3,customerTransaction.getTransactionTime());
						preparedStatement3.setString(4, customerTransaction.getTransactionType());
						preparedStatement3.setBigDecimal(5, customerTransaction.getTransactionAmount());
						preparedStatement3.setBigDecimal(6, customerTransaction.getBalance());
						preparedStatement3.executeUpdate();
					}
				}
				connection.commit();
				isDeposit = true;
				System.out.println("Successful Deposit...");
				System.out.println("Transaction Number: " + customerTransaction.getTransactionId() + 
						"Your balance: " + customerTransaction.getBalance());
				log.info(customerTransaction);
			} catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				throw new BankException("Unsuccessful Deposit...");
			}
		}
		return isDeposit;
	}

	@Override
	public boolean makeCustomerWithDraw(int customerId, BigDecimal withDraw) throws ClassNotFoundException, SQLException, BankException {
		int count1 = 0;
		boolean isWithDraw = false;
		String accountType = null;
		BigDecimal oldBalance = new BigDecimal(0.0);
		BigDecimal newBalance = new BigDecimal(0.0);
		CustomerTransaction customerTransaction = null;
		
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(false);
			
			try {
				String sql1 = "SELECT balance, account_type "
						+ "FROM asya_bank.customer_account "
						+ "WHERE customer_id = ? ; ";
				
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
				preparedStatement1.setInt(1, customerId);
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				
				if(resultSet1.next()) {
					oldBalance = resultSet1.getBigDecimal("balance");
					accountType = resultSet1.getString("account_type");
					
					if(accountType.equalsIgnoreCase("Saving")) {
						throw new BankException("You cannot withdraw from SAVING accout.");
					}else {
						newBalance = oldBalance.subtract(withDraw);
						if(newBalance.floatValue()<0) {
							throw new BankException("You cannot withdraw due to insufficient balance.");
						}else {
							String sql2 = "UPDATE asya_bank.customer_account "
									+ "SET balance = ? "
									+ "WHERE customer_id = ? ; ";
							
							PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
							preparedStatement2.setBigDecimal(1, newBalance);
							preparedStatement2.setInt(2, customerId);
							count1 = preparedStatement2.executeUpdate();
							
							if(count1>0) {
								int minNumber = 1000;
								int maxNumber = 9999;
								Random r = new Random();
								
								String random1 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
								String random3 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
								String random2 = String.valueOf((char) (r.nextInt(26) + 'a'))+ String.valueOf((char) (r.nextInt(26) + 'a')) 
								+ String.valueOf((char) (r.nextInt(26) + 'a')) + String.valueOf((char) (r.nextInt(26) + 'a'));
								
								String transactionId = random1 + "-" + random2.toUpperCase() + "-" + random3;
								Date dateNow = new Date();
								String transactionType = "Withdraw";
								
								
								customerTransaction = new CustomerTransaction(transactionId, customerId, new Timestamp(dateNow.getTime()), 
										transactionType, withDraw, newBalance);
								
								String sql3 = "INSERT INTO asya_bank.customer_transaction "
										+ "(transaction_id, customer_id, transaction_time, transaction_type, "
										+ "transaction_amount, balance) "
										+ "VALUES(?,?,?,?,?,?);";
								PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
								preparedStatement3.setString(1, customerTransaction.getTransactionId());
								preparedStatement3.setInt(2, customerTransaction.getCustomerId());
								preparedStatement3.setTimestamp(3,customerTransaction.getTransactionTime());
								preparedStatement3.setString(4, customerTransaction.getTransactionType());
								preparedStatement3.setBigDecimal(5, customerTransaction.getTransactionAmount());
								preparedStatement3.setBigDecimal(6, customerTransaction.getBalance());
								preparedStatement3.executeUpdate();
							}
						}
						
					}
				}
				connection.commit();
				isWithDraw = true;
				System.out.println("Successful Withdraw...");
				System.out.println("Your balance: " + newBalance);
				System.out.println("Transaction Number: " + customerTransaction.getTransactionId() + 
						"Your balance: " + customerTransaction.getBalance());
				log.info(customerTransaction);
			}catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				throw new BankException("Unsuccessful WithDraw...");
			}
		}
		return isWithDraw;
	}

	@Override
	public boolean makeCustomerTransfer(int customerId, BigDecimal transfer, String transferAccountNumber) throws ClassNotFoundException, SQLException, BankException {
		int count1 = 0;
		int count2 = 0;
		boolean isTransfer = false;
		String accountType = null;
		int customerIdTransfer = 0;
		BigDecimal oldBalanceCustomer1 = new BigDecimal(0.0);
		BigDecimal newBalanceCustomer1 = new BigDecimal(0.0);
		BigDecimal oldBalanceCustomer2 = new BigDecimal(0.0);
		BigDecimal newBalanceCustomer2 = new BigDecimal(0.0);
		CustomerTransaction customerTransaction1 = null;
		CustomerTransaction customerTransaction2 = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(false);
			
			try {
				String sql1 = "SELECT balance, account_type "
						+ "FROM asya_bank.customer_account "
						+ "WHERE customer_id = ? ; ";
				
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
				preparedStatement1.setInt(1, customerId);
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				
				if(resultSet1.next()) {
					oldBalanceCustomer1 = resultSet1.getBigDecimal("balance");
					accountType = resultSet1.getString("account_type");
					if(accountType.equalsIgnoreCase("Saving")) {
						throw new BankException("You cannot trasfer from SAVING accout.");
					}else {
						newBalanceCustomer1 = oldBalanceCustomer1.subtract(transfer);
						if(newBalanceCustomer1.floatValue()<0) {
							throw new BankException("You cannot transfer due to insufficient balance.");
						}else {
							String sql2 = "SELECT customer_id, balance "
									+ "FROM asya_bank.customer_account "
									+ "WHERE account_number = ? ;";
							PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
							preparedStatement2.setString(1, transferAccountNumber);
							ResultSet resultSet2 = preparedStatement2.executeQuery();
							
							if(resultSet2.next()) {
								oldBalanceCustomer2 = resultSet2.getBigDecimal("balance");
								newBalanceCustomer2 = oldBalanceCustomer2.add(transfer);
								customerIdTransfer = resultSet2.getInt("customer_id");
								
								String sql3 =  "UPDATE asya_bank.customer_account "
										+ "SET balance = ? "
										+ "WHERE customer_id = ? ; ";
								PreparedStatement preparedStatement3_1 = connection.prepareStatement(sql3);
								preparedStatement3_1.setBigDecimal(1, newBalanceCustomer1);
								preparedStatement3_1.setInt(2, customerId);
								count1 = preparedStatement3_1.executeUpdate();
								
								if(count1>0) {
									PreparedStatement preparedStatement3_2 = connection.prepareStatement(sql3);
									preparedStatement3_2.setBigDecimal(1, newBalanceCustomer2);
									preparedStatement3_2.setInt(2, customerIdTransfer);
									count2 = preparedStatement3_2.executeUpdate();
									
									if(count2>0) {
										
										int minNumber = 1000;
										int maxNumber = 9999;
										Random r = new Random();
										
										String random1 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
										String random3 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
										String random2 = String.valueOf((char) (r.nextInt(26) + 'a'))+ String.valueOf((char) (r.nextInt(26) + 'a')) 
										+ String.valueOf((char) (r.nextInt(26) + 'a')) + String.valueOf((char) (r.nextInt(26) + 'a'));
										
										String transactionId1 = random1 + "-" + random2.toUpperCase() + "-" + random3;
										String transactionType1 = "TransferWithDraw";
										
										random1 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
										random3 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
										random2 = String.valueOf((char) (r.nextInt(26) + 'a'))+ String.valueOf((char) (r.nextInt(26) + 'a')) 
										+ String.valueOf((char) (r.nextInt(26) + 'a')) + String.valueOf((char) (r.nextInt(26) + 'a'));
										
										String transactionId2 = random1 + "-" + random2.toUpperCase() + "-" + random3;
										String transactionType2 = "TransferDeposit";
										
										Date dateNow = new Date();
										customerTransaction1 = new CustomerTransaction(transactionId1, customerId, new Timestamp(dateNow.getTime()),
												transactionType1, transfer, newBalanceCustomer1);
										customerTransaction2 = new CustomerTransaction(transactionId2, customerIdTransfer, new Timestamp(dateNow.getTime()),
												transactionType2, transfer, newBalanceCustomer2);
										
										String sql4 = "INSERT INTO asya_bank.customer_transaction "
												+ "(transaction_id, customer_id, transaction_time, transaction_type, "
												+ "transaction_amount, balance) "
												+ "VALUES(?,?,?,?,?,?);";
										
										PreparedStatement preparedStatement4_1 = connection.prepareStatement(sql4);
										preparedStatement4_1.setString(1, customerTransaction1.getTransactionId());
										preparedStatement4_1.setInt(2, customerTransaction1.getCustomerId());
										preparedStatement4_1.setTimestamp(3,customerTransaction1.getTransactionTime());
										preparedStatement4_1.setString(4, customerTransaction1.getTransactionType());
										preparedStatement4_1.setBigDecimal(5, customerTransaction1.getTransactionAmount());
										preparedStatement4_1.setBigDecimal(6, customerTransaction1.getBalance());
										preparedStatement4_1.executeUpdate();
										
										PreparedStatement preparedStatement4_2 = connection.prepareStatement(sql4);
										preparedStatement4_2.setString(1, customerTransaction2.getTransactionId());
										preparedStatement4_2.setInt(2, customerTransaction2.getCustomerId());
										preparedStatement4_2.setTimestamp(3,customerTransaction2.getTransactionTime());
										preparedStatement4_2.setString(4, customerTransaction2.getTransactionType());
										preparedStatement4_2.setBigDecimal(5, customerTransaction2.getTransactionAmount());
										preparedStatement4_2.setBigDecimal(6, customerTransaction2.getBalance());
										preparedStatement4_2.executeUpdate();
									}
								}
								
							}else {
								log.error("There is no accout with an account number " + transferAccountNumber);
							}
							
						}
						
					} 
				}
				connection.commit();
				isTransfer = true;
				System.out.println("Successful Transaction...");
				System.out.println("Transaction Number: " + customerTransaction1.getTransactionId() + 
						"Your balance: " + customerTransaction1.getBalance());
				log.info(customerTransaction1);
				log.info(customerTransaction2);
			}catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				throw new BankException("Unsuccessful Transaction...");
			}
		}
		return isTransfer;
	}

	@Override
	public boolean makeLoanApplication(int customerId, int loanTypeId, BigDecimal loanAmount, int loanDurationYear) throws ClassNotFoundException, SQLException {
		boolean isLoanApplication = false;
		Loan loan= null;
		CustomerLoan customerLoan = null;
		String loanApplicationId  = null;
		String status = null;
		int branchId = 0;
		String bankBranchName = null;
		List<Integer> allApprovingEmployeeId = new ArrayList<>();
		int approvingEmployeeId = 0;
		BigDecimal totalPaymentAmount = new BigDecimal(0);
		BigDecimal monthlyPaymentAmount = new BigDecimal(0);
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(true);
			
			String sql1 = "SELECT loan_type,interest_rate "
					+ "FROM asya_bank.loan "
					+ "WHERE loan_id = ? ;";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, loanTypeId);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			
			if(resultSet1.next()) {
				loan= new Loan();
				loan.setLoanId(loanTypeId);
				loan.setLoanType(resultSet1.getString("loan_type"));
				loan.setInterestRate(resultSet1.getDouble("interest_rate"));
				
				int minNumber = 1000;
				int maxNumber = 9999;
				Random r = new Random();
				String random1 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
				String random3 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
				String random2 = String.valueOf((char) (r.nextInt(26) + 'a'))+ String.valueOf((char) (r.nextInt(26) + 'a')) 
				+ String.valueOf((char) (r.nextInt(26) + 'a')) + String.valueOf((char) (r.nextInt(26) + 'a'));
				
				loanApplicationId = random1 + "-" + random2.toUpperCase() + "-" + random3;
				status = "Pending";
				totalPaymentAmount = new BigDecimal(loanAmount.doubleValue() * Math.pow((1+loan.getInterestRate()), loanDurationYear));
				monthlyPaymentAmount = new BigDecimal(totalPaymentAmount.doubleValue()/12/loanDurationYear);
				
				String sql2 = "SELECT branch_id "
						+ "FROM asya_bank.customer_account "
						+ "WHERE customer_id = ? ;";
				
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setInt(1, customerId);
				ResultSet resultSet2 = preparedStatement2.executeQuery();
				
				if(resultSet2.next()) {
					branchId = resultSet2.getInt("branch_id");
					
					Map<Integer, String> bank = new HashMap<>();
					bank.put(100, "Boston");
					bank.put(101, "Brockton");
					bank.put(102, "Cambridge");
					bank.put(103, "Lynn");
					bank.put(104, "New Bedford");
					bank.put(105, "Newton");
					bank.put(106, "Springfield");
					bank.put(107, "Waltham");
					bank.put(108, "Watertown");
					bank.put(109, "Woburn");
					bank.put(110, "Worcester");
					
					Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
					map.put("Boston", Arrays.asList(1045, 1047, 1048, 1049, 1050));
					map.put("Brockton", Arrays.asList(1018, 1019, 1027, 1028, 1040));
					map.put("Cambridge", Arrays.asList(1010, 1013, 1022, 1041, 1051));
					map.put("Lynn", Arrays.asList(1026, 1031, 1033, 1035, 1037));
					map.put("New Bedford", Arrays.asList(1015, 1020, 1025, 1030, 1053));
					map.put("Newton", Arrays.asList(1016, 1017, 1021, 1024, 1043));
					map.put("Springfield", Arrays.asList(1038, 1042, 1044, 1052, 1054));
					map.put("Waltham", Arrays.asList(1000, 1001, 1002, 1003, 1009));
					map.put("Watertown", Arrays.asList(1007, 1008, 1012, 1014, 1029));
					map.put("Woburn", Arrays.asList(1004, 1005, 1006, 1011, 1023));
					map.put("Worcester", Arrays.asList(1032, 1034, 1036, 1039, 1046));
					
					bankBranchName = bank.get(branchId);
					allApprovingEmployeeId = map.get(bankBranchName);
					Random rand = new Random();
					approvingEmployeeId = allApprovingEmployeeId.get(rand.nextInt(allApprovingEmployeeId.size()));
					Date now = new Date();
					
					customerLoan = new CustomerLoan(loanApplicationId, customerId, loanTypeId, now, status, loanAmount, 
							loanDurationYear, approvingEmployeeId, totalPaymentAmount, monthlyPaymentAmount);
					
					String sql3 = "INSERT INTO asya_bank.customer_loan "
							+ "(loan_application_id, customer_id, loan_id, date_of_application, status, loan_amount, "
							+ "duration_year, approving_employee_id, total_payment_amount, monthly_payment_amount) "
							+ "VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?) ;" ;
					
					PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
					preparedStatement3.setString(1, customerLoan.getLoanApplicationId());
					preparedStatement3.setInt(2, customerLoan.getCustomerId());
					preparedStatement3.setInt(3, customerLoan.getLoanId());
					preparedStatement3.setTimestamp(4, new Timestamp(customerLoan.getDateOfApplication().getTime()));
					preparedStatement3.setString(5, customerLoan.getStatus());
					preparedStatement3.setBigDecimal(6, customerLoan.getLoanAmount());
					preparedStatement3.setInt(7, customerLoan.getDurationYear());
					preparedStatement3.setInt(8, customerLoan.getApprovingEmployeeId());
					preparedStatement3.setBigDecimal(9, customerLoan.getTotalPaymentAmount());
					preparedStatement3.setBigDecimal(10, customerLoan.getMonthlyPaymentAmount());
					preparedStatement3.executeUpdate();
					isLoanApplication = true;
					System.out.println("Your loan application is recieved...");
					System.out.println("Loan Application Number: " + customerLoan.getLoanApplicationId());
					log.info(customerLoan);
				}
			}
		}
		return isLoanApplication;
	}

	@Override
	public boolean makeCustomerLoanPayment(int customerId, BigDecimal loanPayment) throws ClassNotFoundException, SQLException, BankException {
		int count1 = 0;
		boolean isLoanPayment = false;
		String accountType = null;
		BigDecimal oldBalance = new BigDecimal(0.0);
		BigDecimal newBalance = new BigDecimal(0.0);
		CustomerTransaction customerTransaction = null;
		
		try (Connection connection = PostgresSqlConnection.getConnection()){
			connection.setAutoCommit(false);
			
			try {
				String sql1 = "SELECT balance, account_type "
						+ "FROM asya_bank.customer_account "
						+ "WHERE customer_id = ? ; ";
				
				PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
				preparedStatement1.setInt(1, customerId);
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				
				if(resultSet1.next()) {
					oldBalance = resultSet1.getBigDecimal("balance");
					accountType = resultSet1.getString("account_type");
					
					if(accountType.equalsIgnoreCase("Saving")) {
						throw new BankException("You cannot withdraw from SAVING accout.");
					}else {
						newBalance = oldBalance.subtract(loanPayment);
						if(newBalance.floatValue()<0) {
							throw new BankException("You cannot withdraw due to insufficient balance.");
						}else {
							String sql2 = "UPDATE asya_bank.customer_account "
									+ "SET balance = ? "
									+ "WHERE customer_id = ? ; ";
							
							PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
							preparedStatement2.setBigDecimal(1, newBalance);
							preparedStatement2.setInt(2, customerId);
							count1 = preparedStatement2.executeUpdate();
							
							if(count1>0) {
								int minNumber = 1000;
								int maxNumber = 9999;
								Random r = new Random();
								
								String random1 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
								String random3 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
								String random2 = String.valueOf((char) (r.nextInt(26) + 'a'))+ String.valueOf((char) (r.nextInt(26) + 'a')) 
								+ String.valueOf((char) (r.nextInt(26) + 'a')) + String.valueOf((char) (r.nextInt(26) + 'a'));
								
								String transactionId = random1 + "-" + random2.toUpperCase() + "-" + random3;
								Date dateNow = new Date();
								String transactionType = "LoanPayment";
								
								customerTransaction = new CustomerTransaction(transactionId, customerId, new Timestamp(dateNow.getTime()), 
										transactionType, loanPayment, newBalance);
								
								String sql3 = "INSERT INTO asya_bank.customer_transaction "
										+ "(transaction_id, customer_id, transaction_time, transaction_type, "
										+ "transaction_amount, balance) "
										+ "VALUES(?,?,?,?,?,?);";
								PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
								preparedStatement3.setString(1, customerTransaction.getTransactionId());
								preparedStatement3.setInt(2, customerTransaction.getCustomerId());
								preparedStatement3.setTimestamp(3, customerTransaction.getTransactionTime());
								preparedStatement3.setString(4, customerTransaction.getTransactionType());
								preparedStatement3.setBigDecimal(5, customerTransaction.getTransactionAmount());
								preparedStatement3.setBigDecimal(6, customerTransaction.getBalance());
								preparedStatement3.executeUpdate();
								
								connection.commit();
								isLoanPayment = true;
								System.out.println("Successful Loan Payment...");
								System.out.println("Transaction Number: " + customerTransaction.getTransactionId() + 
										"Your balance: " + customerTransaction.getBalance());
								log.info(customerTransaction);
							}
						}
						
					}
				}
			}catch (SQLException e) {
				connection.rollback();
				connection.setAutoCommit(true);
				throw new BankException("Unsuccessful Loan Payment...");
			}
		}
		return isLoanPayment;
	}
}