package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Akash Deb
 *
 */
public class OrganizationInformationPage {

	WebDriver driver;

	public OrganizationInformationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

		this.driver = driver;
	}

	@FindBy(id = "dtlview_Industry")
	private WebElement organizationIndustry;

	@FindBy(id = "dtlview_Phone")
	private WebElement organizationPhoneNumber;

	public String verifyOrganizationInformation(String organizationName) {
		return driver.findElement(By.xpath("//span[contains(text(), '" + organizationName + "')]")).getText();
	}

	public String verifyOrganizationIndustryDetails() {
		return organizationIndustry.getText();

	}
	
	public String verifyOrganizationPhoneNoDetails() {
		return organizationPhoneNumber.getText();

	}
}
