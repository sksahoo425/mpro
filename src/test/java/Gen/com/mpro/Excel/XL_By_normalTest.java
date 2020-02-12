package Gen.com.mpro.Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Gen.com.mpro.TestBase.TestBase;

public class XL_By_normalTest extends TestBase {

	@BeforeTest
	void lunchBrowser (){
		selectBrowser("chrome", "https://www.tatacliq.com/login");
	}
	@Test
	void test() {
		
		try {
			FileInputStream fis = new FileInputStream("C:/Users/sksah/OneDrive/Desktop/Login.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			String username = sheet.getRow(0).getCell(0).getStringCellValue();
			String password = sheet.getRow(0).getCell(1).getStringCellValue();
			System.out.println(username+"\t"+password);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	@AfterTest
	void close() {
		driver.close();
	}
	
	
}
