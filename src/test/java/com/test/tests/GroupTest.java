package com.test.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTest {
	
	WebDriver driver = null;
	
	@Test(groups= {"tests"}, priority=0)
	public void test1() {
		System.out.println("Test1");
	}

	@Test(groups= {"tests"}, priority=1)
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(groups= {"tests"}, priority=2)
	public void test3() {
		System.out.println("Test3");
	}
	
	@Test(groups= {"dev"}, priority=0)
	public void dev1() {
		System.out.println("Dev1");
	}
	
	@Test(groups= {"dev", "dev1"}, priority=1)
	public void dev2() {
		System.out.println("Dev2");
		boolean actual = true;
		boolean expected = false;
		Assert.assertEquals(actual, expected);
	}
	
	@Test(groups= {"dev"}, priority=2, dependsOnGroups = "dev1")
	public void dev3() {
		System.out.println("Dev3");
	}
	
}
