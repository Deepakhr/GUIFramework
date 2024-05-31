package com.hsbc.bfsi.internetBanking;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.homePage;
import com.comcast.crm.objectrepositoryutility.internetBankingHoverPage;
import com.comcast.crm.objectrepositoryutility.internetBankingRegistrationPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class registerInternetBankingTest extends BaseClass {

	@Test(priority = 6)
	public void registerTest() throws Throwable {
		homePage hp=new homePage(driver);
		internetBankingHoverPage ihp=new internetBankingHoverPage(driver);
		internetBankingRegistrationPage irp=new internetBankingRegistrationPage(driver);
		
		WebElement ele = hp.getInternetBankingBtn();
		wlib.mousemoveOnElement(driver, ele);
		ihp.getRegisterBtn().click();
		
		ListImpClass.test.log(Status.INFO, ">>>Internet Banking Registration Page Displayed<<<");
		
		irp.getAccHolderNameTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 0));
		irp.getAccNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 2));
		irp.getDebitCardNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 3));
		irp.getDebitCardPinTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 4));
		irp.getMobileNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 2));
		irp.getPanCardNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 6));
		irp.getDobTextField().click();
		irp.getDobTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 5));
		irp.getLastTransactionTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 18));
		irp.getPasswordTextField().sendKeys(eLib.getDataFromExcel("openAcc",1, 17));
		irp.getConfirmPassTextField().sendKeys(eLib.getDataFromExcel("openAcc",1, 17));
		irp.getSubmitBtn().click();
		
		
		
		String customerIdText = wlib.switchtoAlertAndGetData(driver);
		String customerId = jLib.getDigitFromText(customerIdText);
		
		Assert.assertEquals(customerIdText.contains("Registration Successfull"), true);
		Reporter.log(">>>Registration Successfull and Customer ID:"+customerId+"<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Registration Successfull<<<");
		
		eLib.setDataIntoExcel("openAcc", 5, 5, customerId);
		
		wlib.switchtoAlertAndAccept(driver);
		
		irp.getHomeBtn().click();
		
	}
}
