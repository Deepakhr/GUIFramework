package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class otpPage {

	public otpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOtpText() {
		return otpText;
	}

	@FindBy(xpath = "//label[@class='OTP_msg']")
	private WebElement otpText;
	
	@FindBy(name="otpcode")
	private WebElement otpCodeTextField;
	
	@FindBy(name="verify-btn")
	private WebElement verifyBtn;

	public WebElement getOtpCodeTextField() {
		return otpCodeTextField;
	}

	public WebElement getVerifyBtn() {
		return verifyBtn;
	}
}
