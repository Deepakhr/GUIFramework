package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newCommercialProposalPage {
	public newCommercialProposalPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@name='ref_client']")
	private WebElement refCustomer;

	@FindBy(xpath="//input[@id='re']")
	private WebElement dateOfProposal;
	@FindBy(name="save")
	private WebElement save;
	public WebElement getRefCustomer() {
		return refCustomer;
	}
	public WebElement getDateOfProposal() {
		return dateOfProposal;
	}
	public WebElement getSave() {
		return save;
	}
	
}
