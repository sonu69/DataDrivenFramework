package com.w2a.testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

import junit.framework.Assert;


public class LoginTest extends TestBase{

	
	@Test
	public void LoginAsBankManager() throws InterruptedException {
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue("Login not success",isElementPresent(By.xpath(OR.getProperty("addCustomer"))));
		
		log.debug("Login success");
		
		
		
	}
	
	
}
