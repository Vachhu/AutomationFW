/**
 * 
 */
package com.txautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author vramdasbandekar
 *
 */
public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		File src= new File("./Config/Config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load Config file"+e.getMessage());
		}
	}	
	
	public String getDataFromConfig(String keyToSearch) {
		
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
		
	}
	
	public String getStagingUrl() {
		return pro.getProperty("qaURL");
		
	}
}
