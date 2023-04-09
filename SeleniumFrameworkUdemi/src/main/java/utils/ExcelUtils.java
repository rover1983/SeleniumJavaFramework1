package utils;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	XSSFWorkbook excelBook;
	XSSFSheet sheet;
	String pathOfProject = System.getProperty("user.dir");	
	String sheetName;
	
	
	// Constructor
	public ExcelUtils(String excelPath, String sheetName) {	
		this.sheetName=sheetName;
		try {
			excelBook = new XSSFWorkbook(pathOfProject+excelPath);
			sheet = excelBook.getSheet(sheetName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	public int getRowCount() {
		int numberOfRows=-1;
		try {			
			numberOfRows = sheet.getPhysicalNumberOfRows();
			System.out.println("numberOfRows "+numberOfRows);
			
		}catch(Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println(exc.getCause());			
			exc.printStackTrace();
		}
		return numberOfRows;
	}
	
	public int getColumnCount() {	
		int numberOfColumns = -1;
		try {			
			numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("numberOfColumns "+numberOfColumns);
			
		}catch(Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println(exc.getCause());			
			exc.printStackTrace();
		}		
		return numberOfColumns;
	}
	
	public String getCellData(int rowNumber, int cellNumber) {	
		String cellData="*";
		try {				
			sheet = excelBook.getSheet(sheetName);
			cellData = sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
			
		}catch(Exception exc) {
			System.out.println(exc.getMessage());
			System.out.println(exc.getCause());			
			exc.printStackTrace();
		}	
		return cellData;
	}

}
