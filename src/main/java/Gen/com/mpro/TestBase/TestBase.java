package Gen.com.mpro.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Gen.com.mpro.Excel.Read_Excel;

public class TestBase {

	public static WebDriver driver;

	public void init() throws IOException {
		selectBrowser("chrome", "https://www.tatacliq.com/login");

	}

	public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeinsec, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});

		return element;
	};

	public static void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static WebDriver selectBrowser(String browser, String Url) {
		if (browser.equalsIgnoreCase("firefox")) {

			
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.navigate().to(Url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return driver;
		} else if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.navigate().to(Url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.navigate().to(Url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
		return null;

	}

	public static void get_screenshot(String name) {
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "\\src\\main\\java\\Gen\\com\\mpro\\Screenshot\\";
		
		File dest = new File(reportDirectory+name+"_"+formater.format(calender.getTime())+".png");
		try {
			FileHandler.copy(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	public static void Get_Data_From_Xlsx_File(String Xlsx_FilePath) throws FileNotFoundException, IOException {
		Read_Excel excel = new Read_Excel(Xlsx_FilePath);
	}

}
