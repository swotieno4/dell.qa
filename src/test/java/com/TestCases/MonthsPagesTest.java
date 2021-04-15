package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.MonthsPages;
import com.TestUtil.TestUtil;

public class MonthsPagesTest extends TestBase{
	
MonthsPages monthspages;	
LoginPage loginpage;
	
	public MonthsPagesTest() {
		
		super();
	}
	
	@BeforeMethod
	
	public void SetUp() {
	initil();
	
	
	monthspages = new MonthsPages();
	loginpage = new LoginPage();
		
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

	@Test
	public boolean verifytheTwelveMonths() {
	monthspages.selectFromdropdown();
	Assert.assertTrue(true);
	return false;
	
	}
	@AfterMethod
public void Teardown() {
		driver.quit();
	}
}