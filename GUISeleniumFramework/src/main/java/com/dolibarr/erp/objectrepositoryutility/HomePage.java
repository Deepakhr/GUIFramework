package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dolibarr.erp.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class HomePage extends WebDriverUtility {
	WebDriverUtility Wlib = new WebDriverUtility();
	WebDriver driver;
<<<<<<< HEAD
	 public HomePage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//div[@id='topmenu-login-dropdown']")
	 private WebElement logoutMenu;
	 @FindBy(xpath="//span[text()='Logout']")
	 private WebElement logOut;
	
=======

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='topmenu-login-dropdown']")
	private WebElement logoutMenu;
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logOut;
	@FindBy(id = "mainmenua_companies")
	private WebElement thirdPartiesMenu;

	public WebElement getThirdPartiesMenu() {
		return thirdPartiesMenu;
	}

>>>>>>> branch 'Testing' of https://github.com/AnushaDudekula/Dolibarr_GUIFramework-.git
	public WebElement getLogoutMenu() {
		return logoutMenu;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	



	public void logout() {
		Wlib.mousemoveOnElement(driver, logoutMenu);
		getLogoutMenu().click();
		getLogOut().click();
	}
	
	public void clickOnThirdPartiesMenu() {
		getThirdPartiesMenu().click();
	}

}
