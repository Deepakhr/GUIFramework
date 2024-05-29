package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author Akash Deb
 *
 */
public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name = "industry")
	private WebElement organizationIndustryDropdown;
	
	@FindBy(name = "phone")
	private WebElement organizationPhoneNumberTextField;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement organizationSaveButton;

	
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getOrganizationSaveButton() {
		return organizationSaveButton;
	}
	
	public void enterOrganizationName(String organizationName) {
		organizationNameTextField.sendKeys(organizationName);
	}
	
	public void selectFromOrganizationIndustry(String industry) {
		
		new Select(organizationIndustryDropdown).selectByVisibleText(industry);
	}
	
	public void enterOrganizationPhoneNumber(String organizationPhoneNumber) {
		organizationPhoneNumberTextField.sendKeys(organizationPhoneNumber);
	}
	
	public void clickOnSaveButton() {
		organizationSaveButton.click();
	}
}
