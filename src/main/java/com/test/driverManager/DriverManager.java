package com.test.driverManager;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDr() {
		return dr.get();
	}

	public static void setDr(WebDriver drref) {
		dr.set(drref);
	}
	
	public static void unload() {
		dr.remove();
	}

}
