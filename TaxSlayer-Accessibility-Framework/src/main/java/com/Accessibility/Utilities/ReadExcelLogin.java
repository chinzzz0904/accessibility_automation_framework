package com.Accessibility.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelLogin {

	public ArrayList<String> ReadExcelLoginMethod(String userType) throws IOException {

		String username = "";

		String password = "";
		
		FileInputStream fis = new FileInputStream(
				"D:\\TaxSlayer-Accessibility-Workspace\\qa-ui-accessibility-automation\\TaxSlayer-Accessibility-Framework\\src\\test\\resources\\Login Data\\LoginData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		ArrayList<String> credentials = new ArrayList<String>();

		XSSFSheet sheet = wb.getSheet("Login Data");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		for (int i = 0; i < rowCount; i++) {

			int cellcount = sheet.getRow(i).getLastCellNum();

			for (int j = 0; j < cellcount; j++) {

				if (sheet.getRow(i).getCell(j).getStringCellValue().equals(userType)) {

					username = sheet.getRow(i).getCell(j + 1).getStringCellValue();

					password = sheet.getRow(i).getCell(j + 2).getStringCellValue();

				}

			}

		}

		credentials.add(username);

		credentials.add(password);

		return credentials;

	}
}
