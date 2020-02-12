package Gen.com.mpro.GRID;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid {

	public static void main(String[] args) throws Exception {
		 DesiredCapabilities cap=new DesiredCapabilities();
		 cap.setBrowserName("chrome");
		 cap.setPlatform(Platform.WINDOWS);
		 URL url = new URL("http://localhost:4444/wd/hub");
		  RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		  driver.get("https://github.com/SeleniumHQ/selenium/wiki/Grid2");
		  driver.manage().window().maximize();
		  System.out.println(driver.getTitle());
		  driver.close();
		 
	}

}
