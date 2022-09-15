package com.vtechsolution01.orangehrm.pageobject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {

	WebDriver driver;

	public Loginpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//

	//@FindBy(id = "userName")
	//WebElement usernameTxt;
	
	@FindBy(xpath = "//input[@name='username' or @placeholder='Username']")
	WebElement usernameTxt;

	//@FindBy(id = "password")
	//WebElement txtPassword;
	
	@FindBy(xpath = "//input[@name='password' or @placeholder='Password']")
	WebElement txtPassword;

	//@FindBy(xpath = "//*[@id=\"login\"]")
   // WebElement btnLogin;
	
	@FindBy(xpath = "//button[@type='submit' or text()='Login']")
	WebElement btnLogin;

	//@FindBy(xpath = "//*[@id=\"app\"]/header/a/img")
	// @FindBy(xpath = "//div[@id='divLogo']/img")
	//WebElement imgLogo;

	@FindBy(xpath = "//img[@src='/web/images/ohrm_branding.png?1660914792648']")
	WebElement imgLogo;
	//public boolean verifyToolsQALogo()
	public boolean verifyOrangeHHrmLogo()
	{
		try {
			return imgLogo.isDisplayed();
		} catch (Exception e) {
	       System.out.println(e.getMessage());
			return false;
		}
	}

	public void setUsername(String username)

	{
		try {
			usernameTxt.clear();
			usernameTxt.sendKeys(username);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public void setPassword(String password) {
		try {
			txtPassword.clear();
			txtPassword.sendKeys(password);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickonLoginbutton() {
		try {

	//		Actions action=new Actions(driver);
	//		action.moveToElement(btnLogin).build().perform();
			JavascriptExecutor jse = (JavascriptExecutor)driver;

		//	jse.executeScript("scroll(250, 0)"); // if the element is on top.

			jse.executeScript("scroll(0, 250)");
		//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		//    wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
			
		
		btnLogin.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
