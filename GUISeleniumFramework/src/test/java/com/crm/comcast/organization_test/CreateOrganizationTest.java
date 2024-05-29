package com.crm.comcast.organization_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.ipathconstant.IPathConstant;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;


/**
 * 
 * @author Akash Deb
 *
 */

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass {
	
	@Test(groups = "smoke", retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createOrganizationWithMandatoryInformationTest() throws Throwable {
	
		String organizationName = eLib.getStringDataFromExcel(IPathConstant.ORGANIZATION_SHEAT_NAME, 1, 2)+jLib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Retrived Organization Name From Excel Sheet");
		
		HomePage home=new HomePage(driver);
		OrganizationPage organization=new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo=new OrganizationInformationPage(driver);
		
		home.clickOnOrganizationLink();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on the Organization Link on Home Page");

		organization.clickOnAddOrganizationButton();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on the Add Organization Button on Home Page");

		createOrganization.enterOrganizationName(organizationName);
		createOrganization.clickOnSaveButton();
		UtilityClassObject.getTest().log(Status.INFO, "Created a new Organization with Organization Name");

		String actualOrganizationName = organizationInfo.verifyOrganizationInformation(organizationName);
		UtilityClassObject.getTest().log(Status.INFO, "Fetched the Page Header Containing the Organization Information");

		Assert.assertTrue(actualOrganizationName.contains(organizationName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: The Organization is successfully created");

	}
	
	@Test(groups = "regression", retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createOrganizationWithIndustryDetails() throws Throwable {
		
		String organizationName = eLib.getStringDataFromExcel(IPathConstant.ORGANIZATION_SHEAT_NAME, 1, 2)+jLib.getRandomNumber();
		String organizationIndustry = eLib.getStringDataFromExcel(IPathConstant.ORGANIZATION_SHEAT_NAME, 1, 3);

		UtilityClassObject.getTest().log(Status.INFO, "Retrived Organization Name and Indsutry From Excel Sheet");
		
		HomePage home=new HomePage(driver);
		OrganizationPage organization=new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo=new OrganizationInformationPage(driver);
		
		home.clickOnOrganizationLink();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on the Organization Link on Home Page");

		organization.clickOnAddOrganizationButton();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on the Add Organization Button on Home Page");

		createOrganization.enterOrganizationName(organizationName);
		createOrganization.selectFromOrganizationIndustry(organizationIndustry);
		createOrganization.clickOnSaveButton();
		UtilityClassObject.getTest().log(Status.INFO, "Created a new Organization with Organization Name and Industry");

		String actualOrganizationName = organizationInfo.verifyOrganizationInformation(organizationName);
		UtilityClassObject.getTest().log(Status.INFO, "Fetched the Page Header Containing the Organization Information");
	
		Assert.assertTrue(actualOrganizationName.contains(organizationName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: The Organization Name is verified");
		
		String actualOrganizationIndustryInfo = organizationInfo.verifyOrganizationIndustryDetails();
		
		Assert.assertTrue(actualOrganizationIndustryInfo.contains(organizationIndustry));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: The Organization Industry is verified");
		
	}
	
	@Test(groups = "regression", retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createOrganizationWithPhoneNumberDetails() throws Throwable {
		
		String organizationName = eLib.getStringDataFromExcel(IPathConstant.ORGANIZATION_SHEAT_NAME, 1, 2)+jLib.getRandomNumber();
		String organizationPhoneNumber = eLib.getNumericDataFromExcel(IPathConstant.ORGANIZATION_SHEAT_NAME, 1, 4)+"";

		UtilityClassObject.getTest().log(Status.INFO, "Retrived Organization Name and Indsutry From Excel Sheet");
		
		HomePage home=new HomePage(driver);
		OrganizationPage organization=new OrganizationPage(driver);
		CreatingNewOrganizationPage createOrganization=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage organizationInfo=new OrganizationInformationPage(driver);
		
		home.clickOnOrganizationLink();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on the Organization Link on Home Page");

		organization.clickOnAddOrganizationButton();
		UtilityClassObject.getTest().log(Status.INFO, "Clicked on the Add Organization Button on Home Page");

		createOrganization.enterOrganizationName(organizationName);
		createOrganization.enterOrganizationPhoneNumber(organizationPhoneNumber);
		createOrganization.clickOnSaveButton();
		UtilityClassObject.getTest().log(Status.INFO, "Created a new Organization with Organization Name and Phone Number");

		String actualOrganizationName = organizationInfo.verifyOrganizationInformation(organizationName);
		UtilityClassObject.getTest().log(Status.INFO, "Fetched the Page Header Containing the Organization Information");
	
		Assert.assertTrue(actualOrganizationName.contains(organizationName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: The Organization Name is verified");
		
		String actualOrganizationPhoneNumberInfo = organizationInfo.verifyOrganizationPhoneNoDetails();
		
		Assert.assertTrue(actualOrganizationPhoneNumberInfo.contains(organizationPhoneNumber));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: The Organization Phone Number is verified");
		
	}

}
