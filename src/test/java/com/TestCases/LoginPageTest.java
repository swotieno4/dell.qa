package com.TestCases;



import org.testng.Assert;
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
		@Test(description="This will test login feature")
		public void VerifyLoginPage() {
			
		loginpage.verifyLogin(prop.getProperty("UserName"),prop.getProperty("Password"));
		
		}
		
		@Test(description="THis will verify logo")
		public void VerifyLogoofThePage() {
		boolean logo = loginpage.verifyLogo();
		Assert.assertTrue(logo);
		TestUtil.screenShot(driver, "Logo");
		}
		@Test(description="this will verify title of login page")
		public void VerifyTitleofThePage() {
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
		TestUtil.screenShot(driver, "Title");
		}
		@Test(description="Verify login error message")
		public void verifyErrorMessagewithinvaliduspw() throws Exception {
		loginpage.ErrorMessage(prop.getProperty("invalidUser"), prop.getProperty("invalidPassword"));
			
		Thread.sleep(5000);
			
		boolean er = loginpage.VerifyError();
		Assert.assertTrue(er);
			
		System.out.println("The Error Message" + er);
		
		}
		
		@AfterMethod
		public void Teardown() {
		driver.quit();
			
		}
	}

