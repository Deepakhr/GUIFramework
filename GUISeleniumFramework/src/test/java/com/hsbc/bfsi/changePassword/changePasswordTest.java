package com.hsbc.bfsi.changePassword;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.changePasswordPage;
import com.comcast.crm.objectrepositoryutility.customerHomePage;
import com.comcast.crm.objectrepositoryutility.homePage;
import com.comcast.crm.objectrepositoryutility.internetBankingHoverPage;
import com.comcast.crm.objectrepositoryutility.internetBankingLoginPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class changePasswordTest extends BaseClass {

	@Test(priority = 9)
	public void changePassTest() throws Throwable {
		homePage hp=new homePage(driver);
		internetBankingHoverPage ihp=new internetBankingHoverPage(driver);
		internetBankingLoginPage ilp=new internetBankingLoginPage(driver);
		customerHomePage chp=new customerHomePage(driver);
		changePasswordPage cpp=new changePasswordPage(driver);
		
		WebElement ele = hp.getInternetBankingBtn();
		wlib.mousemoveOnElement(driver, ele);
		ihp.getLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Login Page Displayed<<<");
		
		ilp.getCustomerIdTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 5));
		ilp.getPasswordTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 17));
		ilp.getLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Home Page Displayed<<<");
		
		chp.getChangePasswordBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Change Page Displayed<<<");
		
		
		cpp.getOldPassTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 17));
		cpp.getConfirmOldPassTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 17));
		cpp.getNewPassTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 19));
		cpp.getChangePassBtn().click();
		
		String passwordText = wlib.switchtoAlertAndGetData(driver);
		Assert.assertEquals(passwordText.contains("Password Changed Successfully!"), true);
		Reporter.log(">>>Password Changed Successfully!!!<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Password Changed Successfully!!!<<<");
		
		
		wlib.switchtoAlertAndAccept(driver);
		cpp.getLogoutBtn().click();
		
		ilp.getHomeBtn().click();
		
	}
}
