package com.hsbc.bfsi.openAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.approveAccountPage;
import com.comcast.crm.objectrepositoryutility.confirmAccountOpeningPage;
import com.comcast.crm.objectrepositoryutility.creditCustomerPage;
import com.comcast.crm.objectrepositoryutility.homePage;
import com.comcast.crm.objectrepositoryutility.onlineAccOpeningFormPage;
import com.comcast.crm.objectrepositoryutility.staffHomePage;
import com.comcast.crm.objectrepositoryutility.staffLoginPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class openAccountTest extends BaseClass {

	@Test(priority = 1)
	public void OpenAccTest() throws Throwable {
		homePage hp = new homePage(driver);
		onlineAccOpeningFormPage op = new onlineAccOpeningFormPage(driver);
		confirmAccountOpeningPage cp = new confirmAccountOpeningPage(driver);

		int ranValue = jLib.getRandomNumber();
//		================open Account Page=========================
		String name = eLib.getDataFromExcel("openAcc", 1, 0) + ranValue;
		hp.getOpenAccBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Online Account Opening Form Displayed<<<");

		op.getNameTextField().sendKeys(name);
		eLib.setDataIntoExcel("openAcc", 5, 0, name);
		wlib.select(op.getGenderDropDown(), eLib.getDataFromExcel("openAcc", 1, 1));
		op.getMobileTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 2));
		op.getEmailTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 3));
		op.getLandlineTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 4));
		op.getDobTextField().click();
		op.getDobTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 5));
		op.getPanTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 6));
		op.getCitizenshipTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 7));
		op.getHomeAddTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 8));
		op.getOfcAddTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 9));
		wlib.select(op.getStateDropDown(), eLib.getDataFromExcel("openAcc", 1, 10));
		wlib.select(op.getCityDropDown(), eLib.getDataFromExcel("openAcc", 1, 11));
		op.getPinTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 12));
		op.getAreaLocTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 13));
		op.getNomineeNameTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 14));
		op.getNomineeAccNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 15));
		wlib.select(op.getAccTypeDropDown(), eLib.getDataFromExcel("openAcc", 1, 16));
		op.getSubmitBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Account Opening Confirmation Page Displayed<<<");
		cp.getConfirmBtn().click();

		String text = wlib.switchtoAlertAndGetData(driver);
		String applnNo = jLib.getDigitFromText(text);

		Assert.assertEquals(text.contains("Application submitted successfully"), true);
		Reporter.log(">>>Application submitted Successfully and Application No: " + applnNo + "<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Application submitted successfully<<<");

		wlib.switchtoAlertAndAccept(driver);

		eLib.setDataIntoExcel("openAcc", 5, 1, applnNo);
	}

	@Test(priority = 2)
	public void staffLoginTest() throws Throwable {
		homePage hp = new homePage(driver);
		staffLoginPage sp = new staffLoginPage(driver);
		staffHomePage shp = new staffHomePage(driver);
		approveAccountPage aap = new approveAccountPage(driver);

		hp.getStaffLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Login Page Displayed<<<");
		sp.getStaffIdTextField().sendKeys(fLib.getDataFromPropertiesFile("staffID"));
		sp.getPasswordTextField().sendKeys(fLib.getDataFromPropertiesFile("password"));
		sp.getLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Home Page Displayed<<<");

		shp.getApprovePendingAccountBtn().click();

		ListImpClass.test.log(Status.INFO, ">>>Approve Pending Account Page Displayed<<<");

		aap.getApplicationNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 1), Keys.ENTER);
		aap.getApproveBtn().click();

		String AccountNoText = wlib.switchtoAlertAndGetData(driver);
		String accountNo = jLib.getDigitFromText(AccountNoText);
		eLib.setDataIntoExcel("openAcc", 5, 2, accountNo);

		Assert.assertEquals(AccountNoText.contains("Account Created Successfully"), true);
		Reporter.log(">>>Account Created successfully and Account No: " + accountNo + "<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Account Created successfully<<<");

		wlib.switchtoAlertAndAccept(driver);

		aap.getLogoutBtn().click();

	}

	@Test(priority = 3)
	public void creditCustomerTest() throws Throwable {
		homePage hp = new homePage(driver);
		staffLoginPage sp = new staffLoginPage(driver);
		staffHomePage shp = new staffHomePage(driver);
		creditCustomerPage ccp = new creditCustomerPage(driver);

		hp.getStaffLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Login Page Displayed<<<");
		sp.getStaffIdTextField().sendKeys(fLib.getDataFromPropertiesFile("staffID"));
		sp.getPasswordTextField().sendKeys(fLib.getDataFromPropertiesFile("password"));
		sp.getLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Home Page Displayed<<<");

		shp.getCreditCustomerBtn().click();

		ListImpClass.test.log(Status.INFO, ">>>Credit Customer Page Displayed<<<");

		ccp.getCustAccNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 2));
		ccp.getCreditAmountTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 18));
		ccp.getSubmitBtn().click();

		String creditText = wlib.switchtoAlertAndGetData(driver);

		wlib.switchtoAlertAndAccept(driver);
		Assert.assertEquals(creditText.contains("Amount credited Successfully"), true);
		Reporter.log(">>>Amount Credited Successfully<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Amount Credited Successfully<<<");

		ccp.getLogoutBtn().click();

		sp.getHomeBtn().click();

	}

}