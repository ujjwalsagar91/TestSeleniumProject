package com.test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindPriceTest {
	
	WebDriver driver = null;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cp = new ChromeOptions();
//		cp.addArguments("--headless");
		driver = new ChromeDriver(cp);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20");
		((RemoteWebDriver)driver).getSessionId();
	}
	
	
	@Test
	public void findPrice() {
		
		String price = getCurrentPrice("MacBook Air");
		System.out.println(price);
		
	}
	
	@Test
	public void findOption() {
		
		String options = optionList("Information");
		System.out.println(options);
		
	}

	public String getCurrentPrice(String productName) {
		
		String allPrices = driver.findElement(By.xpath("//a[text()='"+productName+"']/parent::h4/following-sibling::p[@class='price']")).getText();
		String[] allPriceArr = allPrices.split("\n");
		String[] currentPriceArr = allPriceArr[0].split("\\s");
		return currentPriceArr[0];
		
	}
	
	public String optionList(String area) {
		String options = driver.findElement(By.xpath("//*[@class='container']//h5[text()='"+area+"']/following-sibling::ul")).getText();
		return options;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
