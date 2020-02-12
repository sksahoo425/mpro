package Gen.com.mpro.CustomListener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Gen.com.mpro.TestBase.TestBase;

public class Listener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodname=result.getName();
		if(!result.isSuccess()) {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportdirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"\\src\\main\\java\\Gen\\com\\mpro\\ScreenshotonFailure\\";
				File dest = new File((String)reportdirectory+""+methodname+"_"+format.format(calender.getTime())+".png");
				FileHandler.copy(src, dest);
				System.out.println("<a href="+dest.getAbsolutePath()+"><img src'"+dest.getAbsolutePath()+"'hight='100' width = '100'/></a>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
