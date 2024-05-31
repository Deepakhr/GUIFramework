package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class customerHomePage {

	public customerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	@FindBy(xpath = "//label[contains(text(),'Welcome')]")
	private WebElement welcomeText;

	public WebElement getWelcomeText() {
		return welcomeText;
	}

	@FindBy(name="logout_btn")
	private WebElement logoutBtn;

	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundTransferBtn;

	@FindBy(xpath = "//li[text()='Statement']")
	private WebElement statementBtn;
	
	@FindBy(xpath = "//li[text()='Change Password']")
	private WebElement changePasswordBtn;
	
	public WebElement getChangePasswordBtn() {
		return changePasswordBtn;
	}

	public WebElement getStatementBtn() {
		return statementBtn;
	}

	public WebElement getFundTransferBtn() {
		return fundTransferBtn;
	}

}

