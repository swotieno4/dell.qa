package com.TestCases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	
	public LoginPageTest() {
		
		super();
	}	
		@BeforeMethod
		
		public void SetUp() {
		initil();
		loginpage = new LoginPage();
			
			
		}
		public void verifyLoginPage() {
			
			loginpage.verifyLogin();
		}
		@Test
		public void BlueBackground() {
			 loginpage.setSkyBluebackground();
			 TestUtil.screenShot(driver, "Bluebackground");
			 
			}
		
		@Test 
		public void WhiteBackground() {
			loginpage.setBackgroundToWhite();
			TestUtil.screenShot(driver, "Whitebackground");
			}

		@AfterMethod
		public void Teardown() {
		driver.quit();
			
		}
	}

