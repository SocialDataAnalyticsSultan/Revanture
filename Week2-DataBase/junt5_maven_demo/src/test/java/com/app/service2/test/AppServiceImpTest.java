package com.app.service2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.app.exception.BusinessException;
import com.app.service2.AppService;
import com.app.service2.impl.AppServiceImp;

class AppServiceImpTest {
	
	private static AppService app;
	
	@BeforeAll
	public static void setUp() {
		app = new AppServiceImp();
	}

	@Test
	void testIsValidPrimeNumberForTrue() {
		assertTrue(app.isValidPrimeNumber(3));
	}
	
	@Test
	void testIsValidPrimeNumberForNegative() {
		assertFalse(app.isValidPrimeNumber(-3));
	}
	
	@Test
	void testIsValidPrimeNumberForFalse() {
		assertFalse(app.isValidPrimeNumber(10));
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
