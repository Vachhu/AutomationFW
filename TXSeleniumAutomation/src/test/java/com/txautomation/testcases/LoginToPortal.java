/**
 * 
 */
package com.txautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.txautomation.pages.BaseClass;
import com.txautomation.pages.LoginPage;
import com.txautomation.utility.BrowserFactory;
import com.txautomation.utility.ExcelDataProvider;
import com.txautomation.utility.Helper;

/**
 * @author vramdasbandekar
 *
 */
public class LoginToPortal extends BaseClass{
	
	
	@Test
	public void loginApp()
	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToPortal(excel.getStringdata("Login", 0, 0),excel.getStringdata("Login", 0, 1));
		Helper.captureScreenshots(driver);
	}

}
