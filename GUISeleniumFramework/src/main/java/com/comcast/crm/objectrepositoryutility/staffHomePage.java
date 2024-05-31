package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class staffHomePage {

	public staffHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "apprvac")
	private WebElement approvePendingAccountBtn;
	
	public WebElement getCreditCustomerBtn() {
		return creditCustomerBtn;
	}

	@FindBy(name="del_cust")
	private WebElement deleteCustomerBtn;
	
	public WebElement getDeleteCustomerBtn() {
		return deleteCustomerBtn;
	}

	@FindBy(name="credit_cust_ac")
	private WebElement creditCustomerBtn;

	public WebElement getApprovePendingAccountBtn() {
		return approvePendingAccountBtn;
	}
	@FindBy(name="view_cust_by_ac")
	private WebElement viewCustBtn;

	public WebElement getViewCustBtn() {
		return viewCustBtn;
	}

}
