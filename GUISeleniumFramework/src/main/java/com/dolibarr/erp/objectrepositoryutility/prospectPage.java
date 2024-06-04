package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class prospectPage {
	public prospectPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(linkText="Create proposal")
	private WebElement createProposal;

	public WebElement getCreateProposal() {
		return createProposal;
	}
	
}
