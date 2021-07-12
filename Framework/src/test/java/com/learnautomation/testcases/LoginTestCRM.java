package com.learnautomation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utils.BrowserFactory;
import com.learnautomation.utils.ExcelDataProvider;
import com.learnautomation.utils.Helper;

public class LoginTestCRM extends BaseClass{

	
	//  ** Remove WebDriver reference and extend the BaseClass to every Class
	//WebDriver driver;

// ** Moved to Base Class.java **	
//	@BeforeClass
//	public void startup() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver = BrowserFactory.startApplication(driver, "Chrome", "http://freecrm.com");
//
//	}

// ** Moved to Base Class.java **	
//	@AfterClass
//	public void tearDown() {
//		// wait
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		BrowserFactory.quitBrowser(driver);
//
//	}

	
	@Test(priority=1)
	public void loginApp() throws InterruptedException {
		
		Reporter.log("loginApp(): Starting", true);
		//System.out.println("> entering loginApp()");
		
		//ExcelDataProvider excel = new ExcelDataProvider();  // MOVED to BaseClass
		//excel.getStringData("Login", 0, 0);	// move to loginPage.loginToCRM("dougbiggsstuff@gmail.com", "Biggs1234")
		
		// ** Moved to @Before Class
		// driver = BrowserFactory.startApplication(driver, "Chrome", "http://freecrm.com");
		System.out.println("Page Title: " +driver.getTitle());
		
		logger = report.createTest("Login to CRM");  	// returns ExtentTest object
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");
		

		// click Got It btn
		Thread.sleep(2000);
		System.out.println("clicking Got It button...");
		driver.findElement(By.xpath("//button[contains(text(),'Got It')]")).click();

		// click login btn
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		
		//loginPage.loginToCRM("dougbiggsstuff@gmail.com", "Biggs1234");
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));	// Use POI to setup row/col
		
		logger.pass("Login Success");
		
		// Screenshot from Helper Class
		Helper.captureScreenshot(driver);
		
		//LoginPage.loginToCRM(usernameApplication, passwordApplication);
		// ** Moved to @After Class
		// wait
		// Thread.sleep(5000); 
		// BrowserFactory.quitBrowser(driver);
		
		//System.out.println("< exiting loginApp()");
		Reporter.log("loginApp(): Finished", true);

	}

	
	//@Test(priority=2)
	public void loginApp2() throws InterruptedException {
	
		Reporter.log("loginApp2(): Starting", true);
		//System.out.println("> entering loginApp2()");
		
		logger = report.createTest("Login to CRM2");  	// returns ExtentTest object
		logger.fail("Login Failed");
		
		//System.out.println("< exiting loginApp2()");
		Reporter.log("loginApp2(): Finished", true);

	}

}