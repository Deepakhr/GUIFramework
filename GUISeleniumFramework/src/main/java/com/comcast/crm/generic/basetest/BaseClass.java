package com.comcast.crm.generic.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.databaseutlity.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/* Create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void configBS() throws Throwable {
		Reporter.log(">>>CONNECT TO DATABASE<<<",true);
		dbLib.getDbconnection();
	}

	// @Parameters ("BROWSER")
	@BeforeClass
	public void configBC() throws Throwable {

		Reporter.log(">>>LAUNCH THE BROWSER<<<",true);
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		} else if (BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOption);
		} else if (BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOption = new EdgeOptions();
			driver = new EdgeDriver(edgeOption);
		} else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		String URL = System.getProperty("url", fLib.getDataFromPropertiesFile("url"));
		driver.get(URL);
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
	}

	@AfterMethod
	public void configAM() {
		
	}

	@AfterClass
	public void configAC() {
		System.out.println(">>>CLOSE THE BROWSER<<<");
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println(">>>CLOSE THE DATABASE<<<");
		dbLib.closeDbconnection();

	}

}
