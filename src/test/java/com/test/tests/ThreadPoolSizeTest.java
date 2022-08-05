package com.test.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThreadPoolSizeTest {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void setDriver(WebDriver driverref) {
		driver.set(driverref);
	}

	@Test(invocationCount = 6, threadPoolSize = 3)
	public void launchChrome() {

		WebDriverManager.chromedriver().setup();
		setDriver(new ChromeDriver());
		getDriver().get("https://www.google.com");
		getDriver().quit();

	}

	@Test(invocationCount = 6, threadPoolSize = 3, enabled=false)
	public void quitChrome() {

		getDriver().quit();

	}

}
