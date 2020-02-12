package Gen.com.mpro.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Gen.com.mpro.TestBase.TestBase;




public class Read_Excel extends TestBase {
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public Read_Excel(String Xlsx_FilePath) throws IOException, FileNotFoundException {

		fis = new FileInputStream(Xlsx_FilePath);
		wb = new XSSFWorkbook(fis);

	}

	public  String Get_Data(int sheet_index, int Row, int Coloum) {
		sheet = wb.getSheetAt(sheet_index);
		String data = sheet.getRow(Row).getCell(Coloum).getStringCellValue();
		return data;
	}

	public static int get_rowcount(int sheet_index) {
		int row = wb.getSheetAt(sheet_index).getLastRowNum();
		System.out.println("Getting get_rowcount as"+row);
		return row;

	}
	
	

}
