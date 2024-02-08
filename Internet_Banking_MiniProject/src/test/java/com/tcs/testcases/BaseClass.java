package com.tcs.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.tcs.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readConfig=new ReadConfig();
	
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger; 
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
	  driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			  driver=new FirefoxDriver();
		}
		
		else if(br.equals("edge"))
		{
			 System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
             driver = new EdgeDriver();
		}
	  logger= Logger.getLogger("ebanking");
	  PropertyConfigurator.configure("log4j.properties");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseURL);
	  driver.manage().window().maximize();
	}
  
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+
				"/Screenshots/"+tname+".png");
	
	try {
		FileUtils.copyFile(source, target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println(" screen shot taken ");
	}
	
String setRandomEmail() {
		
		String random= RandomStringUtils.randomAlphabetic(6);
	    return random+"@gmail.com";
	}
	
}



