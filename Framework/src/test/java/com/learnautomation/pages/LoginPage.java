package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		// ldriver will come from the main testcase. so whatever driver reference that 
		// we pass from the main tc will be stored into this driver.
		this.driver = ldriver;
	}
	
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]") WebElement loginBtn;
//	@FindBy(xpath="//button[contains(text(),'Login')]") WebElement loginBtn;


	public void loginToCRM(String usernameApplication, String passwordApplication) {
	
		Reporter.log("loginToCRM(): Starting", true);

		//System.out.println("> entering loginToCRM()");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.uname.sendKeys(usernameApplication);
		this.pass.sendKeys(passwordApplication);
		this.loginBtn.click();
		
		//System.out.println("< exiting loginToCRM()");
		Reporter.log("loginToCRM(): Finished", true);

	}
	
}
