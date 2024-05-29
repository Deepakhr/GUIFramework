package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Akash Deb
 *
 */
public class ContactInformationPage {
	
public ContactInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement contactInfoHeader;
	
	@FindBy(id = "mouseArea_First Name")
	private WebElement salutation;
	
	@FindBy(xpath = "//span[@id='dtlview_Support Start Date']")
	private WebElement supportStartDate;
	
	@FindBy(xpath = "//span[@id='dtlview_Support End Date']")
	private WebElement supportEndDate;

	public WebElement getContactInfoHeader() {
		return contactInfoHeader;
	}
	
	public String verifyContactInformation() {
		return contactInfoHeader.getText();
	}
	
	public String verifyContactSalutation() {
		return salutation.getText();
	}
	
	public String verifySupportStartDateInformation() {
		return supportStartDate.getText();
	}
	
	public String verifySupportEndDateInformation() {
		return supportEndDate.getText();
	}
	


}
