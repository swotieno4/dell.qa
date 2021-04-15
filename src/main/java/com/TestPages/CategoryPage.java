package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestBase.TestBase;

public class CategoryPage extends TestBase{
	
	
	@FindBy(xpath="//input[@name='categorydata']")
	WebElement Add_Category;
	@FindBy(xpath="//input[@value='Add category']")
	WebElement Add_Category_Button;
	@FindBy(xpath="//a[contains(.,'Nevermind')]")
	WebElement ErrorVerification;
	@FindBy(xpath="//span[contains(.,'Category 234244')]//ancestor::a")
	WebElement MyNewCategory;
	
	@FindBy(xpath = "//a[contains(.,'Yes')]")
	WebElement Yes;
	
public CategoryPage() {
		
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 45);
		
	}

public void Add_Category() {
	wait.until(ExpectedConditions.visibilityOf(Add_Category));
	MyNewCategory.click();
	Yes.click();
	driver.get(prop.getProperty("url"));
	Add_Category.sendKeys("Category 234244");
	Add_Category_Button.click();
	driver.get(prop.getProperty("url"));
	}

public boolean VerifyNewCategory() {
	try {
		wait.until(ExpectedConditions.visibilityOf(MyNewCategory));
		return MyNewCategory.isDisplayed();
	} catch (Exception e) {
		return false;
	}
	
	}

public void Add_Category1() {
	wait.until(ExpectedConditions.visibilityOf(Add_Category));
	Add_Category.sendKeys("Almost there");
	Add_Category_Button.click();
	//ErrorVerification.isDisplayed();
	}

	public boolean VerifyError() {
	try {
		wait.until(ExpectedConditions.visibilityOf(ErrorVerification));
		return ErrorVerification.isDisplayed();
	} catch (Exception e) {
		return false;
	}
	
	}

}
