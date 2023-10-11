/**
 * 
 */
package com.txautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.txautomation.pages.AppropriationPage;
import com.txautomation.pages.BaseClass;
import com.txautomation.pages.LoginPage;
import com.txautomation.utility.BrowserFactory;
import com.txautomation.utility.Helper;

/**
 * @author vramdasbandekar
 *
 */
public class AppropriationTestFlow  extends BaseClass{
	
	
	@Test
	public void appropriationTest()
	{
		logger=report.createTest("Create Appropriation Test");
		AppropriationPage appPage = PageFactory.initElements(driver, AppropriationPage.class);
		logger.info("starting application");
		appPage.appropriationTest(excel.getStringdata("Login", 0, 0),excel.getStringdata("Login", 0, 1));
		logger.pass("Test run successfully");
		appPage.createAppropriation();
		appPage.appropriationTest(excel.getStringdata("Login", 1, 0),excel.getStringdata("Login", 1, 1));
		appPage.approveAppropriation();
		Helper.captureScreenshots(driver);
	}
	
	
	

}
