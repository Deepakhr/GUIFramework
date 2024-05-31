package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class creditCustomerPage {

	public creditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCustAccNoTextField() {
		return custAccNoTextField;
	}

	public WebElement getCreditAmountTextField() {
		return creditAmountTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	@FindBy(name="customer_account_no")
	private WebElement custAccNoTextField;
	
	@FindBy(name="credit_amount")
	private WebElement creditAmountTextField;

	@FindBy(name="credit_btn")
	private WebElement submitBtn;
	
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;
}
