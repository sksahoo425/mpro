package Gen.com.mpro.Excel;

import java.io.File;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class ExcelWriter {
	
	static int newflog =0;
	static XSSFWorkbook wwb;
	static Sheet sheet;
	static File filepath;
	
	public static void generatelocaters(String tag , WebElement element) {
		
		StringBuilder placeHolder = new StringBuilder();
		StringBuilder id = new StringBuilder();
		StringBuilder name = new StringBuilder();
		StringBuilder classname = new StringBuilder();
		StringBuilder fieldvalue = new StringBuilder();
		
		
		placeHolder.append(element.getAttribute("placeholder"));
		id.append(element.getAttribute("id"));
		name.append(element.getAttribute("name"));
		classname.append(element.getAttribute("class"));
		System.out.println("Entered Fetching Select Objects");
		//String xpath = xpathGenerator(element, tag);
		
		
	}
	
	
	

}
