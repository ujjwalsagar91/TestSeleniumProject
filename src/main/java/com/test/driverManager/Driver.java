package com.test.driverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static void initDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			DriverManager.setDr(new ChromeDriver());
		}

		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			DriverManager.setDr(new FirefoxDriver());
		}
		DriverManager.getDr().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void quitDriver() {
		DriverManager.getDr().quit();
	}
}