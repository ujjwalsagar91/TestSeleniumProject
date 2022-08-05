package com.test.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactoryAnnotation2 {

	   @DataProvider
	   public Object[][] message() {
	      return new Object [][]{{"Mayank" , 321}, {"Dileep", 282}};
	   }
	   
	   @Test (dataProvider="message")
	   public void PrintMsg(String name, Integer id)
	   {
	      System.out.println("Names are: "+name+" "+id);
	   }
	   @Test
	   public void PrintSuccessfullMessage()
	   {
	      System.out.println("Print the successful message");
	   }

}
