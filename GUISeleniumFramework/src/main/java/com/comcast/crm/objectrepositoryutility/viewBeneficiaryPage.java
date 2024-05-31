package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class viewBeneficiaryPage {

	public viewBeneficiaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundTransferBtn;

	public WebElement getFundTransferBtn() {
		return fundTransferBtn;
	}

}
