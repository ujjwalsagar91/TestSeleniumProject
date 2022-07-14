package com.test.tests;

import org.testng.annotations.Test;

public class TestNGTest {
	
	
	@Test
	public void test1() {
		System.out.println("Test1");
		int n = 1/0;
	}

	
	@Test(enabled=false, alwaysRun=true, dependsOnMethods = "test1")
	public void test2() {
		System.out.println("Test2");
	}
}
