package com.dolibarr.erp.prospectTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.dolibarr.erp.generic.basetest.BaseClass;
import com.dolibarr.erp.objectrepositoryutility.HomePage;
import com.dolibarr.erp.objectrepositoryutility.ListOfProspectPage;
import com.dolibarr.erp.objectrepositoryutility.NewThirdPartyPage;
import com.dolibarr.erp.objectrepositoryutility.Third_PartiesPage;
import com.dolibarr.erp.objectrepositoryutility.prosepectInfoTest;
import com.dolibarr.erp.objectrepositoryutility.prospectPage;

public class createContractandActivateConTest extends BaseClass{
@Test
public void createContractandActivateConTest() throws Throwable  {
	String PName=eLib.getDataFromExcel("ThirdParty", 4, 2)+jLib.getRandomNumber();
	String city=eLib.getDataFromExcel("ThirdParty", 4, 3);
	HomePage h=new HomePage(driver);
	h.getThirdPartiesMenu().click();
	Third_PartiesPage t=new Third_PartiesPage(driver);
	t.getNewProspectLink().click();
	NewThirdPartyPage ntp=new NewThirdPartyPage(driver);
	ntp.getThirdPartyNameTextField().sendKeys(PName);
	Thread.sleep(2000);
	ntp.getSelectCustomerProspect().click();
	Thread.sleep(2000);
	ntp.getProspect().click();
	Thread.sleep(2000);
	ntp.getCityTextField().sendKeys(city);
	ntp.getCreateThirdPartyButton().click();
	t.getListOfProspectsLink().click();
	ListOfProspectPage lpp=new ListOfProspectPage(driver);
	lpp.getSearch().sendKeys(PName,Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='"+PName+"'")).click();
	prosepectInfoTest pi=new prosepectInfoTest(driver);
	pi.getProspectInfo().click();
	prospectPage pp=new prospectPage(driver);
	pp.getCreateContract().click();
}
}
