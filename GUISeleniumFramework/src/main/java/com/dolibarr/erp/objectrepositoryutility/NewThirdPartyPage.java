package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewThirdPartyPage
{
	public NewThirdPartyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (id="name")
	private WebElement ThirdPartyNameTextField;
	
	@FindBy(id="select2-customerprospect-container")
	private WebElement SelectCustomerProspect;
	
	@FindBy(id="town")
	private WebElement CityTextField;
	
	@FindBy(name="save")
	private WebElement CreateThirdPartyButton;
	@FindBy(xpath="//li[text()='Prospect']")
	private WebElement prospect;
	
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

	public WebElement getProspect() {
		return prospect;
	}
	

}
