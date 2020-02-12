package Gen.com.mpro.naukri;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Gen.com.mpro.Page_Library.Naukri_all;
import Gen.com.mpro.TestBase.TestBase;

public class naukriUpdate extends TestBase {

	@Test
	public static void m1() throws Exception {

		while (true) {// formater.format(cal.getTime()).matches("19_15")

			selectBrowser("chrome", "https://www.naukri.com/nlogin/login");
			Naukri_all naukri = new Naukri_all(driver);
			naukri.getCurrentTime();
			naukri.Naukri_login();
			naukri.mouseOverMyNaukri();
			naukri.clickOnEditProfileBtn();
			naukri.resumeHeadlineContains();

			Thread.sleep(15000);
			driver.quit();
			Thread.sleep(1000 * 60 * 60 * 2);
			System.out.println("new chrome will open in 1 hr ");
			//break;

		}

	}

}
