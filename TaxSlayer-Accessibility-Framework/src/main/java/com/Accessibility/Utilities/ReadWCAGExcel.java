package com.Accessibility.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWCAGExcel {

	String wcagContent = "";
	String contentType = "";
	ArrayList<String> wcagContentArray = new ArrayList<String>();
	

	public ArrayList<String> ReadExcelMethod(ArrayList<String> arr1) throws IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\TaxSlayer-Accessibility-Workspace\\qa-ui-accessibility-automation\\TaxSlayer-Accessibility-Framework\\src\\test\\resources\\WCAG Rules\\WCAG_Accessibility_Success_Criterias.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("WCAG Rules");

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		for (int i = 0; i < rowCount; i++) {

			int cellcount = sheet.getRow(i).getLastCellNum();

			for (int j = 0; j < cellcount; j++) {

				for (int k = 0; k < arr1.size(); k++) { // k=1(0,1)

					if (sheet.getRow(i).getCell(j).getStringCellValue().equals(arr1.get(k))) {

						wcagContent = wcagContent + sheet.getRow(i).getCell(j + 1).getStringCellValue() + " "
								+ sheet.getRow(i).getCell(j + 2).getStringCellValue() + " "
								+ sheet.getRow(i).getCell(j + 3).getStringCellValue() + ",";
						
						contentType = contentType + sheet.getRow(i).getCell(j + 4).getStringCellValue()+ " ";

					}
				}

			}
		}
		
		wcagContentArray.add(wcagContent);
		wcagContentArray.add(contentType);
		
		return wcagContentArray;
		
	}

}
