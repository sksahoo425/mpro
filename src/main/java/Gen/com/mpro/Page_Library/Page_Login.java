package Gen.com.mpro.Page_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Gen.com.mpro.TestBase.TestBase;


public class Page_Login extends TestBase {
	@FindBy(xpath="")
	WebElement demo;
	@FindBy(xpath="//div[text()='Welcome back']/../div[2]//input[@placeholder='Email']")
	WebElement username;
	@FindBy(xpath="//div[text()='Welcome back']/../div[2]//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath="//div[text()='Welcome back']/../div[2]//span[text()='Sign in']/..")
	WebElement Signin_btn;
	@FindBy(xpath="//span[contains(text(),'Hello')]")
	WebElement hello;
	public Page_Login() {
		PageFactory.initElements(driver, this);
	}
	

	public void login(String UserName, String Password) {
		username.sendKeys(UserName);
		password.sendKeys(Password);
		Signin_btn.click();
		fluentWait(hello , 10);
	}

}
