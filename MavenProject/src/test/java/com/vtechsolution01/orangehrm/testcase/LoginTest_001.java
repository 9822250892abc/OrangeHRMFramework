package com.vtechsolution01.orangehrm.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.vtechsolution01.orangehrm.pageobject.Loginpage;
import com.vtechsolution01.orangehrm.testbase.Test_Base;

public class LoginTest_001 extends Test_Base {

	Loginpage lp;

	@Test(priority = 1)
	public void verifyLoginPageTC() {
		extentTest = extentReports.createTest("verifyLoginPageTC");
		//toolqa if (driver.getTitle().equals("ToolsQA"))
			if (driver.getTitle().equals("OrangeHRM")){
			
			Assert.assertTrue(true);
			//System.out.println("Login Tital Is Displyaed");
			extentTest.info("Login Tital Is Displyaed");
		}

		else {
			//System.out.println("Login Tital Is not Displyed");
			extentTest.info("Login Tital Is not Displyed");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
//	public void verifyToolsQALogoTC() 
	public void verifyOrangeHrmLogoTC() {
		//extentTest = extentReports.createTest("verifyToolsQALogoTC");
		extentTest = extentReports.createTest("verifyOrangeHrmLogoTC");

		lp = new Loginpage(driver);
		
		//if (lp.verifyToolsQALogo())
			if (lp.verifyOrangeHHrmLogo()){
			Assert.assertTrue(true);
			// System.out.println("ToolsQA Logo is displayed on login page");
		//	extentTest.info("ToolsQA Logo is displayed on login page");
			extentTest.info("Orange HRM Logo is displayed on login page");
		} else {
			//System.out.println("ToolsQA Logo is not displayed on login page");
		//	extentTest.info("ToolsQA Logo is not displayed on login page");
			extentTest.info("Orange HRM Logo is not displayed on login page");
			Assert.assertTrue(false);
		}

	}

//	@Test(priority = 3)
//	public void loginTest() {
//
//		lp.setUsername("Admin");
//		lp.setPassword("admin123");
//		lp.clickonLoginbutton();
//
//		if (driver.getPageSource().contains("Dashboard")) {
//			Assert.assertTrue(true);
//			System.out.println("Login Susses...");
//		} else {
//			Assert.assertTrue(false);
//			System.out.println("Login fail....");
//		}
//	}

	@Test(priority = 4)
	public void loginTest() {
		extentTest = extentReports.createTest("loginTest_01");
		
		lp = new Loginpage(driver);
		lp.setUsername(configDataProvider.getUserName());
		lp.setPassword(configDataProvider.getPassword());
		lp.clickonLoginbutton();

		//toolqa if (driver.getPageSource().contains("viewport"))
			if (driver.getPageSource().contains("Dashboard")){
			Assert.assertTrue(true);
			//System.out.println("Login Susses...");
			extentTest.info("Login Susses...");
		} else {
			Assert.assertTrue(false);
			//System.out.println("Login fail....");
			extentTest.info("Login fail...");
			
		}
	}

}
