package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or container will keep all locators & methods in this class
	@FindBy(xpath="//input[@name='categorydata']")
	WebElement UserInformation;
	@FindBy(xpath="//input[@value='Add category']")
	WebElement Add_Category;
	
	@FindBy(xpath="//button[@onclick='myFunctionSky()']")
	WebElement SetSkyBlueButton;
	
	@FindBy(xpath="//body[@style='background-color: skyblue;']")
	WebElement SkyBlue;
	
	@FindBy(xpath="//body[@style=\"background-color: white;\"]")
	WebElement White;
	
	
	@FindBy(xpath="//button[@onclick='myFunctionWhite()']")
	WebElement SetWhiteBackground;
		
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, 45);
		}
		public void verifyLogin() {
			wait.until(ExpectedConditions.visibilityOf(UserInformation));
			UserInformation.sendKeys("Trail and Error");
			Add_Category.click();
		}
		public void setSkyBluebackground() {
			wait.until(ExpectedConditions.visibilityOf(SetSkyBlueButton));
			SetSkyBlueButton.click();
		}
		
		public boolean VerifySkyBluebackground() {
			return SkyBlue.isDisplayed();
		}
		
		public boolean setBackgroundToWhite() {
			wait.until(ExpectedConditions.visibilityOf(SetWhiteBackground));
			SetWhiteBackground.click();
			return White.isDisplayed();
			
		}
	}
	
		

