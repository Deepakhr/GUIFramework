package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewThirdPartyPage
{
	@FindBy (id="name")
	private WebElement ThirdPartyNameTextField;
	
	@FindBy(id="select2-customerprospect-container")
	private WebElement SelectCustomerProspect;
	
	@FindBy(id="town")
	private WebElement CityTextField;
	
	@FindBy(name="save")
	private WebElement CreateThirdPartyButton;
	
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

	public void createCustomer()
	{
		getThirdPartyNameTextField().sendKeys();
		getCityTextField().sendKeys();
	}
	public void selectCustomer()
	{
		Select cs= new Select(SelectCustomerProspect);
		cs.selectByVisibleText("Customer");
	}
	
	public void selectProspect()
	{
		Select cs= new Select(SelectCustomerProspect);
		cs.selectByVisibleText("Prospect");
	}
	

}
