package com.learnautomation.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Screenshot, alerts, frames, windows, sync issue, javascript executor
	// Add to @Test in LoginTestCRM()
	public static String captureScreenshot(WebDriver driver)  //Make static so this can be directly called
	{
		// Separate interface called: TakesScreenshot
		// Which has 1 method called: getScreenshotAs
		// Captures the screenshot as a FILE
		// Which will return the object as FILE type 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// Path to be used for screenshots.  16:34 #5
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM_"+getCurrentDateTime() + ".png";
		
		// Store this file/screenshot to a location
		// FileHandler.copy(src, new File("./Screenshots/Login.png"));   ** Surround with try/catch **
		
		try {
			//FileHandler.copy(src, new File("./Screenshots/Login.png"));
		//	FileHandler.copy(src, new File("./Screenshots/FreeCRM_" + getCurrentDateTime() + ".png"));  // can call because it is static in getCurrentDateTime()
			FileHandler.copy(src, new File(screenshotPath));  // 16:37 #5
			System.out.println("Screenshot captured");
		} 
		catch (IOException e) {
			
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return screenshotPath;
		
	}
	
	// Will return the timestamp in a standard format
	// Make static so it can be called in captureScreenshot()
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		// import java.util.Date; --> NOT JAVA.SQL.DATE
		Date currentDate = new Date();
		//customFormat.format(currentDate);
		return customFormat.format(currentDate);
	}
	
	
	
	public void handleFrames()
	{
		
	}
	
	
}
