package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class internetBankingRegistrationPage {

	public internetBankingRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccHolderNameTextField() {
		return accHolderNameTextField;
	}

	public WebElement getAccNoTextField() {
		return accNoTextField;
	}

	public WebElement getDebitCardNoTextField() {
		return debitCardNoTextField;
	}

	public WebElement getDebitCardPinTextField() {
		return debitCardPinTextField;
	}

	public WebElement getMobileNoTextField() {
		return mobileNoTextField;
	}

	public WebElement getPanCardNoTextField() {
		return panCardNoTextField;
	}

	public WebElement getDobTextField() {
		return dobTextField;
	}

	public WebElement getLastTransactionTextField() {
		return lastTransactionTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPassTextField() {
		return confirmPassTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(name="holder_name")
	private WebElement accHolderNameTextField;
	
	@FindBy(name="accnum")
	private WebElement accNoTextField;
	
	@FindBy(name="dbtcard")
	private WebElement debitCardNoTextField;
	
	@FindBy(name="dbtpin")
	private WebElement debitCardPinTextField;
	
	@FindBy(name="mobile")
	private WebElement mobileNoTextField;
	
	@FindBy(name="pan_no")
	private WebElement panCardNoTextField;
	
	@FindBy(name="dob")
	private WebElement dobTextField;
	
	@FindBy(name="last_trans")
	private WebElement lastTransactionTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(name="cnfrm_password")
	private WebElement confirmPassTextField;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	@FindBy(linkText = "Home")
	private WebElement homeBtn;

	public WebElement getHomeBtn() {
		return homeBtn;
	}
}
