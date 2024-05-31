package com.comcast.crm.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.mysql.cj.x.protobuf.MysqlxResultset.FetchSuspendedOrBuilder;

public class ListImpClass implements ITestListener , ISuiteListener{
	public ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		
		Reporter.log(">>>REPORT CONFIGURATION<<<",true);
//		test.log(Status.INFO,">>>REPORT CONFIGURATION<<<");

	    String time = 	new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("BFSI Online_Banking_System Test Suite Results");
		spark.config().setReportName("BFSI Online_Banking_System Report");
		spark.config().setTheme(Theme.DARK);
		// add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	public void onFinish(ISuite suite) {
		Reporter.log(">>>REPORT BACKUP<<<");
//		test.log(Status.INFO,">>>REPORT BACKUP<<<");
		report.flush();
		
	}

	public void onTestStart(ITestResult result) {

		Reporter.log(">>>"+result.getMethod().getMethodName()+" START<<<",true);
		test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO,">>>"+ result.getMethod().getMethodName()+" STARTED<<<");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log(">>>"+result.getMethod().getMethodName()+" END<<<",true);
		 test.log(Status.PASS,">>>"+ result.getMethod().getMethodName()+" COMPLETED<<<");

	}

	public void onTestFailure(ITestResult result) {
		String testNAme = result.getMethod().getMethodName();		
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
	    String time = 	new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testNAme+"_"+time);
		Reporter.log(">>>"+result.getMethod().getMethodName()+" FAILED<<<",true);
		 test.log(Status.FAIL,">>>"+ result.getMethod().getMethodName()+" FAILED<<<");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
