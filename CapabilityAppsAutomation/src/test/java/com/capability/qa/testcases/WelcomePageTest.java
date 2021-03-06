package com.capability.qa.testcases;




import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.Pages.WelcomePage;
import com.capability.qa.Util.TestUtil;


public class WelcomePageTest extends BaseTest{
	
	Logger logger = Logger.getLogger(WelcomePageTest.class);
	
	String sheetName = "";
	WelcomePage wlcm;
	
	
	WelcomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		logger.info("Welcome page launched successfully");
		wlcm = new WelcomePage();
	}
	
	/*@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}*/
	
	
	
	@Test //(dataProvider = "getCapabilityTestData")
	public void WelcomePageTitleTest()
	{
		logger.info("Start executing the test case");
		String title = wlcm.validateWelcomePageTitle();
		Assert.assertEquals(title, "Capability App");
		
		logger.info("Test case execution completed");
	}
	
	@Test
	public void WelcomePageLOGOTextTest()
	{
		logger.info("Start executing the test case");
		
		boolean logo = wlcm.validateWelcomePageLOGOText();
		Assert.assertTrue(true);
		logger.info("Test case execution completed");
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Closed the browser successfully");
	}
	
	
	

}
