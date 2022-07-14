package com.test.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.test.driverManager.Driver;

public class BaseTest {

	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser) {
		Driver.initDriver(browser);
	}
	
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	
}
