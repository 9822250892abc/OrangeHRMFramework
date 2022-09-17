package com.vtechsolution01.orangehrm.testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtechsolution01.orangehrm.pageobject.Loginpage;
import com.vtechsolution01.orangehrm.testbase.Test_Base;
import com.vtechsolution01.orangehrm.utility.ExcelDataProvider;
public class LoginTC_03 extends Test_Base{
	
	
	@Test(dataProvider="getData")	
	public void verifylogin(String username, String password) {
		
		Loginpage login = new Loginpage(driver);
		login.setUsername(username);
		login.setPassword(password);
		
		login.clickonLoginbutton();
		
		if (driver.getPageSource().contains("Dashboard")) {
			Assert.assertTrue(true);
			System.out.println("Login success !!!");
		} 
		else if(driver.getPageSource().contains("Invalid credentials")) {
			Assert.assertTrue(true);
			System.out.println("Entered Invalid credentials Login should fail!!!");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Login Success !!!");
		}
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = ExcelDataProvider.getExcelData("Login1");
		return data;
	}

}
