package com.app.service;

public class MyServices {

	public String sayHello(String name) {
		if (name != null)
			return "Hello " + name;
		else
			return null;
	}
}
