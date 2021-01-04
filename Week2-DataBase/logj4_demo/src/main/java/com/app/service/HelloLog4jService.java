package com.app.service;

import org.apache.log4j.Logger;



public class HelloLog4jService {
	private static Logger log = Logger.getLogger(HelloLog4jService.class);
	
	public void helloLog() {
		log.info("Hello from Log Service helloLog()");
		log.info("Bye Bye from Log Service helloLog()");
	}

}
