package com.tcs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver driver;
	public LoginPageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement loggoutBtn;
	
	public void setUserName(String uname) 
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pass) 
	{
		txtpassword.sendKeys(pass);
	}
	
	public void clickLogin() 
	{
		btnLogin.click();
	}
	public void clickLogout() {
		loggoutBtn.click();
	}
}
