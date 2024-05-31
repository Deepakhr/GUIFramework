package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class internetBankingLoginPage {
	
	public internetBankingLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "customer_id")
	private WebElement customerIdTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(name="login-btn")
	private WebElement loginBtn;
	
	@FindBy(linkText = "Home")
	private WebElement homeBtn;

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getCustomerIdTextField() {
		return customerIdTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
