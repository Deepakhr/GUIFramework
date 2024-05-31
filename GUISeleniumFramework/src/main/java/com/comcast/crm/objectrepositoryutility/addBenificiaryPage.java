package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addBenificiaryPage {
	
	public addBenificiaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBeneficiaryNameTextField() {
		return beneficiaryNameTextField;
	}

	public WebElement getBeneficiaryAccNoTextField() {
		return beneficiaryAccNoTextField;
	}

	public WebElement getIfscCodeTextField() {
		return ifscCodeTextField;
	}

	

	public WebElement getAddBeneficiaryBtn() {
		return addBeneficiaryBtn;
	}

	@FindBy(name="beneficiary_name")
	private WebElement beneficiaryNameTextField;
	
	@FindBy(name="beneficiary_acno")
	private WebElement beneficiaryAccNoTextField;
	
	@FindBy(name="Ifsc_code")
	private WebElement ifscCodeTextField;
	
	@FindBy(name="beneficiary_acc_type")
	private WebElement accTypeDropDown;
	
	public WebElement getAccTypeDropDown() {
		return accTypeDropDown;
	}

	@FindBy(name="add_beneficiary_btn")
	private WebElement addBeneficiaryBtn;
	
	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundTrasferBtn;

	public WebElement getFundTrasferBtn() {
		return fundTrasferBtn;
	}
	
}
