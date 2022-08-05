package com.test.tests;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.test.driverManager.DriverManager;
import com.test.util.DataProviderUtil;

public class TestDataProvider extends BaseTest {

//	@BeforeMethod
//	@Parameters({"browser"})
//	public void initDriver(String browser) {
//		if(browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//	}
//
//	@Test(dataProvider = "fetchData", dataProviderClass = DataProviderUtil.class)
//	@Parameters({"browser"})
//	public void testLogin(String username, String password, String username1, String password1) {
//		driver.get("https://opensource-demo.orangehrmlive.com/");
//		driver.findElement(By.id("txtUsername")).sendKeys(username);
//		driver.findElement(By.id("txtPassword")).sendKeys(password);
//		driver.findElement(By.id("btnLogin")).click();
//
//	}
//
//	@AfterMethod 
//	public void quitDriver() {
//		driver.quit();
//	}

	@Test(dataProvider = "fetchData", dataProviderClass = DataProviderUtil.class)
	public void testLogin(String username, String password, String username1, String password1) throws InterruptedException {
		DriverManager.getDr().get("https://opensource-demo.orangehrmlive.com/");
		DriverManager.getDr().findElement(By.id("txtUsername")).sendKeys(username);
		DriverManager.getDr().findElement(By.id("txtPassword")).sendKeys(password);
		DriverManager.getDr().findElement(By.id("btnLogin")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDr();
		js.executeScript("window.open('https://www.google.com');");
		
		Thread.sleep(5000);

	}
}
