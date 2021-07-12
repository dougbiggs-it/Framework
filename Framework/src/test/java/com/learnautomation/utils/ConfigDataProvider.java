package com.learnautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;  // Declare a Global var
	
	// Loading the Configuration file
	public ConfigDataProvider()
	{
		File src = new File("./Config/Config.properties");
		
		//Surround all 3 lines with a try/catch
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();	// Create object
			pro.load(fis);
		} 
		catch (Exception e) {
			
			System.out.print("No able to load Config file >>"+e.getMessage());
			
		}
		
	}
	
	// Method to take the key and return the same key
	public String getDataFromConfig(String KeyToSearch)
	{
		return pro.getProperty(KeyToSearch);
	}
	
	// Key value pairs in Config.properties file
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL()
	{
		return pro.getProperty("qaURL");
	}
	
	
}
