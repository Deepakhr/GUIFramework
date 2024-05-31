package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//li[text()='Open Account']")
	private WebElement openAccBtn;

	@FindBy(xpath = "//a[text()='Staff Login']")
	private WebElement staffLoginBtn;
	
	@FindBy(xpath = "//li[text()='Apply Debit Card']")
	private WebElement applyDebitCardBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Internet Banking')]")
	private WebElement internetBankingBtn;
	
	public WebElement getInternetBankingBtn() {
		return internetBankingBtn;
	}

	public WebElement getApplyDebitCardBtn() {
		return applyDebitCardBtn;
	}

	public WebElement getStaffLoginBtn() {
		return staffLoginBtn;
	}

	public WebElement getOpenAccBtn() {
		return openAccBtn;
	}
}
