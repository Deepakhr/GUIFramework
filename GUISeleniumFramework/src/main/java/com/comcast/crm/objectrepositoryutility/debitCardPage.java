package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class debitCardPage {

	public debitCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccountHolderNameTextField() {
		return accountHolderNameTextField;
	}

	public WebElement getDobTextField() {
		return dobTextField;
	}

	public WebElement getPanTextField() {
		return panTextField;
	}

	public WebElement getMobileNoTextField() {
		return mobileNoTextField;
	}

	public WebElement getAccountNoTextField() {
		return accountNoTextField;
	}

	@FindBy(name="holder_name")
	private WebElement accountHolderNameTextField;
	
	@FindBy(name="dob")
	private WebElement dobTextField;
	
	@FindBy(name="pan")
	private WebElement panTextField;
	
	@FindBy(name="mob")
	private WebElement mobileNoTextField;
	
	@FindBy(name="acc_no")
	private WebElement accountNoTextField;
	
	@FindBy(name="dbt_crd_submit")
	private WebElement debitCardSubmitBtn;
	
	@FindBy(linkText = "Home")
	private WebElement homeBtn;

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getDebitCardSubmitBtn() {
		return debitCardSubmitBtn;
	}
}
