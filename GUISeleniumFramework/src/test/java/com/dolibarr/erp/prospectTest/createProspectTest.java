package com.dolibarr.erp.prospectTest;
/**
 * @author anusha
 */

import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;
/**
 * This method used to create prospect
 */
public class createProspectTest extends BaseClass {
	@Test
	public void createProspect() {
		HomePage h=new HomePage(driver);
		h.getThirdPartiesMenu().click();
		Third_PartiesPage t=new Third_PartiesPage(driver);
		t.getNewProspectLink().click();
		NewThirdPartyPage ntp=new NewThirdPartyPage(driver);
		
	}

}
