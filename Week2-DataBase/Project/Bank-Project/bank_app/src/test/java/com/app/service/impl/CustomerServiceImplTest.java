package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerTransaction;
import com.app.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
	
	@Mock
	CustomerDAO customerDAO; //= new CustomerDAOImpl();

	@InjectMocks
	CustomerService customerService = new CustomerServiceImpl();
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void customerLogInTest() throws ClassNotFoundException, SQLException, BankException {
		//String userName = "mlindell0";
		//String password = "QAvqEAuy5";
		int customerId = 1000;
		//when(customerDAO.customerLogIn(userName, password)).thenReturn(customerId);
		int customerIdMirellaTest = customerService.customerLogIn();
		Assertions.assertEquals(customerIdMirellaTest, customerId);
	}
	
	@Test
	void customerLogInTest2() throws ClassNotFoundException, SQLException, BankException {
		//String userName = "mlindell1";
		//String password = "QAv";
		Assertions.assertThrows(BankException.class, () -> {
			customerService.customerLogIn();
		});
	}
	
	@Test
	void getCustomerInformationTest() throws ClassNotFoundException, SQLException, BankException, ParseException {
		Address addressMirella = new Address("8604 Division Center", "Brockton", "Massachusetts", "United States", "2298");
		
		String sDate="1975-02-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//sdf.setLenient(false);
		Date dateMirella = null;
		dateMirella = sdf.parse(sDate);
		
		String firstName = "Mirella";
		String lastName = "Lindell";
		Date dateOfBirth = dateMirella;
		String gender = "Female";
		String maritalStatus = "Married";
		String nationality = "Creek";
		String socialSecurityNumber = "458-55-6665";
		Address address = addressMirella;
		String email = "mlindell0@wordpress.org";
		String phoneNumber = "617-228-8090";
		int customerId = 1000;
		String occupation = "Project Manager";
		BigDecimal yearlyIncome = new BigDecimal(84039);
		int creditScore = 819;
		String userName = "mlindell0";
		String password = "QAvqEAuy5";
		
		Customer customerMirella = new Customer(firstName, lastName, dateOfBirth, gender, 
				maritalStatus, nationality, socialSecurityNumber, address, email, phoneNumber,
				customerId, occupation, yearlyIncome, creditScore, userName, password); 
		
		//when(customerDAO.getCustomerInformation(1000)).thenReturn(customerMirella);
		Customer customerMirellaTest = customerService.getCustomerInformation(1000);
		
		Assertions.assertEquals(customerMirellaTest, customerMirella);	
	}
	
	@Test
	void getCustomerAccountTest() throws ClassNotFoundException, SQLException, ParseException{
		String sDate="2019-11-03";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int customerId = 1000;
		String accountType = "Checking";
		String accountNumber = "8490-2574-5953-1874";
		Date openDate = sdf.parse(sDate);
		BigDecimal balance = new BigDecimal(50849);
		int branchId = 101;
		int approvingEmployeeId = 1028;
		
		CustomerAccount customerAccountMirella = new CustomerAccount(customerId, accountType, accountNumber, 
				openDate, balance, branchId, approvingEmployeeId);
		CustomerAccount customerAccountMirellaTest = customerService.getCustomerAccount(1000);
		Assertions.assertEquals(customerAccountMirellaTest, customerAccountMirella);
	}
	
	@Test 
	void getCustomerTransactionTest() throws ClassNotFoundException, SQLException {
		int customerId = 1000;

		List<CustomerTransaction> customerTransactionMirella = new ArrayList<>();
		customerTransactionMirella.add(new CustomerTransaction("4523-SJKV-9752", customerId, 
				Timestamp.valueOf("2019-11-06 19:42:00"), "Deposit", new BigDecimal(817), 
				new BigDecimal(53125)));
		customerTransactionMirella.add(new CustomerTransaction("1079-TCPY-2157", customerId, 
				Timestamp.valueOf("2019-11-08 05:05:00"), "Withdraw", new BigDecimal(244), 
				new BigDecimal(52881)));
		customerTransactionMirella.add(new CustomerTransaction("8803-DVHI-9495", customerId, 
				Timestamp.valueOf("2019-11-14 10:14:00"), "Deposit", new BigDecimal(387), 
				new BigDecimal(53268)));
		customerTransactionMirella.add(new CustomerTransaction("7946-CMBH-0632", customerId, 
				Timestamp.valueOf("2019-12-10 13:11:00"), "Deposit", new BigDecimal(801), 
				new BigDecimal(53072)));
		customerTransactionMirella.add(new CustomerTransaction("0493-MCBY-5961", customerId, 
				Timestamp.valueOf("2019-12-17 11:01:00"), "Withdraw", new BigDecimal(997), 
				new BigDecimal(52271)));
		customerTransactionMirella.add(new CustomerTransaction("8944-TETX-6231", customerId, 
				Timestamp.valueOf("2020-01-06 08:32:00"), "Withdraw", new BigDecimal(308), 
				new BigDecimal(52764)));
		customerTransactionMirella.add(new CustomerTransaction("9071-PYXI-1739", customerId, 
				Timestamp.valueOf("2020-02-03 14:51:00"), "Withdraw", new BigDecimal(765), 
				new BigDecimal(51999)));
		customerTransactionMirella.add(new CustomerTransaction("7915-CEPF-5606", customerId, 
				Timestamp.valueOf("2020-03-07 11:48:00"), "Deposit", new BigDecimal(747), 
				new BigDecimal(52746)));
		customerTransactionMirella.add(new CustomerTransaction("7792-GTPR-5585", customerId, 
				Timestamp.valueOf("2020-04-20 11:10:00"), "Withdraw", new BigDecimal(562), 
				new BigDecimal(52184)));
		customerTransactionMirella.add(new CustomerTransaction("3271-JZLT-1421", customerId, 
				Timestamp.valueOf("2020-06-02 09:09:00"), "Withdraw", new BigDecimal(335), 
				new BigDecimal(51849)));
		customerTransactionMirella.add(new CustomerTransaction("6120-QPML-1274", customerId, 
				Timestamp.valueOf("2021-01-02 11:48:00"), "TransferWithDraw", new BigDecimal(1000), 
				new BigDecimal(50849)));
		
		List <CustomerTransaction> customerTransactionMirellaTest = customerService.getCustomerTransaction(customerId);
		Assertions.assertEquals(customerTransactionMirellaTest, customerTransactionMirella);
	}
	
	@Test
	void updateCustomerAddressTest() throws ClassNotFoundException, SQLException, BankException {
		int customerId = 1000;
		String street = "8604 Division Center";
		String city = "Brockton";
		String state = "Massachusetts";
		String country = "United States";
		String zipcode = "2298";
		Assertions.assertTrue(customerService.updateCustomerAddress(customerId, street, city, state, country, zipcode));
	}
	
	@Test
	void updateCustomerPhoneNumberTest() throws ClassNotFoundException, BankException, SQLException {
		int customerId = 1000;
		String phoneNumber = "617-228-8090"; 
		Assertions.assertTrue(customerService.updateCustomerPhoneNumber(customerId, phoneNumber));
	}
	
	@Test
	void updateCustomerEmailTest() throws ClassNotFoundException, BankException, SQLException {
		int customerId = 1000;
		String email = "mlindell0@wordpress.org";
		Assertions.assertTrue(customerService.updateCustomerEmail(customerId, email));
	}
	
	@Test
	void updateCustomerPasswordTest() throws ClassNotFoundException, BankException, SQLException {
		int customerId = 1000;
		String password = "QAvqEAuy5";
		Assertions.assertTrue(customerService.updateCustomerPassword(customerId, password));
	}
	
	@Test
	void makeCustomerDepositTest() {
		int customerId = 1000;
		BigDecimal deposit = new BigDecimal(0);
		Assertions.assertThrows(BankException.class, () -> {
			customerService.makeCustomerDeposit(customerId, deposit);
		});
	}
	
	@Test
	void makeCustomerDepositTest2() throws ClassNotFoundException, SQLException, BankException{
		int customerId = 1000;
		BigDecimal deposit = new BigDecimal(100);
		Assertions.assertTrue(customerService.makeCustomerDeposit(customerId, deposit));
	}
	
	@Test
	void makeCustomerWithDrawTest() {
		int customerId = 1000;
		BigDecimal deposit = new BigDecimal(0);
		Assertions.assertThrows(BankException.class, () -> {
			customerService.makeCustomerWithDraw(customerId, deposit);
		});
	}
	
	@Test
	void makeCustomerWithDrawTest2() throws ClassNotFoundException, BankException, SQLException {
		int customerId = 1000;
		BigDecimal deposit = new BigDecimal(100);
		Assertions.assertTrue(customerService.makeCustomerWithDraw(customerId, deposit));
	}
	
	@Test
	void makeCustomerTransferTest() throws ClassNotFoundException, BankException, SQLException {
		int customerId = 1000;
		BigDecimal transfer = new BigDecimal(1000);
		String transferAccountNumber = "2365-7802-0719-8103";
		Assertions.assertTrue(customerService.makeCustomerTransfer(customerId, transfer, transferAccountNumber));
	}
	
	@Test //wrong account number
	void makeCustomerTransferTest2() {
		int customerId = 1000;
		BigDecimal transfer = new BigDecimal(1000);
		String transferAccountNumber = "0000-0000-0000-0000";
		Assertions.assertThrows(BankException.class, () -> {
			customerService.makeCustomerTransfer(customerId, transfer, transferAccountNumber);
		});
	}
	
	@Test //wrong transfer amount
	void makeCustomerTransferTest3() {
		int customerId = 1000;
		BigDecimal transfer = new BigDecimal(-1000);
		String transferAccountNumber = "2365-7802-0719-8103";
		Assertions.assertThrows(BankException.class, () -> {
			customerService.makeCustomerTransfer(customerId, transfer, transferAccountNumber);
		});
	}
	
	@Test
	void makeLoanApplicationTest() throws ClassNotFoundException, BankException, SQLException {
		int customerId = 1000;
		int loanTypeId = 100;
		BigDecimal loanAmount = new BigDecimal(100000); 
		int loanDurationYear = 3;
		Assertions.assertTrue(customerService.makeLoanApplication(customerId, loanTypeId, loanAmount, loanDurationYear));
	}
}
