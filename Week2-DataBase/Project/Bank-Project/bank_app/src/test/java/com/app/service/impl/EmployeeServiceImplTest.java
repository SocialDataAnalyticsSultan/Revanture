package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.dao.CustomerDAO;
import com.app.dao.EmployeeDAO;
import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerTransaction;
import com.app.service.CustomerService;
import com.app.service.EmployeeService;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
	
	@Mock
	EmployeeDAO employeeDAO;
	
	@InjectMocks
	EmployeeService employeeService = new EmployeeServiceImpl();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void employeeLogInTest() throws ClassNotFoundException, SQLException, BankException {
		//String userName = "kmacalpink9";
		//String password = "hZ9WEF";
		int employeeId = 1000;
		//when(employeeDAO.employeeLogIn(userName, password)).thenReturn(employeeId);
		int employeeIdKarleeTest = employeeService.employeeLogIn();
		Assertions.assertEquals(employeeIdKarleeTest, employeeId);
	}
	
	@Test
	void employeeLogInTest2() throws ClassNotFoundException, SQLException, BankException {
		//String userName = "kmacalpink9";
		//String password = "hZ9W";
		Assertions.assertThrows(BankException.class, () -> {
			employeeService.employeeLogIn();
		});
	}
	
	@Test
	void getCustomerInformationByIdTest() throws ClassNotFoundException, SQLException, ParseException, BankException {
		
		Address addressMirella = new Address("8604 Division Center", "Brockton", "Massachusetts", "United States", "2298");
		
		String sDate="1975-02-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
		
		Customer customerMirellaTest = employeeService.getCustomerInformationById(customerId);
		Assertions.assertEquals(customerMirellaTest, customerMirella);	
	}
	
	@Test
	void getCustomerInformationByIdTest2() throws ClassNotFoundException, SQLException, BankException {
		int customerId = -1000;
		
		Assertions.assertThrows(BankException.class, () -> {
			employeeService.getCustomerInformationById(customerId);
		});
	}
	
	@Test
	void getCustomerInformationByAccountNumberTest() throws ClassNotFoundException, BankException, SQLException, ParseException {

		Address addressMirella = new Address("8604 Division Center", "Brockton", "Massachusetts", "United States", "2298");
		
		String sDate="1975-02-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
		
		String accountNumber = "8490-2574-5953-1874";
		Customer customerMirella = new Customer(firstName, lastName, dateOfBirth, gender, 
				maritalStatus, nationality, socialSecurityNumber, address, email, phoneNumber,
				customerId, occupation, yearlyIncome, creditScore, userName, password); 
		Customer customerMirellaTest = employeeService.getCustomerInformationByAccountNumber(accountNumber);
		Assertions.assertEquals(customerMirellaTest, customerMirella);
	}
	
	@Test
	void getCustomerInformationByAccountNumberTest2() throws ClassNotFoundException, BankException, SQLException, ParseException {
		String accountNumber = "840-2574-5953-184";
		
		Assertions.assertThrows(BankException.class, () -> {
			employeeService.getCustomerInformationByAccountNumber(accountNumber);
		});
	}
	
	@Test
	void getCustomerInformationByFirstNameTest() throws ClassNotFoundException, BankException, SQLException, ParseException {
		Address addressMirella = new Address("8604 Division Center", "Brockton", "Massachusetts", "United States", "2298");
		
		String sDate="1975-02-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateMirella = null;
		dateMirella = sdf.parse(sDate);
		
		Customer customerMirella = new Customer("Mirella", "Lindell", dateMirella, "Female", 
				"Married", "Creek", "458-55-6665", addressMirella, "mlindell0@wordpress.org", "617-228-8090",
				1000, "Project Manager", new BigDecimal(84039), 819, "mlindell0", "QAvqEAuy5"); 
		
		String customerFirstName = "Mirella";
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customerMirella);
		List<Customer> customerListTest = employeeService.getCustomerInformationByFirstName(customerFirstName);
		Assertions.assertEquals(customerListTest, customerList);
	}
	
	@Test
	void getCustomerInformationByLastNameTest() throws ParseException, ClassNotFoundException, BankException, SQLException {

		Address addressMirella = new Address("8604 Division Center", "Brockton", "Massachusetts", "United States", "2298");
		
		String sDate="1975-02-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateMirella = null;
		dateMirella = sdf.parse(sDate);
		
		Customer customerMirella = new Customer("Mirella", "Lindell", dateMirella, "Female", 
				"Married", "Creek", "458-55-6665", addressMirella, "mlindell0@wordpress.org", "617-228-8090",
				1000, "Project Manager", new BigDecimal(84039), 819, "mlindell0", "QAvqEAuy5"); 
		
		String customerLastName = "Lindell";
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customerMirella);
		List<Customer> customerListTest = employeeService.getCustomerInformationByLastName(customerLastName);
		Assertions.assertEquals(customerListTest, customerList);
	}
	
	@Test
	void getCustomerInformationByBankBranchIdTest() throws ParseException, ClassNotFoundException, BankException, SQLException {
		
		int bankBranchId = 101;
		List<Customer> customerListTest = employeeService.getCustomerInformationByBankBranchId(bankBranchId);
		Assertions.assertEquals(customerListTest.size(), 11);
	}
	
	@Test
	 void getCustomerAccountByIdTest() throws ParseException, ClassNotFoundException, SQLException, BankException {
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
		CustomerAccount customerAccountMirellaTest = employeeService.getCustomerAccountById(customerId);
		Assertions.assertEquals(customerAccountMirellaTest, customerAccountMirella);
	}
	
	@Test
	void getCustomerAccountByAccountNumberTest() throws ParseException, ClassNotFoundException, SQLException, BankException {
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
		CustomerAccount customerAccountMirellaTest = employeeService.getCustomerAccountByAccountNumber(accountNumber);
		Assertions.assertEquals(customerAccountMirellaTest, customerAccountMirella);
	}
	
	@Test
	void getCustomerTransactionByCustomerIdTest() throws ClassNotFoundException, SQLException, BankException {
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
		customerTransactionMirella.add(new CustomerTransaction("2428-GPRC-3247", customerId, 
				Timestamp.valueOf("2021-01-12 17:01:00"), "Deposit", new BigDecimal(100), 
				new BigDecimal(50949)));
		customerTransactionMirella.add(new CustomerTransaction("7174-VTXG-3962", customerId, 
				Timestamp.valueOf("2021-01-12 17:01:44"), "Deposit", new BigDecimal(100), 
				new BigDecimal(51049)));
		customerTransactionMirella.add(new CustomerTransaction("9427-KPNG-2726", customerId, 
				Timestamp.valueOf("2021-01-12 17:02:01"), "Deposit", new BigDecimal(100), 
				new BigDecimal(51149)));
		customerTransactionMirella.add(new CustomerTransaction("9435-QTIO-8018", customerId, 
				Timestamp.valueOf("2021-01-12 17:16:19"), "Deposit", new BigDecimal(100), 
				new BigDecimal(51249)));
		customerTransactionMirella.add(new CustomerTransaction("3604-LOTY-7912", customerId, 
				Timestamp.valueOf("2021-01-12 17:25:37"), "Withdraw", new BigDecimal(100), 
				new BigDecimal(51149)));
		customerTransactionMirella.add(new CustomerTransaction("1156-DPZO-5723", customerId, 
				Timestamp.valueOf("2021-01-12 17:31:18"), "TransferWithDraw", new BigDecimal(1000), 
				new BigDecimal(50149)));
			
		List <CustomerTransaction> customerTransactionMirellaTest = employeeService.getCustomerTransactionByCustomerId(customerId);
		Assertions.assertEquals(customerTransactionMirellaTest, customerTransactionMirella);
	}
}
