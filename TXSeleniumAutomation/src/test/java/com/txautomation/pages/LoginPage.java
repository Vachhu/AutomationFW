/**
 * 
 */
package com.txautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author vramdasbandekar
 *
 */
public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//*[@id=\"navbar-inverse-collapse\"]/div/div/a") WebElement loginLink;
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(id="//*[@id=\"recaptcha-anchor\"]/div[1]") WebElement captchaCheckbox;
	
	@FindBy(id="login") WebElement loginButton;
	
	public void loginToPortal(String applicationUsername, String applicationPassword) {
		
		try {
			Thread.sleep(2000);
			
		}catch(InterruptedException e){
			
		}
		loginLink.click();
		uname.sendKeys(applicationUsername);
		pass.sendKeys(applicationPassword);
		captchaCheckbox.click();
		loginButton.click();
	}
	
	
	

}
