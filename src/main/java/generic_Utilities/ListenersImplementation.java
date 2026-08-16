package generic_Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;


public class ListenersImplementation extends BaseTest implements ITestListener{
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		ITestListener.super.onTestFailure(result);
		
		BaseTest.test.log(Status.FAIL, result.getName()+"is fail");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		String srcreenshot = ts.getScreenshotAs(OutputType.BASE64);
		BaseTest.test.addScreenCaptureFromBase64String(srcreenshot, result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ITestListener.super.onTestSuccess(result);
		
		BaseTest.test.log(Status.PASS, result.getName()+"is pass");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
		ITestListener.super.onTestSkipped(result);
		
		BaseTest.test.log(Status.SKIP, result.getName()+"is skipped");
	}

}
