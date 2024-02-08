package com.tcs.testcases;

import org.testng.annotations.Test;

import com.tcs.PageObject.AddCustomerPageObject;
import com.tcs.PageObject.LoginPageObject;

import junit.framework.Assert;

public class AddCustomerTest extends BaseClass{

	@Test
	public void addCust() throws InterruptedException 
	{
	
		LoginPageObject lp=new LoginPageObject(driver);
		lp.setUserName(username);
		logger.info("user id added");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickLogin();
		
		AddCustomerPageObject obj=new AddCustomerPageObject(driver);
		
		obj.clickNewCust();
		obj.setCustName("shaik");
		obj.setGender("male");
		obj.setDate("08","26","1999");
		
		Thread.sleep(2000);
		
		obj.setaddress("India");
		obj.setCity("nlr");
		obj.setState("ap");
		obj.setPin("5640043");
		obj.setMobile("9839984390");
		obj.setEmail(setRandomEmail());
		obj.setPassword("jasdjk");
		obj.clickSubmitBtn();
		logger.info("test started");
		
		Thread.sleep(2000);
		
		boolean status=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(status)
		{
			Assert.assertTrue(true);
		    logger.info("test passed");
		}
		else
		{
			logger.warn("test failed");
			captureScreen(driver, "addCust");
			Assert.assertTrue(false);
		}
}
	
	
}
