package com.hsbc.bfsi.applyDebitCard;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.debitCardPage;
import com.comcast.crm.objectrepositoryutility.homePage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class applyDebitCardTest extends BaseClass {

	@Test(priority = 5)
	public void applyDebitTest() throws Throwable {
		homePage hp=new homePage(driver);
		debitCardPage dp=new debitCardPage(driver);
		
		
		hp.getApplyDebitCardBtn().click();
		ListImpClass.test.log(Status.INFO, ">>>Apply Debit Card Page Displayed<<<");
		dp.getAccountHolderNameTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 0));
		dp.getDobTextField().click();
		dp.getDobTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 5));
		dp.getPanTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 6));
		dp.getMobileNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 1, 2));
		dp.getAccountNoTextField().sendKeys(eLib.getDataFromExcel("openAcc", 5, 2));
		dp.getDebitCardSubmitBtn().click();
		
		String debitText = wlib.switchtoAlertAndGetData(driver);
		String debitcardCombineno = jLib.getDigitFromText(debitText);
		
		String Pin = debitcardCombineno.substring(debitcardCombineno.length()-4,debitcardCombineno.length());
		String debitCardNo = debitcardCombineno.substring(0,debitcardCombineno.length()-4);
		Assert.assertEquals(debitText.contains("Debit Card issued successfully"), true);
		Reporter.log(">>>Debit Card Isseud Successfully and Debit Card No:"+debitCardNo+" and Pin: "+Pin+"<<<", true);
		ListImpClass.test.log(Status.PASS, ">>>Debit Card Isseud Successfully<<<");
		
		eLib.setDataIntoExcel("openAcc", 5, 3, debitCardNo);
		eLib.setDataIntoExcel("openAcc", 5, 4, Pin);
		wlib.switchtoAlertAndAccept(driver);
		
	
		dp.getHomeBtn().click();
		
		
	}
}
