package jobs;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelInput {
	
  
		public static Object[][] getDataFromSheet(String fileName, String sheetName) throws IOException {
		
			FileInputStream fis = new FileInputStream(fileName); // Your .xlsx file
																// name along
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);  // get sheet name
		int rowCount= sheet.getPhysicalNumberOfRows(); // get the number of rows
		int colCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Row Count is: " + rowCount + " *** Column count is: " + colCount);
		
		
		Object[][] data = new Object[rowCount-1][colCount]; // declare Object array 2 dimensional
		
		DataFormatter df = new DataFormatter();
		
		for(int i=1;i<rowCount;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				XSSFCell cell = row.getCell(j);
				String value = df.formatCellValue(cell);
				data[i-1][j] = value;
			}
			
		}
		
		wb.close();
		fis.close();
		return data;	
	
	}

	
}
