package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPage 
{
	WebDriver driver;
	public CustomerInfoPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (linkText= "Customer")
	private WebElement CustomerLink;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCustomerLink() {
		return CustomerLink;
	}
	
	

}
