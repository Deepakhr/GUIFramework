package com.dolibarr.erp.customertest;
/**
 * @author REKHA GUPTA
 * Create New Customer and create new Proposal for customer and Validate Proposal 
 */

import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.HomePage;

public class CreateNewCustomerWithNewProposalAndValidateProposalTest extends BaseClass 
{
	@Test
	 public void createCustomer() throws Throwable
	 {
		String CName = eLib.getDataFromExcel("ThirdParty",1, 2) + jLib.getRandomNumber();
        HomePage hp= new HomePage(driver);
        hp.clickOnThirdPartiesMenu();
        
	 }
	
	

}
