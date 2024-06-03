package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  
public class HomePage extends WebDriverUtility{                             
	WebDriverUtility Wlib=new WebDriverUtility();              
	WebDriver driver;
	 public HomePage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//div[@id='topmenu-login-dropdown']")
	 private WebElement logoutMenu;
	 @FindBy(xpath="//span[text()='Logout']")
	 private WebElement logOut;
	 
	public WebElement getLogoutMenu() {
		return logoutMenu;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public void logout() {
		Wlib.mousemoveOnElement(driver,logoutMenu);
		getLogoutMenu().click();
		getLogOut().click();
		
	}

	

	
	
}
