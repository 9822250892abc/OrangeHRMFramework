package com.vtechsolution01.orangehrm.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolution01.orangehrm.pageobject.Loginpage;
import com.vtechsolution01.orangehrm.testbase.Test_Base;

public class LoginTest_001 extends Test_Base {

	Loginpage lp;

	@Test(priority = 1)
	public void verifyLoginPageTC() {
		if (driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			System.out.println("Login Tital Is Displyaed");
		}

		else {
			System.out.println("Login Tital Is not Displyed");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void verifyOrangeHrmLogoTC() {
		lp = new Loginpage(driver);
		if (lp.verifyToolsQALogo()) {
			Assert.assertTrue(true);
			System.out.println("OrangeHRM Logo is displayed on login page");
		} else {
			Assert.assertTrue(false);
			System.out.println("OrangeHRM Logo is not displayed on login page");
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
		lp = new Loginpage(driver);
		lp.setUsername(configDataProvider.getUserName());
		lp.setPassword(configDataProvider.getPassword());
		lp.clickonLoginbutton();

		if (driver.getPageSource().contains("viewport")) {
			Assert.assertTrue(true);
			System.out.println("Login Susses...");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login fail....");
		}
	}

}
