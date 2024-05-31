package com.hsbc.bfsi.deleteAccount;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.deleteAccountPage;
import com.comcast.crm.objectrepositoryutility.homePage;
import com.comcast.crm.objectrepositoryutility.staffHomePage;
import com.comcast.crm.objectrepositoryutility.staffLoginPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class deleteAccountTest extends BaseClass  {

	@Test(priority = 10)
	public void deleteAccTest() throws Throwable {
		homePage hp=new homePage(driver);
		staffLoginPage sp=new staffLoginPage(driver);
		staffHomePage shp=new staffHomePage(driver);
		deleteAccountPage dap=new  deleteAccountPage(driver);
		
		hp.getStaffLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Login Page Displayed<<<");
		
		sp.getStaffIdTextField().sendKeys(fLib.getDataFromPropertiesFile("staffID"));
		sp.getPasswordTextField().sendKeys(fLib.getDataFromPropertiesFile("password"));
		sp.getLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Home Page Displayed<<<");
		
		shp.getDeleteCustomerBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Delete Customer Account Page Displayed<<<");
		
		dap.getCustAccNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 2));
		dap.getCustIDTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 5));
		dap.getReasonTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 20));
		dap.getDeleteBtn().click();
		
		String deleteAccText = wlib.switchtoAlertAndGetData(driver);
		Assert.assertEquals(deleteAccText.contains("Customer Deleted Successfully"), true);
		Reporter.log(">>>Account Deleted Successfully!!!<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Account Deleted Successfully!!!<<<");
		
		wlib.switchtoAlertAndAccept(driver);
		
		dap.getLogoutBtn().click();
		
		sp.getHomeBtn().click();  
		
	}
}
