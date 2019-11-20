package com.capability.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.Pages.DashBoardPage;
import com.capability.qa.Pages.LoginPage;
import com.capability.qa.Pages.WelcomePage;
import com.capability.qa.Util.TestUtil;

public class DashBoardPageTest extends BaseTest{
Logger logger = Logger.getLogger(DashBoardPageTest.class);
	
	String sheetName = "";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoard;
	
	DashBoardPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
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
	}
	
	@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test
	public void dashBoardPageLOGOTextTest()
	{
		logger.info("Start executing the test case");
		
		boolean logo = dashBoard.velidateDashBoard();
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
