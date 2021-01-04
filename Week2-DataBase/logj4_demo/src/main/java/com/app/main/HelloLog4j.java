package com.app.main;

import org.apache.log4j.Logger;

import com.app.service.HelloLog4jService;

public class HelloLog4j {

	private static Logger log = Logger.getLogger(HelloLog4j.class);
	
	public static void main(String[] args) {
		
		log.trace("Hello from trace");
		log.debug("Hello from debug");
		log.info("Hello from info");
		log.warn("Hello from warn");
		log.error("Hello from error");
		log.fatal("Hello from fatal");
		
		HelloLog4jService service = new HelloLog4jService();
		service.helloLog();
		

	}

}
