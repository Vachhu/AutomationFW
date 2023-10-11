/**
 * 
 */
package com.txautomation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.txautomation.utility.BrowserFactory;
import com.txautomation.utility.ConfigDataProvider;
import com.txautomation.utility.ExcelDataProvider;
import com.txautomation.utility.Helper;

/**
 * @author vramdasbandekar
 *
 */
public class BaseClass {
	
    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports report;
    public ExtentTest logger;
    
    @BeforeSuite
    public void setUpSuite() {
    	
    	Reporter.log("setting up reports and test is running",true);
    	excel= new ExcelDataProvider();
    	config= new ConfigDataProvider();
    	
    	ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/StateOfTexas_"+ Helper.getCurrentDateTime() +".html"));
    	report= new ExtentReports();
    	report.attachReporter(extent);
    }
    
	@BeforeClass
	public void setup() {
		Reporter.log("setting up browser and url",true);
		driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getStagingUrl());
		Reporter.log("Application is up and running",true);
	}
	
	@AfterClass
	public void teardown() {
		Reporter.log("quitting the browser",true);
		BrowserFactory.quitBrowser(driver);
	}
		
	@AfterMethod	
	public void tearDownMethod(ITestResult result){
		
		Reporter.log("Test is about to end",true);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshots(driver);
			logger.fail("Test failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		report.flush();
		Reporter.log("Tests completed and reports generated",true);
	}

}
