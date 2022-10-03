package com.vtechsolution01.orangehrm.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtechsolution01.orangehrm.utility.ConfigDataProvider;
import com.vtechsolution01.orangehrm.utility.ConstantVarriable;
import com.vtechsolution01.orangehrm.utility.ExcelDataProvider;
import com.vtechsolution01.orangehrm.utility.Helper;

//simport io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Base {

	public static ConfigDataProvider configDataProvider;
	public static ExcelDataProvider excelDataProvider;
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;

	public WebDriver driver;

	@BeforeSuite
	public void init() throws Exception {
		System.out.println("Hi");
		configDataProvider = new ConfigDataProvider(ConstantVarriable.ConfigDataProvider);
		excelDataProvider = new ExcelDataProvider(ConstantVarriable.excelPath);

		extentHtmlReporter = new ExtentHtmlReporter("./Report/freecrm_"+Helper.getCurrentDateTime()+".html");
		extentHtmlReporter.config().setDocumentTitle("Automation Test Report");
		extentHtmlReporter.config().setReportName("RT Test Report");
		extentHtmlReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("hostname", "localhost");
		extentReports.setSystemInfo("OS", "Windows");
		extentReports.setSystemInfo("browser", "Chrome");
		extentReports.setSystemInfo("BE", "pradeep");
		extentReports.setSystemInfo("Test Case", "RT");

	}

	// @Parameters({ "brname", "appUrl" })
//	public void setUp(@Optional("chrome") String brwoser,
//			@Optional("https://opensource-demo.orangehrmlive.com/") String url) {
//
//		if (brwoser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
//			driver = new ChromeDriver();
//		}
//
//		else if (brwoser.equals("firefox")) {
//
//			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
//			driver = new FirefoxDriver();
//		}

	@BeforeTest
	@Parameters("{brname}")
	public void setUp(@Optional("Chrome") String brwoser) {

		if (brwoser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (brwoser.equals("FireFox")) {

			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("Browser exe dose not match with existing browser..");
		}
		driver.manage().window().maximize();
		driver.get(configDataProvider.getAppUrl());
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void TearDown(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			Thread.sleep(1000);
			extentTest.log(Status.FAIL, " TEST CASE FAILED "+ result.getName());
			//Helper.captureScreenshot(driver);
			extentTest.fail("Test Case Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "TEST CASE PASS"+ result.getName());
		}

	}

	@AfterTest
	public void ExtendFlush() {

		extentReports.flush();

	}

}