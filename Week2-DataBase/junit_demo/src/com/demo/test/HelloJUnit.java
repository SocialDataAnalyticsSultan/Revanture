package com.demo.test;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class HelloJUnit {
	
	@BeforeAll
	public static void helloBeforeAll() {
		System.out.println("Hello Before Class");
	}
	
	
	
	@BeforeEach
	public void helloBeforeEach() {
		System.out.println("Hello from BeforeEach");
	}
	
	@Test
	public void testHello1() {
		System.out.println("Hello from Hello1");
	}
	
	@Test
	public void testHello2() {
		System.out.println("Hello from Hello2");
	}
	
	@AfterEach
	public void helloAfterEach() {
		System.out.println("Hello from AfterEach");
	}
	
	@AfterAll
	public static void helloAfterAll() {
		System.out.println("Hello Before Class");
	}
	


}
