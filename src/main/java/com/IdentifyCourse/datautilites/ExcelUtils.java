package com.IdentifyCourse.datautilites;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static String getCellValue(String filePath, String sheetName, int row, int col)
	{
		Workbook workbook;
		try
		{
			File file = new File(filePath+"\\resources\\CourseData.xlsx");
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			Cell cell = workbook.getSheet(sheetName).getRow(row).getCell(col);
			return cell.getStringCellValue();
		}
		catch (Exception e)
		{
			return "Excel File Not Found";
		}
	}

}