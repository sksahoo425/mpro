package Gen.com.mpro.Excel;

import org.testng.annotations.Test;

import Gen.com.mpro.Excel.Read_Excel;
import Gen.com.mpro.Page_Library.Page_Login;
import Gen.com.mpro.TestBase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class XL_By_DataProvider extends TestBase {
	Page_Login p;

	@Test(dataProvider = "Loaddata")
	public void Test_1(String username, String password) throws Exception {
		p = new Page_Login();
		p.login(username, password);
		get_screenshot("login_with");
		Thread.sleep(5000);
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.out.println("LUNCHING BROWSER");
		selectBrowser("chrome", "https://www.tatacliq.com/login");
		// Thread.sleep(10000);
	}

	@AfterMethod
	public void Quit() {
		driver.quit();
	}

	@DataProvider(name = "Loaddata")
	Object[][] takeData() throws Exception {
		Read_Excel re = new Read_Excel("C:/Users/sksah/OneDrive/Desktop/Login.xlsx");
		int row = Read_Excel.get_rowcount(0);
		Object[][] data = new Object[row+1][2];
		for (int i = 0; i < row + 1; i++) {
			
			data[i][0] = re.Get_Data(0, row, 0);
			data[i][1] = re.Get_Data(0, row, 1);
			/*for(Object[] d:data) {
				System.out.println(d);
			}*/
			}
		

	return data;
}}
