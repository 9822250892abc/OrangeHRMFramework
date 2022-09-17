package com.vtechsolution01.orangehrm.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver driver;

	public Loginpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//

	@FindBy(id = "userName")
WebElement usernameTxt;
	
	

	@FindBy(id = "password")
	WebElement txtPassword;
	

	@FindBy(xpath = "//*[@id=\"login\"]")
   WebElement btnLogin;
	
	

	@FindBy(xpath = "//*[@id=\"app\"]/header/a/img")
	// @FindBy(xpath = "//div[@id='divLogo']/img")
	WebElement imgLogo;

	
	public boolean verifyToolsQALogo()
	
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
			
//		
		btnLogin.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
