package Gen.com.mpro.TakeScreenShot_Example;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Gen.com.mpro.TestBase.TestBase;

public class screenshotAotoFailTest extends TestBase {

  @Test
  public void testTest() {
	  selectBrowser("chrome", "https://www.google.co.in/");
		get_screenshot(driver.getTitle());
		assertEquals(true, false);
		driver.close();
		
  }
}
