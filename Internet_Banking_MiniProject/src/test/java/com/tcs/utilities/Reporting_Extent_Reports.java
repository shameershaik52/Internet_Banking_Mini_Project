package com.tcs.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting_Extent_Reports extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    String repName="Test-report-"+timestamp+".html";
	
	    //specify location to generate reports
	    htmlReporter=new ExtentHtmlReporter(System.getProperty
	    		("user.dir")+"/test-output/"+repName);
	    htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	    extent=new ExtentReports();
	    
	    extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "localHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester Name", "shameer");
		extent.setSystemInfo("Browser", "chrome");
		
		
		htmlReporter.config().setDocumentTitle("Internet_Banking_MiniProject");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr )
	{ 
		//create my new entry in the report
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}
	public void onTestFailure(ITestResult tr )
	{ 
		//create my new entry in the report
				logger=extent.createTest(tr.getName());
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
     String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
     File file=new File(screenshotpath);
     
     if(file.exists())
     {
    	 try {
			logger.fail("Screenshot is below : "+logger.addScreenCaptureFromPath(screenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	}
	
	public void onTestSkipped(ITestResult tr )
	{ 
		//create my new entry in the report
		logger=extent.createTest(tr.getName());
	logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
     
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
}


	
	
	
	
	