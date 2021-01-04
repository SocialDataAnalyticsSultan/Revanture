package com.app.service2.impl.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.app.exception.BusinessException;
import com.app.service2.AppService;
import com.app.service2.impl.AppServiceImpl;

class AppServiceImplTest {

	private static AppService app;
	
	@BeforeAll
	public static void setUp() {
		app=new AppServiceImpl();
	}
	
	@Test
	void testIsValidPrimeNumberForTrue() {
		assertTrue(app.isValidPrimeNumber(3));
	}
	
	@Test
	void testIsValidPrimeNumberForFalse() {
		assertFalse(app.isValidPrimeNumber(4));
	}
	
	@Test
	void testIsValidPrimeNumberForNegativeNumber() {
		assertFalse(app.isValidPrimeNumber(-4));
	}

	@Test
	void testIsValidMobileNumberForTrue() {
		assertTrue(app.isValidMobileNumber("+1-1234567890"));
	}
	
	@Test
	void testIsValidMobileNumberForException() {
		Executable executable=new Executable() {
			
			@Override
			public void execute() throws Throwable {
				app.isValidMobileNumber(null);
				
			}
		};
		assertThrows(BusinessException.class, executable);
	}

}
