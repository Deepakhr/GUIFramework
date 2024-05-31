package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class changePasswordPage {

	public changePasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOldPassTextField() {
		return oldPassTextField;
	}

	public WebElement getConfirmOldPassTextField() {
		return confirmOldPassTextField;
	}

	public WebElement getNewPassTextField() {
		return newPassTextField;
	}

	@FindBy(name="oldpass")
	private WebElement oldPassTextField;
	
	@FindBy(name="cnfrm")
	private WebElement confirmOldPassTextField;

	@FindBy(name="newpass")
	private WebElement newPassTextField;
	
	@FindBy(name="change_pass")
	private WebElement changePassBtn;
	
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getChangePassBtn() {
		return changePassBtn;
	}

	
}
