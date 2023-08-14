package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
	public static String getStringData(int a, int b) throws IOException {
		f = new FileInputStream("/Users/smathew/eclipse-workspace/OpenMRS-Healthcare/com.healthcare/src/test/resources/excel.xlsx");  //set file path
		w = new XSSFWorkbook(f);  // excel is in a workbook and getting excel from workbook
		sh = w.getSheet("sheet1");  // getting sheet
		Row r = sh.getRow(a);  
		Cell c = r.getCell(b);
		return c.getStringCellValue();
		
	}
	public static String getIntegerData(int a, int b) throws IOException {
		f = new FileInputStream("/Users/smathew/eclipse-workspace/OpenMRS-Healthcare/com.healthcare/src/test/resources/excel.xlsx");
		w = new XSSFWorkbook(f);
		sh = w.getSheet("sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		int x = (int) c.getNumericCellValue();
		return String.valueOf(x); // integer value is type-casting to string
	}

}
