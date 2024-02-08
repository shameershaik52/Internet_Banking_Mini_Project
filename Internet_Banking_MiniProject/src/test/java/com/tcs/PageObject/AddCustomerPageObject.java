package com.tcs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPageObject {
	
	WebDriver driver;
	
	public AddCustomerPageObject(WebDriver d){
		driver=d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addCustLink;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement txtCustName;
	
	@FindBy(how=How.XPATH,using="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement selectGender;
	
	@FindBy(how=How.NAME, using="dob")
	@CacheLookup
	WebElement selectDate;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtMobile;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement txtPass;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
	@CacheLookup
	WebElement clickSubmit;
	
	public void clickNewCust() 
	{
	   addCustLink.click();
	   
	 
	}
	public void setCustName(String cname) 
	{
		txtCustName.sendKeys(cname);
	}
	
	public void setGender(String gender) 
	{
		selectGender.click();
	}
	public void setDate(String mm,String dd,String yy) 
	{
		selectDate.sendKeys(mm);
		selectDate.sendKeys(dd);
		selectDate.sendKeys(yy);
	}
	
	public void setaddress(String addr) 
	{
		txtAddress.sendKeys(addr);
	}
	public void setCity(String city) 
	{
		txtcity.sendKeys(city);
	}
	
	public void setState(String state) 
	{
		txtState.sendKeys(state);
	}
	public void setPin(String pincode) 
	{
		txtPin.sendKeys(pincode);
	}
	
	public void setMobile(String mobile) 
	{
		txtMobile.sendKeys(mobile);
	}
	public void setEmail(String mail) 
	{
		txtEmail.sendKeys(mail);
	}
	
	public void setPassword(String pass) 
	{
		txtPass.sendKeys(pass);
	}
	public void clickSubmitBtn() 
	{
		clickSubmit.click();
	}
}
