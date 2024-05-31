package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class statementPage {

	public statementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBalanceAmount() {
		return balanceAmount;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	@FindBy(name = "logout_btn")
	private WebElement logoutBtn;

	@FindBy(xpath = "//td[text()='1']/following-sibling::td[6]")
	private WebElement balanceAmount;
}
