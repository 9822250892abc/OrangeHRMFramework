package com.vtechsolution01.orangehrm.testbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vtechsolution01.orangehrm.utility.ConfigDataProvider;
import com.vtechsolution01.orangehrm.utility.ConstantVarriable;
import com.vtechsolution01.orangehrm.utility.ExcelDataProvider;

public class Test_Base {

	public static ConfigDataProvider configDataProvider;
	public static ExcelDataProvider excelDataProvider;

	public WebDriver driver;

	@BeforeSuite
	public void init() throws Exception {
		System.out.println("Hi");
		configDataProvider = new ConfigDataProvider(ConstantVarriable.ConfigDataProvider);
		excelDataProvider = new ExcelDataProvider(ConstantVarriable.excelPath);
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

	}

	@AfterTest
	public void TearDown() throws InterruptedException {
		Thread.sleep(5000);
		 driver.quit();
	}

}