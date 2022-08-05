package com.test.tests;

import org.testng.annotations.Factory;

public class FactoryAnnotationTest {

	@Factory
	public Object[] factorymethod()
	{
		return new Object[]{new FactoryAnnotation2(), new FactoryAnnotation2()};
	}
}
