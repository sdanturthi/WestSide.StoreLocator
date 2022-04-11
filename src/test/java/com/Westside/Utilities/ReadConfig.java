package com.Westside.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	String currentDirectoryPath = System.getProperty("user.dir");
	String configurationPath =  currentDirectoryPath+"/Configuration/Config.properties";
	Properties pro;
	
	public ReadConfig() {
		
		FileInputStream fis;

		try {
			File file = new File(configurationPath);
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage().toString());
		}		
	}
	
	public String getWestSideHomePageUrl() {
		String westSideHomePageUrl = pro.getProperty("url");
		return westSideHomePageUrl;
	}
	
	public String getChromeDriverPath() {
		String chromeDriverPath = pro.getProperty("chromeDriverPath");
		return chromeDriverPath;
	}
	
}
