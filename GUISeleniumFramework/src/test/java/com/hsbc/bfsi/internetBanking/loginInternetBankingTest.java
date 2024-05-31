package com.hsbc.bfsi.internetBanking;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.customerHomePage;
import com.comcast.crm.objectrepositoryutility.homePage;
import com.comcast.crm.objectrepositoryutility.internetBankingHoverPage;
import com.comcast.crm.objectrepositoryutility.internetBankingLoginPage;
import com.comcast.crm.objectrepositoryutility.internetBankingRegistrationPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class loginInternetBankingTest extends BaseClass {

	@Test(priority = 7)
	public void loginTest() throws Throwable {
		homePage hp = new homePage(driver);
		internetBankingHoverPage ihp = new internetBankingHoverPage(driver);
		internetBankingLoginPage ilp = new internetBankingLoginPage(driver);
		customerHomePage chp = new customerHomePage(driver);

		WebElement ele = hp.getInternetBankingBtn();
		wlib.mousemoveOnElement(driver, ele);
		ihp.getLoginBtn().click();

		ListImpClass.test.log(Status.INFO, ">>>Internet Banking Login Page Displayed<<<");
		
		ilp.getCustomerIdTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 5));
		ilp.getPasswordTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 17));
		ilp.getLoginBtn().click();

		String welcomeText = chp.getWelcomeText().getText();

		Assert.assertEquals(welcomeText.contains("Welcome"), true);
		Reporter.log(">>>Login Successfull<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Login Successfull<<<");
		
		
		chp.getLogoutBtn().click();

		ilp.getHomeBtn().click();

	}
}
