package Gen.com.mpro.all_Functionsers;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Gen.com.mpro.Excel.Read_Excel;
import Gen.com.mpro.Page_Library.Page_Login;
import Gen.com.mpro.TestBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class all_Simple_Feature extends TestBase {
	// Page_Login p;

	@Test(enabled = false)
	public void checkBox() throws Exception {

		WebElement element = driver
				.findElement(By.xpath("//div[text()='Multiple Checkbox Demo']/following-sibling::div/div[1]/label"));
		int eleCount = driver
				.findElements(By.xpath("//div[text()='Multiple Checkbox Demo']/following-sibling::div/div")).size();
		System.out.println(eleCount);
		for (int i = 1; i <= eleCount; i++) {
			System.out.println(i);
			if (driver
					.findElement(By.xpath(
							"//div[text()='Multiple Checkbox Demo']/following-sibling::div/div[" + i + "]/*/input"))
					.isDisplayed())
				driver.findElement(By
						.xpath("//div[text()='Multiple Checkbox Demo']/following-sibling::div/div[" + i + "]/*/input"))
						.click();
			else
				System.out.println("not found");
		}
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println("LUNCHING BROWSER");
		// selectBrowser("chrome",
		// "https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

	}

	@AfterTest
	public void Quit() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(enabled = false)
	void dropDown() {
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		// WebElement element = driver.findElement(By.xpath("//*[contains
		// (text(),'Products')]/../select[1]"));

		Select sel = new Select(driver.findElement(By.xpath("//*[contains (text(),'Products')]/../select[1]")));

		List<WebElement> l = sel.getOptions();
		Iterator<WebElement> i = l.iterator();
		while (i.hasNext()) {
			WebElement webElement = (WebElement) i.next();
			System.out.println(webElement.getText());
			if (webElement.getText().equalsIgnoreCase("Iphone"))
				sel.selectByVisibleText("Iphone");
		}
	}

	@Test(enabled = true)
	void Dropdown_Dynamic() {
		driver.get("");
		String expValue = "";
		boolean flag = false;
		WebElement element = driver.findElement(By.xpath(""));
		Select sel = new Select(element);
		List<WebElement> l = sel.getOptions();
		ListIterator<WebElement> itr = l.listIterator();
		while (itr.hasNext()) {
			WebElement wb = itr.next();
			if(wb.getText().equalsIgnoreCase(expValue)) {
				sel.selectByVisibleText(expValue);
			}
		}

	}

	@Test(enabled = false)
	void dragAndDrop() throws InterruptedException {

		selectBrowser("firefox", "https://jqueryui.com/droppable/");
		Thread.sleep(2000);
		driver.switchTo();
		WebElement dragable = driver.findElement(By.id("draggable"));
		// WebElement dropable = driver.findElement(By.xpath("//div[@id='droppable']"));
		/*
		 * Actions action = new Actions(driver); Thread.sleep(3000);
		 * //action.clickAndHold(dragable).moveToElement(dropable).release().build().
		 * perform(); // action.dragAndDropBy(dragable, 140, 55).build().perform();
		 * action.dragAndDrop(dragable, dragable).build().perform();
		 * System.out.println("done"); Thread.sleep(3000);
		 */

	}

	@Test(enabled = false)
	void dragAndDropByRobotClass() throws InterruptedException, AWTException {

		selectBrowser("chrome", "https://www.maxsecureantivirus.com/AVPlus/index.htm");

		WebElement dragable = driver.findElement(
				By.xpath("//p[contains(text(),'Drag the W3Schools image into the rectangle.')]/../div[3]/img"));
		WebElement dropable = driver.findElement(
				By.xpath("//p[contains(text(),'Drag the W3Schools image into the rectangle.')]/../div[4]"));

		// Actions action = new Actions(driver);

		Robot robot = new Robot();

		while (dragable.isDisplayed()) {
			robot.delay(1000);
			robot.mouseWheel(1000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(1000);
			robot.mouseMove(140, 55);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			break;
		}
		/*
		 * Thread.sleep(1000);
		 * action.clickAndHold(dragable).moveToElement(dropable).release().build().
		 * perform(); action.dragAndDropBy(dragable, 140, 55).build().perform();
		 */
		System.out.println("done");
		Thread.sleep(10000);

	}

	@Test(enabled = false)
	void ProportyFile() throws InterruptedException, IOException {

		Properties prop = new Properties();
		File f = new File("C:\\Users\\sksah\\OneDrive\\Desktop\\pro_file.properties");
		FileReader reader = new FileReader(f);
		prop.load(reader);
		String output = prop.getProperty("data");
		System.out.println(output);

	}

	@Test(enabled = false)
	void scroll() throws InterruptedException {
		driver.get("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		// js.executeScript(script, args)
		Thread.sleep(1000);
	}

	@Test(enabled = false)
	void doubleClick() throws InterruptedException {
		selectBrowser("chrome", "http://demo.guru99.com/test/simple_context_menu.html");
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]")))
				.perform();
		Thread.sleep(100);
		action.contextClick(driver.findElement(By.xpath(""))); // Right Click

	}

	@Test(enabled = false)
	void rightClick() {
		selectBrowser("chrome", "http://demo.guru99.com/test/simple_context_menu.html");
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//span[contains(text(),'right click me')]"))).perform();

	}// Click Here

	@Test(enabled = false)
	void newWindowPopup() throws InterruptedException {
		selectBrowser("chrome", "http://demo.guru99.com/popup.php");
		String mainWindow = driver.getWindowHandle();
		System.out.println("main is	:" + mainWindow);
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Thread.sleep(1000);

		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> itr = allWindow.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			System.out.println("child is 	:" + childWindow);

			if (!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getWindowHandle());
				System.out.println("We are in child");
				// fluentWait(driver.findElement(By.xpath("//td[contains(text(),'Email
				// ID')]/following-sibling::td/input")), 10);
				driver.findElement(By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[5]/td[2]/input[1]"))
						.sendKeys("susujjdg@hga.dhai");
				AssertJUnit.assertEquals(true, false);
			}
		}
	}

	@Test(enabled = false)
	void Popup_Alert() throws InterruptedException {
		selectBrowser("chrome", "http://demo.guru99.com/test/delete_customer.php");

		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).submit();

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();

		// Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(5000);

		// Accepting alert
		alert.accept();
	}

	@Test(enabled = false)
	void Popup_Download() throws InterruptedException, AWTException {
		selectBrowser("firefox", "https://www.maxsecureantivirus.com/AVPlus/index.htm");
		driver.findElement(By.xpath("//a[contains(text(),'Download 64 bit Setup from Cloud')]")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);

		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		System.out.println("downloaded");
	}

	@Test(enabled = false)
	void Popup_Upload() throws InterruptedException, AWTException {

	}

	@Test(enabled = false)
	void splitString() {
		String data = "My Name is Sushanta";
		String[] split = data.split(" ");
		System.out.println(split[0] + "\t" + split[1] + "\t" + split[2] + "\t" + split[3]);

		for (int i = 0; i < 4; i++) {

			for (int j = split[i].length(); j >= 0; j++) {
				char[] try1 = split[i].toCharArray();
				System.out.println();

			}
		}
	}

	@Test(enabled = false)
	void mouseOver() throws InterruptedException {

		driver.get("google.com");
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("mhh"))).build().perform();

	}

	@Test(enabled = false)
	void proportiesFile() throws IOException {

		Properties prop = new Properties();
		File f = new File("C:\\Users\\sksah\\OneDrive\\Desktop\\pro_file.properties");
		FileReader reader = new FileReader(f);
		prop.load(reader);
		String output = prop.getProperty("data");
		System.out.println(output);

	}

}
