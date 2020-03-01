package com.w2a.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

import junit.framework.Assert;


public class BankManagerLoginTest extends TestBase{

	
	@Test
	public void LoginAsBankManager() throws InterruptedException, IOException {
		
		WebElement element = driver.findElement(By.xpath(OR.getProperty("bmlBtn")));
		
		Assert.assertTrue("Login not success",isElementPresent(element));
		
		element.click();
		
		log.debug("Login success");
		
		Thread.sleep(3000);
		
	}
	
	
}
