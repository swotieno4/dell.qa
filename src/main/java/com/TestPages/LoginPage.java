package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or container will keep all locators & methods in this class
	
		@FindBy(xpath="//input[@id=\"username\"]")
		WebElement Username;
		@FindBy(xpath="//input[@id=\"password\"]")
		WebElement Password;
		@FindBy(xpath="//button[@name=\"login\"]")
		WebElement SignInButton;
		
		@FindBy(xpath="//img[@class=\"logo\"]")
		WebElement Logo;
		// i do not have the right expath
		@FindBy(xpath="//div[@class=\"alert alert-danger fade in\"]")
		WebElement ErrorMessage;
		
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
			
		}
		
		//All Actions
		public void verifyLogin(String Un, String pw) {
			Username.sendKeys(Un);
			
			Password.sendKeys(pw);
			
			SignInButton.click();
			
		}
		public String VerifyTitle() {
		return	driver.getTitle();
			
		
		}
		public boolean verifyLogo() {
			return Logo.isDisplayed();
			
		}
	
		public void ErrorMessage(String Un, String pw) {
			
			Username.sendKeys(Un);
			
			Password.sendKeys(pw);
			SignInButton.click();
			
		}
		
		public boolean VerifyError() {
			return ErrorMessage.isDisplayed();
		}
}
