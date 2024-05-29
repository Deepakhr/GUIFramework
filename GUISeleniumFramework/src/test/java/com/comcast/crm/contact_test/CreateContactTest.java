package com.comcast.crm.contact_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.ipathconstant.IPathConstant;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

/**
 * 
 * @author Akash Deb
 *
 */
//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateContactTest extends BaseClass {
	
	@Test(groups = "smoke", retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createContactWithMandatoryInformationTest() throws Throwable {
		
		String contactLastName = eLib.getStringDataFromExcel(IPathConstant.CONTACT_SHEAT_NAME, 1, 4);
		UtilityClassObject.getTest().log(Status.INFO, "Retrived Organization Name From Excel Sheet");
		
		HomePage home=new HomePage(driver);
		ContactPage contact=new ContactPage(driver);
		CreatingNewContactsPage createContact=new CreatingNewContactsPage(driver);
		ContactInformationPage contactInfo=new ContactInformationPage(driver);
		
		home.clickOnContactLink();
		contact.clickOnAddContactButton();
		createContact.enterLastName(contactLastName);
		createContact.clickOnSaveButton();
		UtilityClassObject.getTest().log(Status.INFO, "Created a Contact with Mandatory Information");

		String actualContactInfo = contactInfo.verifyContactInformation();
		Assert.assertTrue(actualContactInfo.contains(contactLastName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact information is verified");
		
	}
	
	@Test(groups = "smoke", retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createContactWithFirstNameAndSalutationTest() throws Throwable {
		
		String contactSalutation = eLib.getStringDataFromExcel(IPathConstant.CONTACT_SHEAT_NAME, 1, 2);
		String contactFirstName = eLib.getStringDataFromExcel(IPathConstant.CONTACT_SHEAT_NAME, 1, 3);
		String contactLastName = eLib.getStringDataFromExcel(IPathConstant.CONTACT_SHEAT_NAME, 1, 4);
		UtilityClassObject.getTest().log(Status.INFO, "Retrived Organization Name From Excel Sheet");
		
		HomePage home=new HomePage(driver);
		ContactPage contact=new ContactPage(driver);
		CreatingNewContactsPage createContact=new CreatingNewContactsPage(driver);
		ContactInformationPage contactInfo=new ContactInformationPage(driver);
		
		home.clickOnContactLink();
		contact.clickOnAddContactButton();
		createContact.selectFromSalutationDropdown(contactSalutation);
		createContact.enterContactFirstName(contactFirstName);
		createContact.enterLastName(contactLastName);
		createContact.clickOnSaveButton();
		UtilityClassObject.getTest().log(Status.INFO, "Created a Contact with Salutation and First Name Information");

		String actualContactSalutationInfo = contactInfo.verifyContactSalutation();
		Assert.assertTrue(actualContactSalutationInfo.contains(contactSalutation));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact salutation information is verified");
		
		String actualContactInfo = contactInfo.verifyContactInformation();
		Assert.assertTrue(actualContactInfo.contains(contactFirstName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact salutation information is verified");
		
		Assert.assertTrue(actualContactInfo.contains(contactLastName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact information is verified");
		
	}
	
	
	@Test(groups = "smoke", retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createContactWithsalutationFirstNameAndSupportStartAndEndDateTest() throws Throwable {
		
		String contactSalutation = eLib.getStringDataFromExcel(IPathConstant.CONTACT_SHEAT_NAME, 1, 2);
		String contactFirstName = eLib.getStringDataFromExcel(IPathConstant.CONTACT_SHEAT_NAME, 1, 3);
		String contactLastName = eLib.getStringDataFromExcel(IPathConstant.CONTACT_SHEAT_NAME, 1, 4);
		UtilityClassObject.getTest().log(Status.INFO, "Retrived Organization Name From Excel Sheet");
		
		HomePage home=new HomePage(driver);
		ContactPage contact=new ContactPage(driver);
		CreatingNewContactsPage createContact=new CreatingNewContactsPage(driver);
		ContactInformationPage contactInfo=new ContactInformationPage(driver);
		
		home.clickOnContactLink();
		contact.clickOnAddContactButton();
		createContact.selectFromSalutationDropdown(contactSalutation);
		createContact.enterContactFirstName(contactFirstName);
		createContact.enterLastName(contactLastName);
		createContact.enterSupportStartDate(jLib.getRequriedDateYYYYDDMM(0));
		createContact.enterSupportEndDate(jLib.getRequriedDateYYYYDDMM(30));
		createContact.clickOnSaveButton();
		UtilityClassObject.getTest().log(Status.INFO, "Created a Contact with Salutation and First Name Information");

		String actualContactSalutationInfo = contactInfo.verifyContactSalutation();
		Assert.assertTrue(actualContactSalutationInfo.contains(contactSalutation));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact salutation information is verified");
		
		String actualContactInfo = contactInfo.verifyContactInformation();
		Assert.assertTrue(actualContactInfo.contains(contactFirstName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact first name information is verified");
		
		Assert.assertTrue(actualContactInfo.contains(contactLastName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact last name information is verified");
		
		String actualSupportStartDateInfo = contactInfo.verifySupportStartDateInformation();
		Assert.assertTrue(actualSupportStartDateInfo.contains(jLib.getRequriedDateYYYYDDMM(0)));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact salutation information is verified");
		
		
		String actualSupportEndDateInfo = contactInfo.verifySupportEndDateInformation();
		Assert.assertTrue(actualSupportEndDateInfo.contains(jLib.getRequriedDateYYYYDDMM(30)));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: the contact salutation information is verified");
		
	}

}
