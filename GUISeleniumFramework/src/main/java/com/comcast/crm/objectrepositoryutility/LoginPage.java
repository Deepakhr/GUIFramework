package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


 /**
  * 
  * @author Akash Deb
  *
  */
public class LoginPage{
	WebDriver driver;
	public LoginPage(WebDriver driver)  //this constructor will take care of initialization
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement ele_usn;

	@FindBy(name = "user_password")
	private WebElement ele_pwd;

	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@value='Login']")})
	private WebElement loginbtn;

	public WebElement getEle_usn() {
		return ele_usn;
	}

	public WebElement getEle_pwd() {
		return ele_pwd;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	

	/**
	 * login to application based on user name, password, url arguments 
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url,String username,String password)
	{
		driver.get(url);
		ele_usn.sendKeys(username);
		ele_pwd.sendKeys(password);
		loginbtn.click();
	}

}
