package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.TestBase;

public class ProductNServicePage extends TestBase{
	
	@FindBy(xpath="//span[@class='nav-label'][contains(.,'Products & Services')]")
	WebElement ProductNService;
	
	@FindBy(xpath="//a[contains(.,'New Service')]")
	WebElement NewService;
	
	@FindBy(xpath="//input[@id=\"name\"]")
	WebElement TypeName;
	
	@FindBy(xpath="//input[@id=\"sales_price\"]")
	WebElement Salesprice;
	
	@FindBy(xpath="//input[@id=\"item_number\"]")
	WebElement Itemnumber;
	
	@FindBy(xpath="//textarea[@id=\"description\"]")
	WebElement Description;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement Submit;
	
	@FindBy(xpath = "//input[@type='text'][contains(@id,'price')]")
	WebElement SuccessMessage;
	
	public ProductNServicePage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 45);
	}
	
	public void ProductNservice() {
		wait.until(ExpectedConditions.visibilityOf(ProductNService));
		ProductNService.click();
	}
	public void NewService() {
		wait.until(ExpectedConditions.visibilityOf(NewService));
		NewService.click();
	}
	
	public boolean ValidateSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		return SuccessMessage.isDisplayed();
		
	}
	public void NewOrder(String name, String SalesPrice, String description, String ItemNumber) {
		wait.until(ExpectedConditions.visibilityOf(TypeName));
		TypeName.sendKeys(name);
		wait.until(ExpectedConditions.visibilityOf(Salesprice));
		Salesprice.sendKeys(SalesPrice);
		wait.until(ExpectedConditions.visibilityOf(Itemnumber));
		Itemnumber.sendKeys(ItemNumber);
		wait.until(ExpectedConditions.visibilityOf(Description));
		Description.sendKeys(description);
		wait.until(ExpectedConditions.visibilityOf(Submit));
		Submit.click();
	
	}
}
