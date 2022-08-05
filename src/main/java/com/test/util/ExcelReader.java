package com.test.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] readExcel(String path, String sheetname) throws IOException {
		
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(sheetname);
		
		int row = sh.getLastRowNum();
		int col = sh.getRow(0).getLastCellNum();
		
		System.out.println(row);
		System.out.println(col);
		
		Object[][] data = data = new Object[row][col];
		
		for(int i=0 ; i<row ; i++) {
			for(int j = 0; j<col; j++) {
				data[i][j] = sh.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Object[][] obj1 = readExcel("C:\\Users\\sagaru\\eclipse-workspace\\TestProject\\testdata.xlsx", "Sheet1");
		
		for(int i=0; i<obj1.length; i++) {
			for(int j=0; j<obj1[i].length; j++) {
				System.out.print(obj1[i][j] + " ");
			}
			System.out.println();
		}
	}

}
