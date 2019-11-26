package com.capability.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import com.capability.qa.Base.BaseTest;

public class TestUtil extends BaseTest{
	static Logger logger = Logger.getLogger(TestUtil.class);
	static String TESTDATA_SHEET_PATH = "./src/main/java/com/capability/qa/Testdata/CapabilityApp_testData.xls";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		logger.info("Start reading the excel sheet");
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString().trim();
				// System.out.println(data[i][k]);
				
			}
		}
		logger.info("Excel sheet data read successfully");
		return data;
		
	}
	
	public void switchToFrame()
	{
		driver.switchTo().frame("");
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + timestamp()+ ".png"));
	}
	
	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	
	public static void selectDropDown(WebElement sValue, String option)
	{
		Select s1 = new Select(sValue);
		s1.selectByVisibleText(option);
	}
	
	public static void editOptions(WebElement sOption, String sValue)
	{
		sOption.clear();
		sOption.sendKeys(sValue);
	}
	public static void passValues(WebElement sElement,String option)
	{
		sElement.sendKeys(option);
	}

}
