/**
 * 
 */
package com.txautomation.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.txautomation.utility.ConfigDataProvider;

/**
 * @author vramdasbandekar
 *
 */
public class AppropriationPage {
	
WebDriver driver;

	public AppropriationPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	ConfigDataProvider config = new ConfigDataProvider();
	
	// Login Page locators
	@FindBy(id="username") WebElement uname;
	@FindBy(id="password") WebElement pass;
	@FindBy(id="Login") WebElement loginBtn;
	
	//Create Appropriaion locators
	@FindBy(xpath="//span[contains(text(),'More')]") WebElement moreLink;
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/div[1]/one-app-nav-bar-menu-button/div/slot/one-app-nav-bar-menu-item[7]/a/span/span") WebElement appropriationLink;
	@FindBy(xpath="//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div") WebElement newBtn;
	@FindBy(xpath="(//input[@class=\"input uiInput uiInputRadio uiInput--default uiInput--radio\"])[2]") WebElement blockGrntOption;
	@FindBy(xpath="//span[contains(text(),'Next')]") WebElement next;
 	@FindBy(xpath="(//input[@class=\"slds-combobox__input slds-input\"])[1]") WebElement programSearch;
 	@FindBy(xpath="//lightning-base-combobox-formatted-text[@title=\"Texas College Work-Study\"]") WebElement programSelectBtn;
	@FindBy(xpath="(//input[@class=\"slds-combobox__input slds-input\"])") WebElement fiscalYear;
	@FindBy(xpath="(//*[contains(@data-value,'a0CDI000000Cm032AC')])") WebElement newFiscalYear;
	@FindBy(xpath="(//input[@class=\"slds-input\"][@name=\"GAPP_PCA__c\"])") WebElement pcaValue;
	@FindBy(xpath="(//input[@class=\"slds-input\"][@name=\"GAPP_Appropriation_Amount__c\"])") WebElement amountValue;
	@FindBy(xpath="//button[@name=\"SaveEdit\"]") WebElement save;
	@FindBy(xpath="//button[@name=\"Submit\"]") WebElement submitForApprovalBtn;
	@FindBy(xpath="//textarea[@class=\"inputTextArea cuf-messageTextArea textarea\"]") WebElement submitTextArea;
	@FindBy(xpath="//span[contains(text(),'Submit')]") WebElement submit;
	@FindBy(xpath="//*[@id=\"88:223;a\"]/span[1]/div/span/img") WebElement logImage;
	@FindBy(xpath="//*[@id=\"oneHeader\"]/div[1]/div/a") WebElement logout;
	
	//Approve Appropriation locators
	@FindBy(xpath="(//a[@href= \"/lightning/o/GAPP_Appropriation__c/home\"])[2]") WebElement appropriationMenulink;
	@FindBy(xpath="//button[@title=\"Select a List View: Appropriations\"]") WebElement selectList;
	@FindBy(xpath="(//div[@class=\"listContent\"]//a[@href=\"javascript:void(0);\"])[1]") WebElement clickAll;
	@FindBy(xpath="(//th[@scope=\"row\"])[1]//a") WebElement firstElelmentSelect;
	@FindBy(xpath="//a[@id=\"relatedListsTab__item\"]") WebElement relatedTab;
	@FindBy(xpath="//div[@title=\"Approve\"]") WebElement approve;
	@FindBy(xpath="//button[@class=\"slds-button slds-button--neutral modal-button-left actionButton uiButton--default uiButton--brand uiButton\"]") WebElement approveBtn;
	
	
	public void appropriationTest(String applicationUsername, String applicationPassword) {
		
		try {
			Thread.sleep(2000);
			
		}catch(InterruptedException e){
			
		}
		uname.sendKeys(applicationUsername);
		pass.sendKeys(applicationPassword);
		loginBtn.click();
	}
	
	public void createAppropriation() {
		
		try {
			moreLink.click();
			Thread.sleep(6000);
			
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();",appropriationLink);
		newBtn.click();
		js.executeScript("arguments[0].click();",blockGrntOption);
		Thread.sleep(2000);
		next.click();
		programSearch.sendKeys(config.getDataFromConfig("program"));
		Thread.sleep(6000);
		programSelectBtn.click();
		fiscalYear.click();
		Thread.sleep(3000);
		newFiscalYear.click();
		Thread.sleep(2000);
		pcaValue.sendKeys(config.getDataFromConfig("pca"));
		Thread.sleep(2000);
		amountValue.sendKeys(config.getDataFromConfig("amount"));
		Thread.sleep(3000);
		save.click();
		Thread.sleep(3000);
		submitForApprovalBtn.click();
		submitTextArea.sendKeys(config.getDataFromConfig("ChangeAmount"));
		Thread.sleep(5000);
		submit.click();
		//logImage.click();
		Thread.sleep(2000);
		logout.click();
		
		//logImage.click();
		//Thread.sleep(2000);
	//	logout.click();
		
		}catch(InterruptedException e){
			
		}
	}
	
public void approveAppropriation() {
		
		try {
			moreLink.click();
			Thread.sleep(4000);
			
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();",appropriationMenulink);
		selectList.click();
		clickAll.click();
		Thread.sleep(3000);
		firstElelmentSelect.click();
		Thread.sleep(3000);
		relatedTab.click();
		Thread.sleep(2000);
		approve.click(); 
		submitTextArea.sendKeys(config.getDataFromConfig("ApproveText"));
		Thread.sleep(2000);
		approveBtn.click();
		
		}catch(InterruptedException e){
			
		}
	}
	
}
