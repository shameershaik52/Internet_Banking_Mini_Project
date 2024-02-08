package com.tcs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcs.PageObject.LoginPageObject;

public class LoginTest_001 extends BaseClass{
  
	@Test
	public void loginTest() {
		
		
		logger.info("URL is opened");
		LoginPageObject lp=new LoginPageObject(driver);
		
		lp.setUserName(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{			
			Assert.assertTrue(true);
		logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
}
