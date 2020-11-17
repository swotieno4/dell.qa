package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductNServicePage;
import com.TestUtil.TestUtil;

public class ProductNServicePageTest extends TestBase{
	
	LoginPage loginpage;
	ProductNServicePage productNServicePage;
	
	String SheetName ="Sheet1";
	
public ProductNServicePageTest() {
		
		super();
	}

	@BeforeMethod
	public void SetUp() {
	initil();
		
	productNServicePage = new ProductNServicePage();
	loginpage = new LoginPage();
		
	loginpage.verifyLogin(prop.getProperty("UserName"),prop.getProperty("Password"));	
	}
	
	@DataProvider
	public Object [][] excel(){
		Object [][] data = TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(dataProvider="excel")
	public void CreateNewOrder(String NAME, String SALESPRICE, String ITEMNUMBER, String DESCRIPTION) throws Exception {
		
		productNServicePage.ProductNservice();
		productNServicePage.NewService();
		productNServicePage.NewOrder(NAME, SALESPRICE, ITEMNUMBER, DESCRIPTION);

		boolean Message = productNServicePage.ValidateSuccessMessage();
		Assert.assertTrue(Message);
	}
	
		
	@AfterMethod
public void Teardown() {
		driver.quit();
	}
}