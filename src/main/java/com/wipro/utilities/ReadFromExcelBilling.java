package com.wipro.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ReadFromExcelBilling {

	static XSSFWorkbook workBook;

	public static String[][] getData() {

		String fileName = "src\\test\\resources\\testdata\\BillingAddress.xlsx";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			workBook = new XSSFWorkbook(fis);
		} catch (IOException io) {
			io.printStackTrace();
		}
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();

		String[][] data = new String[1][7];

		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
			int cellCount = sheet.getRow(rowNo).getLastCellNum();
			for (int cellNo = 0; cellNo < cellCount; cellNo++) {
				data[rowNo - 1][cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			}
		}
		return data;

	}

}
