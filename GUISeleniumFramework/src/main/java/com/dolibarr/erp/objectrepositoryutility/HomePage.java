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
public class HomePage {
	WebDriverUtility Wlib = new WebDriverUtility();
	WebDriver driver;

<<<<<<< HEAD
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='topmenu-login-dropdown']")
	private WebElement logoutMenu;
	
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logOut;
	
=======
	 public HomePage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//div[@id='topmenu-login-dropdown']")
	 private WebElement logoutMenu;
	 @FindBy(xpath="//span[text()='Logout']")
	 private WebElement logOut;
>>>>>>> branch 'Testing' of https://github.com/beatsane/Dolibarr_GUIFramework.git
	@FindBy(id = "mainmenua_companies")
	private WebElement thirdPartiesMenu;
	
	@FindBy(id = "mainmenua_products")
	private WebElement productsAndServicesMenu;

	public WebElement getProductsAndServicesMenu() {
		return productsAndServicesMenu;
	}

	public WebElement getThirdPartiesMenu() {
		return thirdPartiesMenu;
	}

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

	public void clickOnProductsAndServicesMenu() {
		getProductsAndServicesMenu().click();
	}
}
