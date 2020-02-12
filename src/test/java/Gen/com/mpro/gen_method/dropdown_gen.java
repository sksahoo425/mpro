package Gen.com.mpro.gen_method;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Gen.com.mpro.TestBase.TestBase;

public class dropdown_gen extends TestBase {
	String exp_result = "Sunday";

	@Test
	public void run() throws InterruptedException {
		selectBrowser("chrome", "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		WebElement d = driver.findElement(By.xpath("//select[@id='select-demo']"));
		Select sel = new Select(d);
		List<WebElement> act_value = sel.getOptions();
		System.out.println(act_value.size());
		for (WebElement ele : act_value) {
			boolean match = false;

			if (ele.getText().equals(exp_result)) {
				System.out.println("match");
				ele.click();
			} else {
				System.out.println("not match");
			}
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
