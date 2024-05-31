package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class internetBankingHoverPage {

	public internetBankingHoverPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[text()='Register']")
	private WebElement registerBtn;
	
	@FindBy(xpath="//li[text()='Login ']")
	private WebElement loginBtn;

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
