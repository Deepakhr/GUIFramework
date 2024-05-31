package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class onlineAccOpeningFormPage {

	public onlineAccOpeningFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="name")
	private WebElement nameTextField;

	@FindBy(name="gender")
	private WebElement genderDropDown;

	@FindBy(name = "mobile")
	private WebElement mobileTextField;
	
	@FindBy(name="email")
	private WebElement emailTextField;
	
	@FindBy(name="landline")
	private WebElement landlineTextField;
	
	@FindBy(name="dob")
	private WebElement dobTextField;
	
	@FindBy(name="pan_no")
	private WebElement panTextField;
	
	@FindBy(name="citizenship")
	private WebElement citizenshipTextField;
	
	@FindBy(name="homeaddrs")
	private WebElement homeAddTextField;
	
	@FindBy(name = "officeaddrs")
	private WebElement ofcAddTextField;
	
	@FindBy(name="state")
	private WebElement stateDropDown;
	
	@FindBy(name="city")
	private WebElement cityDropDown;
	
	@FindBy(name = "pin")
	private WebElement pinTextField;
	
	@FindBy(name="arealoc")
	private WebElement areaLocTextField;
	
	@FindBy(name = "nominee_name")
	private WebElement nomineeNameTextField;
	
	@FindBy(name="nominee_ac_no")
	private WebElement nomineeAccNoTextField;
	
	@FindBy(name="acctype")
	private WebElement accTypeDropDown;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getLandlineTextField() {
		return landlineTextField;
	}

	public WebElement getDobTextField() {
		return dobTextField;
	}

	public WebElement getPanTextField() {
		return panTextField;
	}

	public WebElement getCitizenshipTextField() {
		return citizenshipTextField;
	}

	public WebElement getHomeAddTextField() {
		return homeAddTextField;
	}

	public WebElement getOfcAddTextField() {
		return ofcAddTextField;
	}

	public WebElement getStateDropDown() {
		return stateDropDown;
	}

	public WebElement getCityDropDown() {
		return cityDropDown;
	}

	public WebElement getPinTextField() {
		return pinTextField;
	}

	public WebElement getAreaLocTextField() {
		return areaLocTextField;
	}

	public WebElement getNomineeNameTextField() {
		return nomineeNameTextField;
	}

	public WebElement getNomineeAccNoTextField() {
		return nomineeAccNoTextField;
	}

	public WebElement getAccTypeDropDown() {
		return accTypeDropDown;
	}

	public WebElement getGenderDropDown() {
		return genderDropDown;
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}
}
