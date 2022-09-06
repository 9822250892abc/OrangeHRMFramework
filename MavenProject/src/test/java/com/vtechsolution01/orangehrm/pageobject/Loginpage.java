package com.vtechsolution01.orangehrm.pageobject;

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

	// Repository

	@FindBy(id = "userName")
	WebElement usernameTxt;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//*[@id=\"login\"]")

	WebElement btnLogin;

	@FindBy(xpath = "//*[@id=\"app\"]/header/a/img")
	// @FindBy(xpath = "//div[@id='divLogo']/img")
	WebElement imgLogo;

	public boolean verifyToolsQALogo() {
		try {
			return imgLogo.isDisplayed();
		} catch (Exception e) {
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
			e.getMessage();
		}
	}

	public void clickonLoginbutton() {
		try {

			btnLogin.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
