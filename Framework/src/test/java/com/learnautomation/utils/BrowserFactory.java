package com.learnautomation.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver ldriver, String browserName, String appURL) {

		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			ldriver = new ChromeDriver();
			
		}
		else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/gecko.exe");
			ldriver = new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			ldriver = new InternetExplorerDriver();
		}
		else {
			System.out.println("We do not support this browser.");
		}
		ldriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		ldriver.get(appURL);
		//ldriver.manage().window().maximize();
		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return ldriver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}


	
}