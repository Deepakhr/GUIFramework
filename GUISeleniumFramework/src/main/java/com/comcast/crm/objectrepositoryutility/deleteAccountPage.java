package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteAccountPage {

	public deleteAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCustAccNoTextField() {
		return custAccNoTextField;
	}

	public WebElement getCustIDTextField() {
		return custIDTextField;
	}

	public WebElement getReasonTextField() {
		return reasonTextField;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	@FindBy(name="Cust_ac_no")
	private WebElement custAccNoTextField;
	
	@FindBy(name="Cust_ac_Id")
	private WebElement custIDTextField;
	
	@FindBy(name="reason")
	private WebElement reasonTextField;
	
	@FindBy(name="delete")
	private WebElement deleteBtn;
	
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
}

