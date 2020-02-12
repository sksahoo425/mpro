package Gen.com.mpro.TakeScreenShot_Example;

import org.testng.annotations.Test;

import Gen.com.mpro.TestBase.TestBase;

public class screemmanuallytest extends TestBase{
 
	@Test
	public void test() {
		selectBrowser("chrome", "https://www.google.co.in/");
		get_screenshot(driver.getTitle());
		driver.close();
		
	}
}
