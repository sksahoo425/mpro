package Gen.com.mpro.Excel;

import java.io.IOException;

import org.testng.annotations.Test;

import Gen.com.mpro.TestBase.TestBase;

public class XL_By_ObjCreation extends TestBase{
	Read_Excel ex ;
	@Test
	void test1() {
		try {
			ex = new Read_Excel("C:/Users/sksah/OneDrive/Desktop/Login.xlsx");
			String dt1 = ex.Get_Data(0, 0, 0);
			String dt2 = ex.Get_Data(0, 0, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
