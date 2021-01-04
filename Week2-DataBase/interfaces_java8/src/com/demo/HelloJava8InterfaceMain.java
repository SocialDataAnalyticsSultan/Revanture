package com.demo;

public class HelloJava8InterfaceMain implements HelloJava8Interface {

	public static void main(String[] args) {
		HelloJava8Interface.hiStatic();
		
		HelloJava8InterfaceMain hm = new HelloJava8InterfaceMain();
		hm.hiDefault();
		
	}

}
