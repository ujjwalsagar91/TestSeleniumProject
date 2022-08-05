package com.test.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorTest {
	
	@Test
	public void findListOfComponents() throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.location = 'https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20'");
		
		WebElement components = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(text(),'Component')]"));
		
		js.executeScript("arguments[0].click();", components);
		Thread.sleep(5);
		js.executeScript("window.scrollBy(0,1000);");
		Thread.sleep(5);
		WebElement searchTxtbox = driver.findElement(By.xpath("//div[@id='search']/input"));
		
		js.executeScript("arguments[0].value='Laptop';", searchTxtbox);
		
		Thread.sleep(10);
		
		String destFile = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		System.out.println(destFile);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "//src//test//resources//"+destFile+".png"));
	
		Thread.sleep(10);
		
		driver.quit();
		
	}

}
