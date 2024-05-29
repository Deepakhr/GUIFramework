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
public class CampaignInformationPage {
	
	public CampaignInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement campaignInfoHeader;

	public WebElement getCampaignInfoHeader() {
		return campaignInfoHeader;
	}
	
	public String verifyCampaignInformation() {
		return campaignInfoHeader.getText();
	}

}
