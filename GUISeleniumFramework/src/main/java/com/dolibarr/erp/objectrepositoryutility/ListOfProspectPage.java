package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfProspectPage {
	public ListOfProspectPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="search_nom")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	public void getSearch(String Name) {
		getSearch().sendKeys(Name,Keys.ENTER);
	
	}

}
