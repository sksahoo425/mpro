package Gen.com.mpro.Page_Library;

import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Gen.com.mpro.TestBase.TestBase;

public class Naukri_all extends TestBase {

	@FindBy(xpath = "//input[@id='usernameField']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@id='passwordField']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitLogin;

	@FindBy(xpath = "//div[contains(text(),'My Naukri')]")
	WebElement MyNaukrimouseOverbtn;

	@FindBy(xpath = "//a[@title='Edit Profile']")
	WebElement editprofilebtn;
	@FindBy(xpath = "//span[@class='text'][contains(text(),'Resume Headline')]")
	WebElement QuickLinkResumeHead;
	@FindBy(xpath = "//span[@class='widgetTitle'][contains(text(),'Resume Headline')]/../../div[2]/div/div")
	WebElement resumeHeadlineContains;

	@FindBy(xpath = "//span[@class='widgetTitle'][contains(text(),'Resume Headline')]/../../div[1]/span[2]")
	WebElement resumeHeadlineEditBtn;
	
	@FindBy(xpath = "//textarea[@id='resumeHeadlineTxt']")
	WebElement resumeHeadlineEditbox; 
	
	@FindBy(xpath = "//form[@name='resumeHeadlineForm']/div//button")
	WebElement resumeHeadsavebtn;
	

	public Naukri_all(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Naukri_login() {
		emailAddress.sendKeys("sksahoo.425@gmail.com");
		password.sendKeys("S9090578367");
		submitLogin.click();

	}

	public void getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
		System.out.println(formater.format(cal.getTime()));
	}

	public void mouseOverMyNaukri() {
		fluentWait(MyNaukrimouseOverbtn, 5000);
		Actions actions = new Actions(driver);
		actions.moveToElement(MyNaukrimouseOverbtn).perform();
	}

	public void clickOnEditProfileBtn() {
		editprofilebtn.click();
	}

	public void resumeHeadlineContains() throws InterruptedException {

		System.out.println(resumeHeadlineContains.getText());

		QuickLinkResumeHead.click();
		Thread.sleep(100);

		System.out.println("......vv...");
		resumeHeadlineEditBtn.click();
		Thread.sleep(1000);
		if (resumeHeadlineEditbox.getText().contains("Experience in Selenium Web Driver with different Framework components using CoreJava .")) {
			resumeHeadlineEditbox.clear();
			resumeHeadlineEditbox.sendKeys(
					"Having 3 Years of experience as a software test engineer. Having experience on API Testing, Selenium WebDriver and Manual Testing. Experience in Selenium Web Driver with different Framework components using CoreJava .");
			resumeHeadsavebtn.click();
			
		}else if (resumeHeadlineEditbox.getText().contains("Experience in Selenium Web Driver with different Framework components using CoreJava.")) {
			resumeHeadlineEditbox.clear();
			resumeHeadlineEditbox.sendKeys(
					"Having 3 Years of experience as a software test engineer. Having experience on API Testing, Selenium WebDriver and Manual Testing. Experience in Selenium Web Driver with different Framework components using CoreJava  .");
			resumeHeadsavebtn.click();
			
		} else {
			System.out.println("Something wrong happen plz check resume Headlines ");

		}

	}

}
