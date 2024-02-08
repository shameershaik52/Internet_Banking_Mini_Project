package com.tcs.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tcs.PageObject.LoginPageObject;
import com.tcs.utilities.XLLoginData;

import junit.framework.Assert;

public class LoginTest_DDT_002  extends BaseClass{

	@Test(dataProvider ="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		
		LoginPageObject lp=new LoginPageObject(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("user password provided");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		   Assert.assertTrue(false);
		   logger.warn("login failed");
		}
		else
		{
			 Assert.assertTrue(true);
			 logger.info("login Passed");
			 lp.clickLogout();
			 
			 Thread.sleep(3000);
			 
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String fileLocation="E:\\workspace\\Internet_Banking_MiniProject\\src\\test\\java\\com\\tcs\\testData\\LoginData.xlsx";
		//String fileLocation=System.getProperty("user.dir")+"/src/test/java/com/tcs/testData/LoginData.xlsx";
	   int rowsize=XLLoginData.getRowCount(fileLocation, "Sheet1");
	   int columnsize=XLLoginData.getCellCount(fileLocation, "Sheet1", 1);
	String[][] loginData=new String[rowsize][columnsize];
	for(int i=1;i<=rowsize;i++)
	{
		for(int j=0;j<columnsize;j++)
		{
		 loginData[i-1][j]=XLLoginData.getCellData(fileLocation, "Sheet1", i, j);
		}
	}
	return loginData;
	}
}
