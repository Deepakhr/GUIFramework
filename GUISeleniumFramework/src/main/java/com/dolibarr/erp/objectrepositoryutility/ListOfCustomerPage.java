package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfCustomerPage
{
	WebDriver driver;
	public ListOfCustomerPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (name="search_nom")
	private WebElement SearchCust;

	public WebElement getSearchCust() {
		return SearchCust;
	}
	

}
