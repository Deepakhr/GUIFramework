package com.hsbc.bfsi.openAccount;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.homePage;
import com.comcast.crm.objectrepositoryutility.staffHomePage;
import com.comcast.crm.objectrepositoryutility.staffLoginPage;
import com.comcast.crm.objectrepositoryutility.viewCustomerPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class searchCustomerTest extends BaseClass {

	
	@Test(priority = 4)
	public void viewCustomerByAccNoTest() throws Throwable {
		homePage hp=new homePage(driver);
		staffLoginPage sp=new staffLoginPage(driver);
		staffHomePage shp=new staffHomePage(driver);
		viewCustomerPage vcp=new viewCustomerPage(driver);
		
		hp.getStaffLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Login Page Displayed<<<");
		sp.getStaffIdTextField().sendKeys(fLib.getDataFromPropertiesFile("staffID"));
		sp.getPasswordTextField().sendKeys(fLib.getDataFromPropertiesFile("password"));
		sp.getLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Home Page Displayed<<<");
		
		shp.getViewCustBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>View Customer By Account Number Page Displayed<<<");
		
		vcp.getAccNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 2));
		vcp.getSubmitBtn().click();
		
		String accountNo = vcp.getAccountNoDetails().getText();
		Assert.assertEquals(accountNo.contains(eLib.getDataFromExcel("openAcc", 5, 2)), true);
		Reporter.log(">>>Account Number Verified Successfully<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Account Number Verified Successfully<<<");
		
		vcp.getLogoutBtn().click();
		
		sp.getHomeBtn().click();
		
		
	}
}
