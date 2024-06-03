package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewThirdPartyPage
{
	WebDriver driver;
	public NewThirdPartyPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (id="name")
	private WebElement ThirdPartyNameTextField;
	
	@FindBy(id="select2-customerprospect-container")
	private WebElement SelectCustomerProspect;
	
	@FindBy(xpath="//li[text()='Customer']")
	private WebElement selectCustomer;
	
	@FindBy(id="town")
	private WebElement CityTextField;
	
	@FindBy(name="save")
	private WebElement CreateThirdPartyButton;
	
	
	public WebElement getSelectCustomer() {
		return selectCustomer;
	}

	public WebElement getThirdPartyNameTextField() {
		return ThirdPartyNameTextField;
	}

	public WebElement getSelectCustomerProspect() {
		return SelectCustomerProspect;
	}

	public WebElement getCityTextField() {
		return CityTextField;
	}

	public WebElement getCreateThirdPartyButton() {
		return CreateThirdPartyButton;
	}

	public void createCustomer(String CName, String CityName)
	{
		getThirdPartyNameTextField().sendKeys(CName);
		getCityTextField().sendKeys(CityName);
	}
	
	public void createProspect(String PName, String CityName)
	{
		getThirdPartyNameTextField().sendKeys(PName);
		getCityTextField().sendKeys(CityName);
	}
	
	public void selectCustomer()
	{
		Select cs= new Select(getSelectCustomerProspect());
		cs.selectByVisibleText("Customer");
	}
	
	public void selectProspect()
	{
		Select cs= new Select(SelectCustomerProspect);
		cs.selectByVisibleText("Prospect");
	}
	

}
