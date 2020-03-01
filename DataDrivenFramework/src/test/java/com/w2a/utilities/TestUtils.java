package com.w2a.utilities;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.w2a.base.TestBase;

public class TestUtils extends TestBase{

/*	public static String screenshotpath;
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		screenshotName = "sonu";
		screenshotpath = System.getProperty("user.dir")+"/src/test/test-output/html/"+screenshotName+System.currentTimeMillis()+".png";
		File destination = new File(screenshotpath);
		FileUtils.copyFile(src, destination);
	}
*/
	
	public static String getScreenshot() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/resources/Screenshots/sonu "+System.currentTimeMillis()+".png";
		File destination = new File(path);
		FileUtils.copyFile(src, destination);
		return path;
		
	}
	
}
