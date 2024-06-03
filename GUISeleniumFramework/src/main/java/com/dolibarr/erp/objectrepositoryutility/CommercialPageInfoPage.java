package com.dolibarr.erp.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialPageInfoPage {
	public CommercialPageInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this); 
	}
@FindBy(xpath="//span[contains(@title,'Draft')]")
private WebElement status;
@FindBy(id="prod_entry_mode_free")
private WebElement freeTextItem;
@FindBy(id="select2-select_type-container")
private WebElement type;
@FindBy(id="//li[text()='Product']")
private WebElement selectType;
@FindBy(id="dp_desc")
private WebElement description; 
@FindBy(id="price_ht")
private WebElement netPrice;
@FindBy(id="qty")
private WebElement qty;
@FindBy(id="remise_percent")
private WebElement discount;
@FindBy(id="addline")
private WebElement add;
@FindBy(linkText="Validate")
private WebElement validate;
@FindBy(xpath="//button[text()='Yes']")
private WebElement yesButton;
@FindBy(xpath="//span[starts-with(@title,'Validated')]")
private WebElement validateafter;
public WebElement getStatus() {
	return status;
}
public WebElement getFreeTextItem() {
	return freeTextItem;
}
public WebElement getType() {
	return type;
}
public WebElement getSelectType() {
	return selectType;
}
public WebElement getDescription() {
	return description;
}
public WebElement getNetPrice() {
	return netPrice;
}
public WebElement getQty() {
	return qty;
}
public WebElement getDiscount() {
	return discount;
}
public WebElement getAdd() {
	return add;
}

public WebElement getValidate() {
	return validate;
}

public WebElement getValidateafter() {
	return validateafter;
}
public void addLine(String discription,String Nprice,String qty,String dis) {
	getFreeTextItem().click();
	getType().click();
	getSelectType().click();
	getDescription().sendKeys(discription);
	getNetPrice().sendKeys(Nprice);
	 getQty().sendKeys(qty);
	 getDiscount().sendKeys(dis);
	 getAdd().click();
}
}
