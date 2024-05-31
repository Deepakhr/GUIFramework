package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fundTransferPage {

	public fundTransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAddBeneficiaryBtn() {
		return addBeneficiaryBtn;
	}

	public WebElement getDeleteBeneficiaryBtn() {
		return deleteBeneficiaryBtn;
	}

	public WebElement getViewBeneficiaryBtn() {
		return viewBeneficiaryBtn;
	}

	public WebElement getSelectBenificiaryDropDown() {
		return selectBenificiaryDropDown;
	}

	public WebElement getAmountToTransferTextField() {
		return amountToTransferTextField;
	}

	public WebElement getRemarkTextFiled() {
		return remarkTextFiled;
	}

	public WebElement getSendBtn() {
		return sendBtn;
	}

	@FindBy(name="add_beneficiary")
	private WebElement addBeneficiaryBtn;
	
	@FindBy(name="delete_beneficiary")
	private WebElement deleteBeneficiaryBtn;
	
	@FindBy(name="view_beneficiary")
	private WebElement viewBeneficiaryBtn;
	
	@FindBy(name="beneficiary")
	private WebElement selectBenificiaryDropDown;
	
	@FindBy(name="trnsf_amount")
	private WebElement amountToTransferTextField;
	
	@FindBy(name="trnsf_remark")
	private WebElement remarkTextFiled;
	
	@FindBy(name="fnd_trns_btn")
	private WebElement sendBtn;
	
	
	
}

