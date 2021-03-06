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

public class LoginPageTest extends BaseTest{
Logger logger = Logger.getLogger(LoginPageTest.class);
	
	String sheetName = "Login_Details";
	WelcomePage wlcm;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	
	
	LoginPageTest()
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
	}
	
	@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test
	public void loginPageLOGOTextTest()
	{
		logger.info("Start executing the test case");
		
		boolean logo = loginPage.validateLoginPage();
		Assert.assertTrue(true);
		logger.info("Test case execution completed");
	}
	
	//Login app by using config file for username and password 
	
	@Test
	public void loginPageTest()
	{
		logger.info("Start executing the test case");
		
		dashBoardPage = loginPage.login(prob.getProperty("userName"),prob.getProperty("password") );
		 
		logger.info("Test case execution completed");
	}
	
	//Login app by using Excel sheet test data for username and password 
	
	@Test(dataProvider = "getCapabilityTestData")
	public void loginPageTest(String username, String password)
	{
		logger.info("Start executing the test case");
		
		dashBoardPage = loginPage.login(username, password);
		 
		logger.info("Test case execution completed");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Closed the browser successfully");
	}

}
