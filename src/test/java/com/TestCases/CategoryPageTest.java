package com.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.CategoryPage;
import com.TestPages.LoginPage;
import com.TestPages.MonthsPages;
import com.TestUtil.TestUtil;

import junit.framework.Assert;

public class CategoryPageTest extends TestBase{
	
	MonthsPages monthspages;	
	LoginPage loginpage;
	CategoryPage categorypage;
	
	
		public CategoryPageTest() {
			
			super();
		}
		
		@BeforeMethod
		
		public void SetUp() {
		initil();
		categorypage = new CategoryPage();
		monthspages = new MonthsPages();
		loginpage = new LoginPage();
			
		}
		@Test(priority=1)
		public void BlueBackground() {
			
			loginpage.setSkyBluebackground(); //Clicking on button to set background
			boolean blue = loginpage.VerifySkyBluebackground(); //Asking if this is displayed
			Assert.assertTrue(blue); // I want this to be true so I assert true
			TestUtil.screenShot(driver, "Bluebackground");
			}
		
		@Test (priority=2)
		public void WhiteBackground() {
			loginpage.setBackgroundToWhite();
			boolean white = loginpage.setBackgroundToWhite();
			Assert.assertTrue(white);
			TestUtil.screenShot(driver, "Whitebackground");
			}

		@Test(priority=5)
		public void verifytheTwelveMonths() {
		boolean verify = monthspages.selectFromdropdown();
		Assert.assertTrue(verify);
		}
		
		@Test(priority=3,description="Add a new category. Verify Category was created.")
		public void verifyNewCategoryCreated() {
			categorypage.Add_Category();
			Assert.assertTrue(categorypage.VerifyNewCategory());
		}
		
		@Test(priority=4)
		public void verifyErrorCreated() {
			categorypage.Add_Category1();
			boolean verify = categorypage.VerifyError();
			Assert.assertTrue(verify);
		}
		
		@AfterMethod
	public void Teardown() {
			driver.quit();
		}
	}


