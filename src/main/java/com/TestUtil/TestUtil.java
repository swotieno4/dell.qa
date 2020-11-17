package com.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.TestBase.TestBase;
import com.aventstack.extentreports.utils.FileUtil;

public class TestUtil extends TestBase {
	
	public static long PAGELOADOUTTIME=30;
	public static long IMPLICITYWAIT =30;
	
	
	static Workbook book;
	static Sheet sheet;
	public static String TESTDATA_PATH ="C:\\eclipse\\dell.qa\\src\\main\\java\\com\\TestData\\NewService.xlsx";
	
	public static Object [][] getTestData(String sheetName){
		
			
		FileInputStream file;
		
			try {
				file = new FileInputStream(TESTDATA_PATH);
				book = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
			
		}
		return data;
	}
	
	public static void screenShot(WebDriver driver,String screenShotName)  {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("./Screenshot/"+screenShotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}		

