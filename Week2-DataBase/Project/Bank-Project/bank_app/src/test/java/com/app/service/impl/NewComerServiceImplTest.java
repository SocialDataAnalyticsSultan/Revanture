package com.app.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.dao.NewComerDAO;
import com.app.exception.BankException;
import com.app.service.NewComerService;


@ExtendWith(MockitoExtension.class)
class NewComerServiceImplTest {
	
	@Mock
	NewComerDAO newComerDAO;
	
	@InjectMocks
	NewComerService newComerService = new NewComerServiceImpl();


	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void NewComerApplicationTest() throws ClassNotFoundException, BankException, SQLException {
		
		Assertions.assertTrue(newComerService.NewComerApplication());
	}
}

/*
 * First Name: Sultan
 * Last Name: Anbar
 * Date of Birth (mm-dd-yyyy): 11-11-1960
 * Gender (Female/Male): Female
 * Marital Status (Single/Married) (Optional): Married
 * Nationality (Optional): Turkish
 * Social Security Number (000-00-0000): 111-11-1111
 * Street: Street
 * City: City
 * State: State
 * Country: Country
 * Zipcode (0000): 1111
 * Email: sanbar@hk
 * Phone Number (000-000-0000): 111-111-1111
 * Occupation: Data Analytics
 * Yearly Income: 12000
 * Credit Score: 333
 * Username: sanbar
 * Password: sanbar
 * 
 * Your customer identification number is 1109
 * Account type (Saving/Checking): Saving
 * Your branch choice code: 100
 * Enter the amount you would like to deposit: 1000
 * 
 * CONGRATULATIONS!!!!
 * 
 * Your Account Number is 1329-5576-4068
 * */

