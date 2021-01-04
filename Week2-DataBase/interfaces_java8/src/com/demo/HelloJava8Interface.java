package com.demo;

public interface HelloJava8Interface {
	
	public static void hiStatic() {
		System.out.println("Hello from static method from interface");
	}
	
	default void hiDefault() {
		System.out.println("Hello from default method from interface");
	}

}
