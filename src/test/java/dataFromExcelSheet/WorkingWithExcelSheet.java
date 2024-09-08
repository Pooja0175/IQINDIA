package dataFromExcelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WorkingWithExcelSheet {
	@Test
	public void dataDrivenExcel() throws IOException {
		// excel file location
		String path="C:\\Users\\Sheetal\\OneDrive\\Pictures\\Desktop\\LoginID_Java.xlsx";
		
		// path sore in file
		File f=new File(path);
		
		// for read the file
		FileInputStream fis=new FileInputStream(f);
		
		// for take instance of file
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		// for take instance of excel file sheet
		XSSFSheet sh=wb.getSheet("Data");
		
		// count row and column from excel file
		int row=sh.getLastRowNum(); // count from 0 
		int row1=sh.getPhysicalNumberOfRows(); // count from 1 
		System.out.println("Row "+row);
		System.out.println("Row2 "+row1);
		int col=sh.getRow(0).getLastCellNum();
		System.out.println("Column "+col);
		
		// Retrieve data form excel sheet using loop
		for (int r=0;r<row;r++) {
			for(int c=0;c<col;c++) {
				String data=sh.getRow(r+1).getCell(c).getStringCellValue();
				System.out.print(data+" ");
			}
			System.out.println(" ");
		}
		
		
		
		fis.close();
		wb.close();
		
		
	}
	
}
