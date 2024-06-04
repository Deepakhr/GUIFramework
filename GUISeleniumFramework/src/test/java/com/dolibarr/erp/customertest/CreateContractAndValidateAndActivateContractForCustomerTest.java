package com.dolibarr.erp.customertest;
/**
 * @author REKHA GUPTA
 * Create a new contract for customer and validate the contract and activate contract for customer
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;

public class CreateContractAndValidateAndActivateContractForCustomerTest extends BaseClass {
	
	@Test
	public void createContract() throws Throwable
	{
		/**
		 * Fetching data from Excel
		 */
		String CName = eLib.getDataFromExcel("ThirdParty",1, 2) + jLib.getRandomNumber();
		
		/**
		 * Navigating to Third-Parties Menu
		 */
        HomePage hp= new HomePage(driver);
        hp.clickOnThirdPartiesMenu();
        /**
         * Navigating to list of customer link
         */
        Third_PartiesPage tpp = new Third_PartiesPage(driver);
        tpp.getListOfCustomersLink().click();
        WebElement searchTextField = driver.findElement(By.xpath("//input[@name='search_nom']"));
        searchTextField.sendKeys(CName,Keys.ENTER);
      
        
		
	}
	

}
