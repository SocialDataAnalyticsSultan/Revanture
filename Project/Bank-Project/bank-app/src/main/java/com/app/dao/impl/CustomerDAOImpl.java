package com.app.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.PostresqlConnection;
import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.model.customer.account.Account;
import com.app.model.customer.account.AccountHistory;
import com.app.model.customer.loan.LoanApplication;
import com.app.model.customer.loan.LoanPayment;
import com.app.model.customer.transaction.Transaction;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static Logger logBank =Logger.getLogger(CustomerDAOImpl.class);
	
	@Override
	public boolean validateLogInInformation(String username, String password) throws BankException {

		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "SELECT username password "
					+ "FROM Customer "
					+ "WHERE username = ? AND password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				return true;
			}else {
				System.out.println("There is no account with provided username and password...");
				System.out.println("Please register the bank...");
			}
			
		}catch(ClassNotFoundException | SQLException e) {
			throw new BankException("Internal error occured contact SYSADMIN ");
		}
		return false;
	}	
	
	@Override
	public Customer makeRegistration (String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality,
			String occupation, int creaditScore, BigDecimal yearlyIncome, String userName, String password) throws ClassNotFoundException, SQLException, BankException {
		
		Customer newCustomer = null;
		int customerId = 0;
		try(Connection connection = PostresqlConnection.getConnection()){
			String sql = "SELECT MAX(customerId) FROM Customer";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				customerId = resultSet.getInt("customerId") + 1;
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e); // Take off this line when app is live
			throw new BankException("Internal error occured contact SYSADMIN ");
		}
		
		newCustomer = new Customer(firstName, lastName, dateOfBirth, gender, maritalStatus,
				socialSecurityNumber, address, email, mobilePhone, nationality,
				customerId, occupation, creaditScore, yearlyIncome,  userName, password);
		
		try (Connection connection = PostresqlConnection.getConnection()){
			
			String sql = "INSERT INTO Customer (customerId, firstName, lastName, dateOfBirth, gender, maritalStatus, "
					+ "socialSecurityNumber, street, city, state, country, zipcode, email, mobilePhone, nationality, occupation, "
					+ "creaditScore, yearlyIncome, userName, password) VALUES(? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newCustomer.getCustomerId());
			preparedStatement.setString(2, newCustomer.getFirstName());
			preparedStatement.setString(3, newCustomer.getLastName());
			preparedStatement.setDate(4, new java.sql.Date(newCustomer.getDateOfBirth().getTime()));
			preparedStatement.setString(5, newCustomer.getGender());
			preparedStatement.setString(6, newCustomer.getMaritalStatus());
			preparedStatement.setString(7, newCustomer.getSocialSecurityNumber());
			preparedStatement.setString(8, newCustomer.getAddress().getStreet());
			preparedStatement.setString(9, newCustomer.getAddress().getCity());
			preparedStatement.setString(10, newCustomer.getAddress().getState());
			preparedStatement.setString(11, newCustomer.getAddress().getCountry());
			preparedStatement.setString(12, newCustomer.getAddress().getZipcode());
			preparedStatement.setString(13, newCustomer.getEmail());
			preparedStatement.setString(14, newCustomer.getMobilePhone());
			preparedStatement.setString(15, newCustomer.getNationality());
			preparedStatement.setString(16, newCustomer.getOccupation());
			preparedStatement.setInt(17, newCustomer.getCreaditScore());
			preparedStatement.setBigDecimal(18, newCustomer.getYearlyIncome());
			preparedStatement.setString(19, newCustomer.getUserName());
			preparedStatement.setString(20, newCustomer.getPassword());
			preparedStatement.executeUpdate();
			
		}catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
		
		return newCustomer;
	}

	@Override
	public Account getAccountInformation(int customerId) throws ClassNotFoundException, SQLException, BankException{
		
		Account customerAccount = null;
		try (Connection connection = PostresqlConnection.getConnection()){
			
			String sql = "SELECT accountNumber, customerId, branchId, dateOfOpen, approvingEmployeeId, balance, accountType "
					+ "FROM Account "
					+ "WHERE customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			customerAccount = new Account();
			while(resultSet.next()) {
				
				customerAccount.setAccountNumber(resultSet.getString("accountNumber"));
				customerAccount.setCustomerId(resultSet.getInt("customerId"));
				customerAccount.setBranchId(resultSet.getInt("branchId"));
				customerAccount.setDateOfOpen(resultSet.getDate("dateOfOpen"));
				customerAccount.setApprovingEmployeeId(resultSet.getInt("approvingEmployeeId"));
				customerAccount.setBalance(resultSet.getBigDecimal("balance"));
				customerAccount.setAccountType(resultSet.getString("accountType"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
		return customerAccount;
	}
	
	@Override
	public void makeDeposit(BigDecimal amount, int customerId) throws BankException, SQLException, ClassNotFoundException  {
		
		BigDecimal newBalance = BigDecimal.ZERO;
		try (Connection connection = PostresqlConnection.getConnection()){
			
			String sql = "SELECT balance  "
					+ "FROM Account "
					+ "WHERE customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				newBalance = resultSet.getBigDecimal("balance");
				newBalance.add(amount);
				String newSql = "UPDATE Account "
						+ "SET balance ? "
						+ "WHERE customerId = ?";
				PreparedStatement newPreparedStatement = connection.prepareStatement(newSql);
				newPreparedStatement.setBigDecimal(1, newBalance);
				newPreparedStatement.setInt(2, customerId);
				newPreparedStatement.executeUpdate();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
	}

	@Override
	public void makeWithDraw(BigDecimal amount, int customerId) throws BankException, SQLException, ClassNotFoundException {
		BigDecimal newBalance = BigDecimal.ZERO;
		try (Connection connection = PostresqlConnection.getConnection()){
			
			String sql = "SELECT balance, accountType  "
					+ "FROM Account "
					+ "WHERE customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String accountType = resultSet.getString("accountType");
				if(accountType == "Saving") {
					throw new BankException("You cannot Withdraw from Saving Account.");
				}else {
					double dbalance = resultSet.getBigDecimal("balance").doubleValue();
					double dwithdraw = amount.doubleValue();
					double dnewBalance = dbalance-dwithdraw;
					if (dnewBalance<0) {
						throw new BankException("Your Balance is insufficient $." + dbalance);
					}else {
						newBalance = BigDecimal.valueOf(dnewBalance);
						String sql2 = "UPDATE Account  "
								+ "SET balance ? "
								+ "WHERE customerId = ?";
						PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
						preparedStatement2.setBigDecimal(1, newBalance);
						preparedStatement2.setInt(2, customerId);
						preparedStatement2.executeUpdate();
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
	}
	
	@Override
	public List<AccountHistory> getAccountHistory(int customerId) throws ClassNotFoundException, SQLException, BankException {
		
		List<AccountHistory> customerAccountHistory = new ArrayList<AccountHistory>();
		try (Connection connection = PostresqlConnection.getConnection()){
			
			String sql = "SELECT accountNumber "
					+ "FROM Account "
					+ "WHERE customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			String accountNumber = null;
			while(resultSet.next()) {
				accountNumber = resultSet.getString("accountNumber");
				String sql2 = "SELECT accountNumber, amount, depositOrWithdraw, date, balance "
						+ "FROM AccountHistory "
						+ "WHERE accountNumber = ?";
				
				PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
				preparedStatement2.setString(1, accountNumber);
				ResultSet resultSet2=preparedStatement2.executeQuery();
				
				AccountHistory temp = new AccountHistory();
				while(resultSet2.next()) {
					temp.setAccountNumber(resultSet2.getString("accountNumber"));
					temp.setAmount(resultSet2.getBigDecimal("amount"));
					temp.setDepositOrWithdraw(resultSet2.getString("depositOrWithdraw"));
					temp.setDate(resultSet2.getDate("date"));
					temp.setBalance(resultSet2.getBigDecimal("balance"));
					customerAccountHistory.add(temp);
				}
			}
			
			if(customerAccountHistory.size() == 0) {
				throw new BankException("There is no account for Customer Indentification Number of " + customerId);
				}
			}catch(ClassNotFoundException | SQLException e) {
				throw e;
			}
		return customerAccountHistory;
	}

	@Override
	public void makeTransansaction(int customerId, String transferAccount, BigDecimal transferAmonth) throws ClassNotFoundException, SQLException, BankException, ParseException {
		
		try (Connection connection = PostresqlConnection.getConnection()){
			
			String sql = "SELECT accountNumber, balance, accountType  "
					+ "FROM Account "
					+ "WHERE customerId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet=preparedStatement.executeQuery();
			Boolean result = false;
			
			while(resultSet.next())
				try {
					{
						
						
						String customerAccountType = resultSet.getString("accountType");
						BigDecimal customerBalance = resultSet.getBigDecimal("balance");
						String customerAccountNumber = resultSet.getString("accountNumber");
						
						if (customerAccountType == "Saving") {
							throw new BankException("You can not Transfer from Saving Account");
						}
						if (customerBalance.doubleValue() < transferAmonth.doubleValue()){
							throw new BankException("Your Balance is not Enough for Transaction");
						}
						if(customerAccountNumber.equals(transferAccount)) {
							throw new BankException("Transaction Account is Same with Your Account");
						}
						
						String sql2 = "SELECT customerId, balance "
								+ "FROM Account "
								+ "WHERE accountNumber = ? ";
						PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
						preparedStatement2.setString(1, transferAccount);
						ResultSet resultSet2=preparedStatement2.executeQuery();
						
						BigDecimal transferBalance = BigDecimal.ZERO;
						if (!resultSet2.next()) {
							throw new BankException("Transaction Account is not Exist");
						}else {
							transferBalance = resultSet2.getBigDecimal("balance");
						}
						
						String sql3 = "SELECT MAX(transactionId) AS maxTransactionIndex "
								+ "FROM Transaction ";
						PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
						ResultSet resultSet3 = preparedStatement3.executeQuery();
						int maxTransactionId = resultSet3.getInt("maxTransactionIndex");
						int transactionId = maxTransactionId + 1;
						
						customerBalance = BigDecimal.valueOf(customerBalance.doubleValue()- transferAmonth.doubleValue());
						transferBalance = transferBalance.add(transferAmonth);
						SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
						sdf.setLenient(false);
						Date dateOfTransfer = sdf.parse(LocalDate.now().toString());
						String createFunction = "CREATE FUNCTION transaction(customerId int, transferAccount varchar(12), transactionId int, transferAmonth BigDecimal, dateOfTransfer Date"
								+ "RETURNS BOOLEAN AS $$"
								+ "UPDATE Account "
								+ "SET balance customerBalance "
								+ "WHERE customerId = customerId; "
								+ "UPDATE Account "
								+ "SET balance transferBalance "
								+ "WHERE accountNumber = transferAccount; "
								+ "INSERT INTO Transaction"
								+ "(transactionId, customerId, transferAccountNumber, transferAmount, dateOfTransfer)"
								+ "VALUES (transactionId, customerId, transferAccount, transferAmonth, dateOfTransfer);"
								+ "$$ LANGUAGE SQL;";
						
						String runFunction = "{ ? = call transaction( ?,?,?,?,? ) }";
						Statement statement = connection.createStatement();
						statement.execute(createFunction);
						CallableStatement callableStatement = connection.prepareCall(runFunction);
						callableStatement.registerOutParameter(1, Types.BOOLEAN);
						callableStatement.setInt(2, customerId);
						callableStatement.setString(3, transferAccount);
						callableStatement.setInt(4, transactionId);
						callableStatement.setBigDecimal(5, transferAmonth);
						callableStatement.setDate(6, (java.sql.Date) dateOfTransfer);
						
						callableStatement.executeUpdate();
						result = callableStatement.getBoolean(1);
					}
				} catch (SQLException | BankException | ParseException e) {
					throw e;
				}
			
			if (!result) {
				throw new BankException("Transfer is not Successful. Please Try Later..");
			}
			
		}
		
	}

	@Override
	public List<Transaction> getTransactionHistory() {
		
		return null;
	}

	@Override
	public LoanApplication applyForLoan(String loanType, BigDecimal loanAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void payForLoan(BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LoanPayment> getLoanPaymentInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
