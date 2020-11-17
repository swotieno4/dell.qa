package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestUtil.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public TestBase() {
		
		 prop = new Properties();
		 
		try {
			FileInputStream fle= new FileInputStream("C:\\eclipse\\dell.qa\\src\\main\\java\\com\\Config\\Config.properties");
			prop.load(fle);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initil() {
		
		
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\dell.qa\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {	
			
			System.setProperty("webdriver.gecko.driver", "C:\\eclipse\\dell.qa\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADOUTTIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITYWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
}
	
}