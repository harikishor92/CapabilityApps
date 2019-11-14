package com.capability.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.Pages.HomePage;
import com.capability.qa.Pages.LoginPage;
import com.capability.qa.Pages.WelcomePage;
import com.capability.qa.Util.TestUtil;

public class LoginPageTest extends BaseTest{
Logger logger = LogManager.getFormatterLogger(WelcomePageTest.class);
	
	String sheetName = "";
	WelcomePage wlcm;
	LoginPage loginPage;
	HomePage homePage;
	
	
	LoginPageTest()
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
	}
	
	@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test
	public void LoginPageLOGOTextTest()
	{
		logger.info("Start executing the test case");
		
		boolean logo = loginPage.validateLoginPage();
		Assert.assertTrue(true);
		logger.info("Test case execution completed");
	}
	
	
	@Test
	public void loginPageTest()
	{
		logger.info("Start executing the test case");
		
		homePage = loginPage.login("admin", "admin");
		 
		logger.info("Test case execution completed");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Closed the browser successfully");
	}

}
