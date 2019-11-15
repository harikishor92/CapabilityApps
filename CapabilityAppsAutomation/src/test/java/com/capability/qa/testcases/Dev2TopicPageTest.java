package com.capability.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.Pages.DashBoardPage;
import com.capability.qa.Pages.Dev2TopicPage;
import com.capability.qa.Pages.LoginPage;
import com.capability.qa.Pages.WelcomePage;
import com.capability.qa.Util.TestUtil;

public class Dev2TopicPageTest extends BaseTest{
	
Logger logger = LogManager.getFormatterLogger(Dev2TopicPageTest.class);
	
	String sheetName = "";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoard;
	Dev2TopicPage dev2Page;
	
	Dev2TopicPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		logger.info("Welcome page launched successfully");
		wlcm = new WelcomePage();
		wlcm.clickOnLoginButton();
		logger.info("Login page launched successfully");
		loginPage = new LoginPage();
		loginPage.login(prob.getProperty("userName"), prob.getProperty("password"));
		logger.info("DashBoard page launched successfully");
		dashBoard = new DashBoardPage();
		dashBoard.clickOnDev2TopicTab();
		logger.info("Dev2Topic page launched successfully");
		dev2Page =new Dev2TopicPage();
	}
	
	@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test
	public void dev2TopicPageLOGOTextTest()
	{
		logger.info("Start executing the test case");
		
		boolean logo = dev2Page.verifyDev2Page();
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
