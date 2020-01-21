package com.w2a.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;


public class AddCustomerTest extends TestBase{
	
	@Test
	public void addCustomer() throws IOException {
		
		driver.findElement(By.xpath(OR.getProperty("addCustomer"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(getData(1,0));
		
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(getData(1,1));
		
		driver.findElement(By.xpath(OR.getProperty("postalcode"))).sendKeys(getData(1,2));
		
		//driver.findElement(By.xpath(OR.getProperty("submit"))).click();
		
		
	}
	


	
	
}
