package com.vtechsolution01.orangehrm.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Helper {

	// handel normal dropdown //

	public static void selectDropdownValue(WebElement dropdown, int index) {
		new Select(dropdown).selectByIndex(index);

	}

	public static void selectDropdownValue(WebElement dropdown, String value) {
		new Select(dropdown).selectByValue(value);

	}

	public static void selectDropdownValue(String visibleText, WebElement dropdown) {
		new Select(dropdown).selectByVisibleText(visibleText);
	}

	// screen shoot//

	public static String captureScreenshot(WebDriver driver) {
		
		String screenshotpath = System.getProperty("user.dir")+"//Screenshot//freecrm_" + getCurrentDateTime() + ".png";
		try {
			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File target = new File(screenshotpath);

			org.openqa.selenium.io.FileHandler.copy(scr, target);
			System.out.println("Screenshot Captured successfully.....");
			return screenshotpath;
		} catch (IOException e) {
			System.out.println("Screenshot Captured Fail.....");
			e.printStackTrace();
			return null;
		}

	}
	
	public static String getCurrentDateTime() {
		
	DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currenDate =new Date();
	return customFormat.format(currenDate);
	
	}
	
}
