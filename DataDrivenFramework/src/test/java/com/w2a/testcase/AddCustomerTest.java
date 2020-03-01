package com.w2a.testcase;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;


public class AddCustomerTest extends TestBase{
	
	@Test
	public void addCustomer() throws IOException, InterruptedException {
		
		driver.findElement(By.xpath(OR.getProperty("addCustomer"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(getData(1,0));
		
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(getData(1,1));
		
		driver.findElement(By.xpath(OR.getProperty("postalcode"))).sendKeys(getData(1,2));
		
		driver.findElement(By.xpath(OR.getProperty("submit"))).click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alt = driver.switchTo().alert();
		
		String alt_text = alt.getText();
		
		Assert.assertTrue(alt_text.contains("Customer added successfully with customer id"),"Customer not added");
		
		Thread.sleep(3000);
		
		alt.accept();
		
		Reporter.log("Customer added successfully Reporter");
		
		log.debug("Customer added successfully from log");
		
		
	}
	


	
	
}
