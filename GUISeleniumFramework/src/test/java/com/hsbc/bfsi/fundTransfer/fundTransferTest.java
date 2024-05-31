package com.hsbc.bfsi.fundTransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.addBenificiaryPage;
import com.comcast.crm.objectrepositoryutility.customerHomePage;
import com.comcast.crm.objectrepositoryutility.deleteBeneficiaryPage;
import com.comcast.crm.objectrepositoryutility.fundTransferPage;
import com.comcast.crm.objectrepositoryutility.homePage;
import com.comcast.crm.objectrepositoryutility.internetBankingHoverPage;
import com.comcast.crm.objectrepositoryutility.internetBankingLoginPage;
import com.comcast.crm.objectrepositoryutility.otpPage;
import com.comcast.crm.objectrepositoryutility.statementPage;
import com.comcast.crm.objectrepositoryutility.viewBeneficiaryPage;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class fundTransferTest extends BaseClass {

	@Test(priority = 8)
	public void fundsTransferTest() throws Throwable {
		homePage hp = new homePage(driver);
		internetBankingHoverPage ihp = new internetBankingHoverPage(driver);
		internetBankingLoginPage ilp = new internetBankingLoginPage(driver);
		customerHomePage chp = new customerHomePage(driver);
		fundTransferPage ftp = new fundTransferPage(driver);
		addBenificiaryPage abp = new addBenificiaryPage(driver);
		otpPage otp = new otpPage(driver);
		viewBeneficiaryPage vbp = new viewBeneficiaryPage(driver);
		deleteBeneficiaryPage dbp = new deleteBeneficiaryPage(driver);
		statementPage sp = new statementPage(driver);

//		===================login======================
		WebElement ele = hp.getInternetBankingBtn();
		wlib.mousemoveOnElement(driver, ele);
		ihp.getLoginBtn().click();

		ListImpClass.test.log(Status.INFO, ">>>Staff Login Page Displayed<<<");
		
		ilp.getCustomerIdTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 5));
		ilp.getPasswordTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 17));
		ilp.getLoginBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Staff Home Page Displayed<<<");
		

		String welcomeText = chp.getWelcomeText().getText();
		Assert.assertEquals(welcomeText.contains("Welcome"), true);
		Reporter.log(">>>Login Successfull<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Login Successful<<<");
		

//		==================add beneficiary===============
		chp.getFundTransferBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Fund Transfer Page Displayed<<<");
		
		ftp.getAddBeneficiaryBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Add Beneficiary Page Displayed<<<");
		
		abp.getBeneficiaryNameTextField().sendKeys(eLib.getDataFromExcel("fundTransfer", 1, 0));
		abp.getBeneficiaryAccNoTextField().sendKeys(eLib.getDataFromExcel("fundTransfer", 1, 1));
		abp.getIfscCodeTextField().sendKeys(eLib.getDataFromExcel("fundTransfer", 1, 2));
		wlib.select(abp.getAccTypeDropDown(), eLib.getDataFromExcel("fundTransfer", 1, 3));
		abp.getAddBeneficiaryBtn().click();

		String addBenefText = wlib.switchtoAlertAndGetData(driver);
		Assert.assertEquals(addBenefText.contains("Beneficiary Added Successfully"), true);
		Reporter.log(">>>Beneficiary Added Successfully<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Beneficiary Added Successfully<<<");
		

		wlib.switchtoAlertAndAccept(driver);
		abp.getFundTrasferBtn().click();

//		===============view beneficiary====================
		ftp.getViewBeneficiaryBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>View Beneficiary Page Displayed<<<");		
		vbp.getFundTransferBtn().click();

//		============fund transfer========================
		
		ListImpClass.test.log(Status.INFO, ">>>Fund Transfer Page Displayed<<<");
		
		String name = eLib.getDataFromExcel("fundTransfer", 1, 0);
		String accNo = eLib.getDataFromExcel("fundTransfer", 1, 1);
		String benificiaryName = name + "-" + accNo;
		wlib.select(ftp.getSelectBenificiaryDropDown(), benificiaryName);
		ftp.getAmountToTransferTextField().sendKeys(eLib.getDataFromExcel("fundTransfer", 1, 4));
		ftp.getRemarkTextFiled().sendKeys(eLib.getDataFromExcel("fundTransfer", 1, 5));
		ftp.getSendBtn().click();

//		==============OTP verification=========================
		ListImpClass.test.log(Status.INFO, ">>>OTP Verification Page Displayed<<<");
		
		String OTPCompleteText = otp.getOtpText().getText();
		String digits = jLib.getDigitFromText(OTPCompleteText);
		String OTP = digits.substring(digits.length() - 6, digits.length());
		otp.getOtpCodeTextField().sendKeys(OTP);
		otp.getVerifyBtn().click();

		String fundTransferText = wlib.switchtoAlertAndGetData(driver);
		Assert.assertEquals(fundTransferText.contains("Transaction Successful!"), true);
		Reporter.log(">>>Transaction Successful!!!<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Transaction Successful!!!<<<");
		

		wlib.switchtoAlertAndAccept(driver);

//		==============Delete beneficiary======================
		ftp.getDeleteBeneficiaryBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Delete Beneficiary Page Displayed<<<");

		String BeneficiaryAccNo = eLib.getDataFromExcel("fundTransfer", 1, 1);
		driver.findElement(By.xpath("//td[text()='" + BeneficiaryAccNo + "']/..//input[@name='radio']")).click();
		dbp.getDeleteBtn().click();

		String deleteBenefText = wlib.switchtoAlertAndGetData(driver);
		Assert.assertEquals(deleteBenefText.contains("Beneficiary Deleated Successfully"), true);
		Reporter.log(">>>Beneficiary Deleated Successfully<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Beneficiary Deleated Successfully<<<");
		
		wlib.switchtoAlertAndAccept(driver);
		wlib.switchtoAlertAndAccept(driver);
		dbp.getLogoutBtn().click();
		ilp.getHomeBtn().click();

//		================statement and balance=================

		WebElement ele1 = hp.getInternetBankingBtn();
		wlib.mousemoveOnElement(driver, ele1);
		ihp.getLoginBtn().click();

		ListImpClass.test.log(Status.INFO, ">>>Staff Login Page Displayed<<<");
		ilp.getCustomerIdTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 5));
		ilp.getPasswordTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 17));
		ilp.getLoginBtn().click();
		
		ListImpClass.test.log(Status.INFO, ">>>Staff Home Page Displayed<<<");

		chp.getStatementBtn().click();

		String Accbalance = sp.getBalanceAmount().getText();
		
		eLib.setDataIntoExcel("openAcc", 5, 6, Accbalance);
		Reporter.log(">>>Current Account Balance:"+Accbalance+"<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Current Account Balance Displayed<<<");
		sp.getLogoutBtn().click();

		ilp.getHomeBtn().click();

	}

}
