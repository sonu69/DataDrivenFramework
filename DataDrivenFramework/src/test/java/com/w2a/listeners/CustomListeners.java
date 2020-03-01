package com.w2a.listeners;


import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtils;


public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getMethod());
		System.out.println(result.getName());
		System.out.println(result.getTestClass());
		Reporter.log(result.getName());
		Reporter.log(result.getTestName());

	}

	public void onTestSuccess(ITestResult result) {
		try {
			test = extent.createTest(result.getName());
			String temp = TestUtils.getScreenshot();
			test.pass("Pass", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
/*		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("Success testcase");
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Reporter.log("<a target=\"_blank\" href="+TestUtils.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtils.screenshotName+"><img src ="+TestUtils.screenshotName+" height =200 width = 200 ></a>");
*/				
/*		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("Pass testcase");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Sonu\\Downloads\\Images.png\">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"C:\\Users\\Sonu\\Downloads\\Images.png\"><img src = \"C:\\Users\\Sonu\\Downloads\\Images.png\" height =200 width = 200 ></a>");
*/		
		
	}

	public void onTestFailure(ITestResult result) {
		try {
			String temp = TestUtils.getScreenshot();
			test.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	public void onTestSkipped(ITestResult result) {
		 
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {

		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
