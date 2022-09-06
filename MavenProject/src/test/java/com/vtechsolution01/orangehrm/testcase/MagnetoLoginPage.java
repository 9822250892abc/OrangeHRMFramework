package com.vtechsolution01.orangehrm.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MagnetoLoginPage {
	
	@Test
	public void Login() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	
		driver.get("https://magento.softwaretestingboard.com/");
		String logosrc=driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).getAttribute("src");
		Assert.assertEquals("https://magento.softwaretestingboard.com/pub/static/version1661709085/frontend/Magento/luma/en_US/images/logo.svg",
				logosrc);
	    driver.findElement(By.linkText("Sign In")).click();
	    
	    driver.findElement(By.id("email")).sendKeys("roni_cost@example.com");
	    driver.findElement(By.id("pass")).sendKeys("roni_cost3@example.com");
	}

}
