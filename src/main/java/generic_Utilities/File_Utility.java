package generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utility {
	
	public static String getPropertyData(String key) {
		
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream("./src/main/resources/commonData.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return property.getProperty(key);
	}
	
	public static String getExcelData(String sheet,int row,int cell) {
		
		FileInputStream fis = null;
		Workbook book = null;
		
		try {
			fis=new FileInputStream("./src/test/resources/Book1.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book.getSheet(sheet).getRow(row).getCell(cell).toString();
	}
	public static String[][] getExcelData(String sheetname) {
		
		FileInputStream fis=null;
		Workbook book=null;
		try {
			fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Sheet sheet = book.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data=new String[rowCount-1][cellCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

}
