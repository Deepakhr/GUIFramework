package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class approveAccountPage {
	
	public approveAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getApproveBtn() {
		return approveBtn;
	}

	public WebElement getApplicationNoTextField() {
		return applicationNoTextField;
	}

	@FindBy(name="application_no")
	private WebElement applicationNoTextField;
	
	@FindBy(name="approve_cust")
	private WebElement approveBtn;
	
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	
	}

