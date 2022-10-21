package com.vtechsolution01.orangehrm.testcase;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtechsolution01.orangehrm.pageobject.Loginpage;
import com.vtechsolution01.orangehrm.testbase.Test_Base;

public class Profile_TC04  extends Test_Base {
	
	
	
	

	Loginpage lp;

	@Test(priority = 1)
	public void verifyLoginPageTC() {
		extentTest = extentReports.createTest("verifyLoginPageTC");
		if (driver.getTitle().equals("ToolsQA"))

		{

			Assert.assertTrue(true);

			extentTest.info("Login Tital Is Displyaed");
		}

		else {
			System.out.println("Login Tital Is not Displyed");

			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void verifyToolsQALogoTC() {
		extentTest = extentReports.createTest("verifyToolsQALogoTC");

		lp = new Loginpage(driver);

		if (lp.verifyToolsQALogo())

		{
			Assert.assertTrue(true);
			System.out.println("ToolsQA Logo is displayed on login page");
			extentTest.info("ToolsQA Logo is displayed on login page");

		} else {
			System.out.println("ToolsQA Logo is not displayed on login page");
			extentTest.info("ToolsQA Logo is not displayed on login page");

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

		if (driver.getPageSource().contains("viewport"))

		{
			Assert.assertTrue(true);
			System.out.println("Login Susses..."); 
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(0, 1000)");
			

		} else {
			Assert.assertTrue(false);
			System.out.println("Login fail....");

		}
	}


	@Test(priority = 5)
public void Profile_BookList() {

//		
//				List<WebElement> Webelement=driver.findElements(By.tagName("img"));
//		
//		
//		System.out.println("Number Of Element in Table: "+Webelement.size());
//		for(int i=0;i<Webelement.size();i++) {
//			
//			System.out.println(Webelement.get(i).getText()+" "+Webelement.get(i).getAttribute("href"));
//			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		WebDriverWait some_element = new WebDriverWait(driver,20); 
//		WebElement ele = some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Go To Book Store')]")));
//		js.executeScript("scroll(0, 500)");
//		ele.click();
		
		WebDriverWait some_element = new WebDriverWait(driver,20); 
		WebElement ele = some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='gotoStore']")));
		js.executeScript("scroll(0, 500)");
		ele.click();
		
		
		
		WebDriverWait some_element1 = new WebDriverWait(driver,20); 
		WebElement ele1 = some_element1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Speaking JavaScript')]")));
		js.executeScript("scroll(0, 500)");
		ele1.click();
		
	

		WebDriverWait some_element2 = new WebDriverWait(driver,20); 
		WebElement ele2 = some_element2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add To Your Collection')]")));    
		js.executeScript("scroll(0, 500)");
		ele2.click();
		
		//WebDriverWait some_element3 = new WebDriverWait(driver,20); 
		//WebElement ele3 = some_element3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add To Your Collection')]")));    
		//js.executeScript("scroll(0, 500)");
		//ele2.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
	    wait.until(ExpectedConditions.alertIsPresent());
	    assertEquals(driver.switchTo().alert().getText(),"Book already present in the your collection!");
		driver.switchTo().alert().accept();
		
		
	}
		
		
		
	}


	
		
		



