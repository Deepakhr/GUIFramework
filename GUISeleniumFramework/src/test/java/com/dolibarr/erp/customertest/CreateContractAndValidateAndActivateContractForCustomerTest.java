package com.dolibarr.erp.customertest;
/**
 * @author REKHA GUPTA
 * Create a new contract for customer and validate the contract and activate contract for customer
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.CustomerInfoPage;
import com.dolibarr.erp.objectrepositoryutility.CustomerPage;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.ListOfCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewContractForCustomerPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;

public class CreateContractAndValidateAndActivateContractForCustomerTest extends BaseClass {
	
	@Test
	public void createContract() throws Throwable
	{
		/**
		 * Fetching data from Excel
		 */
		String CName = eLib.getDataFromExcel("ThirdParty",1, 2) + jLib.getRandomNumber();
		String CityName = eLib.getDataFromExcel("ThirdParty",1, 3);
		String RefCust = eLib.getDataFromExcel("ThirdParty",1, 4) + jLib.getRandomNumber();
		String status = eLib.getDataFromExcel("ThirdParty",1, 11);
		/**
		 * Navigating to Third-Parties Menu
		 */
        HomePage hp= new HomePage(driver);
        hp.clickOnThirdPartiesMenu();
        /**
         * Creating new customer
         */
        NewThirdPartyPage ntp = new NewThirdPartyPage(driver);
        ntp.getThirdPartyNameTextField().sendKeys(CName);
        ntp.getSelectCustomerProspect().click();
        ntp.getSelectCustomer().click();
        ntp.getCityTextField().sendKeys(CityName);
        ntp.getCreateThirdPartyButton().click();
        /**
         * Navigating to list of customer link
         */
        Third_PartiesPage tpp = new Third_PartiesPage(driver);
        tpp.getListOfCustomersLink().click();
        ListOfCustomerPage lcp= new ListOfCustomerPage(driver);
        lcp.getSearchCust().sendKeys(CName,Keys.ENTER);
        driver.findElement(By.xpath("//a[text()='"+ CName +"']")).click();
        /**
         * Navigate to customer link
         */
        CustomerInfoPage cip= new CustomerInfoPage(driver);
        cip.getCustomerLink().click();
        /**
         * Click on create contract link
         */
        CustomerPage cp= new CustomerPage(driver);
        cp.getCreateContractLink().click();
        /**
         * create contract
         */
        NewContractForCustomerPage nccp= new NewContractForCustomerPage(driver);
        nccp.getRefCust().sendKeys(RefCust);
        nccp.getCreateButton().click();
        /**
         * Verify the status 
         */
        
        
		
	}
	

}
