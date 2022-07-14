package com.test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.driverManager.DriverManager;

public class WorldOMeter extends BaseTest {
	
	@Test
	public void worldOMeterTest() {
		DriverManager.getDr().get("https://www.worldometers.info/world-population/");
		
		WebElement population = DriverManager.getDr().findElement(By.xpath("//span[@class='rts-counter' and @rel='current_population']"));
		System.out.println(population.getText());
		DriverManager.getDr().quit();
	}

}
