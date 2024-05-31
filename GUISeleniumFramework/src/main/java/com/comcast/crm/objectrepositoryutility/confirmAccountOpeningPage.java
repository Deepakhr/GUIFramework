package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmAccountOpeningPage {

	public confirmAccountOpeningPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="cnfrm-submit")
	private WebElement confirmBtn;

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}
}
