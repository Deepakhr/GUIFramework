package com.dolibarr.erp.prospectTest;

/**
 * @author anusha
 */

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CommercialInfoPage;

import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.NewCommercialProposalPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;

import com.dolibarr.erp.objectrepositoryutility.prosepectInfoTest;
import com.dolibarr.erp.objectrepositoryutility.prospectPage;

/**
 * This method used to create prospect
 */
public class createProspectTest extends BaseClass {
	@Test
	public void createProspect() throws Throwable {
		String PName = eLib.getDataFromExcel("ThirdParty", 4, 2) + jLib.getRandomNumber();
		String city = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String refcus = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String date = jLib.getRequriedDateYYYYDDMM(15);
		String statusmsg = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String statusmsg1 = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String discription = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String Nprice = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String PwithTax = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String qty = eLib.getDataFromExcel("ThirdParty", 4, 3);
		String dis = eLib.getDataFromExcel("ThirdParty", 4, 3);

		HomePage h = new HomePage(driver);
		h.getThirdPartiesMenu().click();
		Third_PartiesPage t = new Third_PartiesPage(driver);
		t.getNewProspectLink().click();
		NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
		ntp.getThirdPartyNameTextField().sendKeys(PName);
		Thread.sleep(2000);
		ntp.getSelectCustomerProspect().click();
		Thread.sleep(2000);
		ntp.getProspect().click();
		Thread.sleep(2000);
		ntp.getCityTextField().sendKeys(city);
		ntp.getCreateThirdPartyButton().click();
		prosepectInfoTest pi = new prosepectInfoTest(driver);
		pi.getProspectInfo().click();
		prospectPage pp = new prospectPage(driver);
		pp.getCreateProposal().click();
		NewCommercialProposalPage ncpp = new NewCommercialProposalPage(driver);
		ncpp.createProposal(refcus, date);
		CommercialInfoPage cpip = new CommercialInfoPage(driver);
		String actmsg = cpip.getStatus().getText();
		Assert.assertEquals(actmsg, statusmsg);
		cpip.addLine(discription, Nprice, qty, dis);
		String actMsg1 = cpip.getValidateafter().getText();
		Assert.assertEquals(actMsg1, statusmsg1);
	}

}
