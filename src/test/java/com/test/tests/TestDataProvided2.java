package com.test.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvided2 {

	@Test(dataProvider = "getData")
	public void testDataProvider(String number1, String number2) {
		System.out.println("Number1 is " + number1 + ", " + "Number2 is " + number2);

	}


	@DataProvider
	public Object[][] getData() {

		return new Object[][] {
			{"one", "two"},
			{"three", "four"}
		};

	}
}
