package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteBeneficiaryPage {

	public deleteBeneficiaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="delete_beneficiary")
	private WebElement deleteBtn;
	
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
}
