package com.comcast.crm.campaign_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.ipathconstant.IPathConstant;
import com.comcast.crm.objectrepositoryutility.CampaignInformationPage;
import com.comcast.crm.objectrepositoryutility.CampaignPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewCampagnPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

/**
 * 
 * @author Akash Deb
 *
 */

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateCampaignTest extends BaseClass {
	
	@Test(groups = "smoke", retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createCampaignWithMandatoryInfoTest() throws Throwable {
		
		String campaignName = eLib.getStringDataFromExcel(IPathConstant.CAMPAIGN_SHEAT_NAME, 1, 2);
		UtilityClassObject.getTest().log(Status.INFO, "Retrived Campaign Name From Excel Sheet");
		
		HomePage home=new HomePage(driver);
		CampaignPage campaign=new CampaignPage(driver);
		CreatingNewCampagnPage createCampaign=new CreatingNewCampagnPage(driver);
		CampaignInformationPage campaignInfo=new CampaignInformationPage(driver);
		
		home.clickOnCampagnLink();
		UtilityClassObject.getTest().log(Status.INFO, "More Option is mouse hovered and Campaign link has been clicked");

		campaign.clickOnAddCampagnButton();
		UtilityClassObject.getTest().log(Status.INFO, "Add Campaign Button has been clicked");
		
		createCampaign.enterCampaignName(campaignName);
		createCampaign.clickOnSaveButton();
		UtilityClassObject.getTest().log(Status.INFO, "Campaign has been created");
		
		String actualCampaignInfo = campaignInfo.verifyCampaignInformation();
		Assert.assertTrue(actualCampaignInfo.contains(campaignName));
		UtilityClassObject.getTest().log(Status.INFO, "Campaign Information is verified");
	}

}
