package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWithoutFramework {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\work\\seleniumBrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.espn.com");
		driver.manage().window().maximize();
	}

}
