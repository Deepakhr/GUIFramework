package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class viewCustomerPage {

	public viewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="account_no")
	private WebElement AccNoTextField;
	
	@FindBy(name="submit_view")
	private WebElement submitBtn;
	
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Account Number')]")
	private WebElement accountNoDetails;

	public WebElement getAccountNoDetails() {
		return accountNoDetails;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getAccNoTextField() {
		return AccNoTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
}
