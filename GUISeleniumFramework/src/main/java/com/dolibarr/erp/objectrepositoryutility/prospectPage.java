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
	@FindBy(linkText="Create contract")
	private WebElement createcontract;
	public WebElement getCreateProposal() {
		return createProposal;
	}
	public WebElement getCreateContract() {
		return createcontract;
	}
}
