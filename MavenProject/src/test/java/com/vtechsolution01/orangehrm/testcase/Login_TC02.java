package com.vtechsolution01.orangehrm.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolution01.orangehrm.pageobject.Loginpage;
import com.vtechsolution01.orangehrm.testbase.Test_Base;
import com.vtechsolution01.orangehrm.utility.ExcelDataProvider;

public class Login_TC02 extends Test_Base {

	Loginpage lp;

	@Test
	public void loginTest() {
		
		extentTest=extentReports.createTest("loginTest");
		lp = new Loginpage(driver);
		lp.setUsername(ExcelDataProvider.getStringCellData(0, 1, 0));
		lp.setPassword(ExcelDataProvider.getStringCellData(0, 1, 1));
		lp.clickonLoginbutton();

		if (driver.getCurrentUrl().contains("profile"))
			
			{
			Assert.assertTrue(true);
			System.out.println("Login Susses...");
		} else {
			Assert.assertTrue(false);
			System.out.println("Login fail....");
		}
	}

}


		
