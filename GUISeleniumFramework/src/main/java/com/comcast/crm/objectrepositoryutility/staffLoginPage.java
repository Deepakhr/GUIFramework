package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class staffLoginPage {

	public staffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getStaffIdTextField() {
		return staffIdTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	@FindBy(name = "staff_id")
	private WebElement staffIdTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(name="staff_login-btn")
	private WebElement loginBtn;
	
	@FindBy(linkText ="Home")
	private WebElement HomeBtn;

	public WebElement getHomeBtn() {
		return HomeBtn;
	}
}
