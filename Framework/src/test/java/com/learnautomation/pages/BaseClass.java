package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;





import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.utils.BrowserFactory;
import com.learnautomation.utils.ConfigDataProvider;
import com.learnautomation.utils.ExcelDataProvider;
import com.learnautomation.utils.Helper;

public class BaseClass {

	//Global so we can access outside of the method
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;	// Use in LoginTestCRM. It will be responsible for all of the logging activities in the test
	
	
	@BeforeSuite
	public void SetupSuite()
	{
		//System.out.println("> entering BeforeSuite SetupSuite()");
		
		Reporter.log("@BeforeSuite - SetupSuite(): Setting up reports and Test is getting ready", true);
		
		//ExcelDataProvider excel = new ExcelDataProvider();
		excel  = new ExcelDataProvider();
		config = new ConfigDataProvider();	// This will call the constructor and the config file will get loaded
		
		// extentreports 4.0.0 (deprecated in 4.0.1)
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();	// create obj of ExtentReports
		report.attachReporter(extent);	// attach the report
		
		// now we must flush the report in @AfterMethod
		
		Reporter.log("@BeforeSuite - SetupSuite(): Setting up reports done and Test can be started", true);

	
	}
	
	@Parameters({"browser", "urlToBeTested"})
	@BeforeClass
	public void startup(String browser, String url) {
	//public void startup() {
	//System.out.println("> entering BeforeClass startup()");
	Reporter.log("@BeforeClass - Startup(): Trying to start Browser and getting application ready", true);

	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver = BrowserFactory.startApplication(driver, "Chrome", "http://freecrm.com");
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		driver = BrowserFactory.startApplication(driver, browser, url);
		//System.out.println("< exiting BeforeClass startup()");
		Reporter.log("@BeforeClass - Startup(): Browser and Application are up and running", true);

	}
	

	
	@AfterClass
	public void tearDown() {

	//System.out.println("> entering AfterClass teardown()");
		Reporter.log("@AfterClass - tearDown(): Test is about to end", true);

		// wait
		try {
			
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		report.flush();  // Flush method is used to erase any previous data on the report and create a new report.
		
		BrowserFactory.quitBrowser(driver);
		//System.out.println("< exiting AfterClass teardown()");
		Reporter.log("@AfterClass - tearDown():Test completed >> Reports generated", true);

	}
	
	@AfterMethod	// Will take a screenshot after every test case even if failure occurs
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("@AfterMethod - tearDownMethod(): starting", true);

		if (result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);
			//logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());  	//14:11 #5
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			try {
				logger.skip("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Reporter.log("@AfterMethod - tearDownMethod(): finished", true);

	}
	
}
