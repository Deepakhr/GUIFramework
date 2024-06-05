package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCommercialProposalPage {
	WebDriver driver;
	public NewCommercialProposalPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@name='ref_client']")
	private WebElement refCustomer;

	@FindBy(xpath="//input[@id='re']")
	private WebElement dateOfProposal;
	@FindBy(name="save")
	private WebElement savedraft;
	public WebElement getRefCustomer() {
		return refCustomer;
	}
	public WebElement getDateOfProposal() {
		return dateOfProposal;
	}
	
	public WebElement getSavedraft() {
		return savedraft;
	}

	
	public void createProposal(String refcus,String date) {
		getRefCustomer().sendKeys(refcus);
		getDateOfProposal().clear();
		getDateOfProposal().sendKeys(date);
		getSavedraft().click();
		
		
	}
}
