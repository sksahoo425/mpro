package Gen.com.mpro.Excel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Gen.com.mpro.Excel.Read_Excel;
import Gen.com.mpro.Page_Library.Page_Login;
import Gen.com.mpro.TestBase.TestBase;

public class Xl_ByParametersTest extends TestBase {
	Page_Login p;
	Read_Excel exl;
	
	@Parameters({"FliePath","SheetIndex","RowIndex","ColumIndexforID","ColumIndexforPWD"})
	@Test
	public void Test_1(String FliePath, int SheetIndex, int RowIndex, int ColumIndexforID , int ColumIndexforPWD ) throws Exception {
		System.out.println(FliePath);
		p = new Page_Login();
		exl = new Read_Excel(FliePath);
		String username = exl.Get_Data(SheetIndex, RowIndex, ColumIndexforID);
		String password = exl.Get_Data(SheetIndex, RowIndex, ColumIndexforPWD);
		System.out.println(username+"\t"+password);
		p.login(username, password);
		
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.out.println("LUNCHING BROWSER********");
		selectBrowser("firefox", "https://www.tatacliq.com/login");
		// Thread.sleep(10000);
	}

	@AfterMethod
	public void Quit() {
		driver.quit();
	}

	
	
}
