/**
 * 
 */
package com.txautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author vramdasbandekar
 *
 */
public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
		    //driver = new ChromeDriver();
		    ChromeOptions ops = new ChromeOptions();
			  ops.addArguments("--remote-allow-origins=*");
			  ops.addArguments("disable-notifications");
			  driver=new ChromeDriver(ops);
			//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			//driver= new ChromeDriver();
		}
		else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver","./IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("We dont support this browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(appURL);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
