package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  
public class HomePage extends WebDriverUtility{                             
                           
	WebDriver driver;
	 public HomePage(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	public void logout() {
		
	}

	@FindBy (id="mainmenua_companies")
	private WebElement ThirdPartiesLink;
	
	public WebElement getThirdPartiesLink() 
	{
		return ThirdPartiesLink;
	}
	
	

	
	
}
