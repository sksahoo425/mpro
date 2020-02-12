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

public class XL_By_normalTest_AllDataFromTable extends TestBase {

	@Test
	void test() {

		try {
			FileInputStream fis = new FileInputStream("C:/Users/sksah/OneDrive/Desktop/Login.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");

			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
			// System.out.println("row Count is : "+rowCount);

			for (int i = 0; i < rowCount; i++) {

				int colCount = sheet.getRow(i).getLastCellNum();
				// System.out.println("For "+i+" Row->coloum Count is : "+colCount);
				for (int j = 0; j < colCount; j++) {
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + "\t");

				}

				System.out.println();
			}

			
			  
			 
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
