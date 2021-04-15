package com.TestPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.TestBase.TestBase;

public class MonthsPages extends TestBase {
	
	@FindBy(xpath="//select[@name='due_month']")
	WebElement Months_Dropdown_Field;
	@FindBy(xpath="//option[text()='Jan']")
	WebElement Jan;
	@FindBy(xpath="//option[text()='Feb']")
	WebElement Feb;
	@FindBy(xpath="//option[text()='Mar']")
	WebElement Mar;
	@FindBy(xpath="//option[text()='Apr']")
	WebElement Apr;
	@FindBy(xpath="//option[text()='May']")
	WebElement May;
	@FindBy(xpath="//option[text()='Jun']")
	WebElement Jun;
	@FindBy(xpath="//option[text()='Jul']")
	WebElement Jul;
	@FindBy(xpath="//option[text()='Aug']")
	WebElement Aug;
	@FindBy(xpath="//option[text()='Sep']")
	WebElement Sep;
	@FindBy(xpath="//option[text()='Oct']")
	WebElement Oct;
	@FindBy(xpath="//option[text()='Nov']")
	WebElement Nov ;
	@FindBy(xpath="//option[text()='Dec']")
	WebElement Dec;
	
	public MonthsPages() {
		
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 45);
		
	}

	public boolean selectFromdropdown() {
		
		List<String> months = new ArrayList<String>();
		months.add("jan");
		months.add("feb");
		months.add("mar");
		months.add("apr");
		months.add("may");
		months.add("jun");
		months.add("jul");
		months.add("aug");
		months.add("sep");
		months.add("oct");
		months.add("nov");
		months.add("dec");
		
		int count=0;
		
		List<WebElement> MonthList=driver.findElements(By.xpath("//select[@name='due_month']//parent::option"));
		for(WebElement ele:MonthList) {
			if(months.contains(ele.getText().toLowerCase())){
				count++;
			}
		}
		
		if(count>=12) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
