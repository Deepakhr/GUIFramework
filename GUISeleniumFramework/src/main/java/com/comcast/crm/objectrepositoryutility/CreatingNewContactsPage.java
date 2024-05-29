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
public class CreatingNewContactsPage {
	
	WebDriver driver;
	 public CreatingNewContactsPage(WebDriver driver) {           
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	@FindBy(name = "salutationtype")
	private WebElement contactSalutationDropdown;
	
	@FindBy(name = "firstname")
	private WebElement contactFirstName;
	
	@FindBy(name = "lastname")
	private WebElement contactLastName;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactSalutationDropdown() {
		return contactSalutationDropdown;
	}

	public WebElement getContactFirstName() {
		return contactFirstName;
	}

	public WebElement getContactLastName() {
		return contactLastName;
	}
	
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void selectFromSalutationDropdown(String option) {
		
		new Select(contactSalutationDropdown).selectByVisibleText(option);
	}
	
	public void enterContactFirstName(String firstName) {
		contactFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		contactLastName.sendKeys(lastName);
	}
	
	public void enterSupportStartDate(String date) {
		supportStartDate.clear();
		supportStartDate.sendKeys(date);
	}
	
	public void enterSupportEndDate(String date) {
		supportEndDate.clear();
		supportEndDate.sendKeys(date);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
