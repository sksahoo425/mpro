package Gen.com.mpro.GRID;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid_Cross_Browser_Test {

	/*
	 * java -jar -Dwebdriver.firefox.driver=
	 * "E:\maven\work_space\com.mpro\drivers\geckodriver.exe"
	 * C:\Users\sksah\Downloads\selenium-server-standalone-3.141.59.jar -role node
	 * -hub "http://localhost:4444/grid/register/" (For Node Grid Cmd)
	 */
	// java -jar C:\Users\sksah\Downloads\selenium-server-standalone-3.141.59.jar
	// -role hub (for hub Grid CMD)
	
	@Test
	@Parameters("Browser")
	public void ptest(String Browser) throws MalformedURLException {
		//String bname = "chrome";
		DesiredCapabilities cap = null;
		if (Browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			System.out.println("......FDONE....");
		} else if (Browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		} else if (Browser.equalsIgnoreCase("ie")) {
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("ie");
			cap.setPlatform(Platform.WINDOWS);
		}
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("https://github.com/SeleniumHQ/selenium/wiki/Grid2");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.close();

	}

}
