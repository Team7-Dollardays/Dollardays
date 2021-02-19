package com.dollardays.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

public class MT {
	public static Logger APPLICATION_LOGS = Logger.getLogger(MT.class);

	public MT()
	{
		
		//Log file testing messages - will display in Selenium.logs file
		// public static Logger APPLICATION_LOGS = Logger.getLogger("dollardaysLogger"); - will print all log messages in Manuals.logs
		APPLICATION_LOGS.debug("MT is called.");
		APPLICATION_LOGS.info("this is information from MT Class.");
		APPLICATION_LOGS.error("this is error message from MT CLass.");
		APPLICATION_LOGS.fatal("Hi,This is fatal messsage");
		APPLICATION_LOGS.warn("this is Warning.");
	}
	
	@BeforeClass
	public void beforeClass() {
		
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("Before test-class. Thread id is: " + id);
	}

	@BeforeTest
	public void testMethodOne() {
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("Method is running with id" + id);
	}

	//@Test
	public void testMethodTwo() {
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("Executing test-method-two. Thread id is: " + id);
	}

	@AfterClass
	public void afterClass() {
		long id = Thread.currentThread().getId();
		APPLICATION_LOGS.info("After test-method-class. Thread id is: " + id);
	}
}
