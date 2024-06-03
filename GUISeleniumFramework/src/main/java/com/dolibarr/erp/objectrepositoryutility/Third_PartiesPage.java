package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Third_PartiesPage
{
	@FindBy (linkText="New Customer")
	private WebElement NewCustomerLink;
	
	@FindBy (linkText="New Prospect")
	private WebElement NewProspectLink;
	
	@FindBy (linkText="List of Customers")
	private WebElement ListOfCustomersLink;
	
	@FindBy (linkText="List of Prospects")
	private WebElement ListOfProspectsLink;

	public WebElement getNewCustomerLink() {
		return NewCustomerLink;
	}

	public WebElement getNewProspectLink() {
		return NewProspectLink;
	}

	public WebElement getListOfCustomersLink() {
		return ListOfCustomersLink;
	}

	public WebElement getListOfProspectsLink() {
		return ListOfProspectsLink;
	}
	
	
	

}
