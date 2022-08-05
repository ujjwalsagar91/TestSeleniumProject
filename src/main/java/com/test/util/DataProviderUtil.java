package com.test.util;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	
	@DataProvider(name="fetchData", parallel=true)
	public static Object[][] getData() throws IOException {
		Object[][] obj1 = ExcelReader.readExcel("C:\\Users\\sagaru\\eclipse-workspace\\TestProject\\testdata.xlsx", "Sheet1");
		return obj1;
	}
}
