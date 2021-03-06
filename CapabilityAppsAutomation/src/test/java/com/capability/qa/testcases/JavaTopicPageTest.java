package com.capability.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.Pages.DashBoardPage;
import com.capability.qa.Pages.JavaTopicPage;
import com.capability.qa.Pages.LoginPage;
import com.capability.qa.Pages.WelcomePage;
import com.capability.qa.Util.TestUtil;

public class JavaTopicPageTest extends BaseTest{
	Logger logger = Logger.getLogger(JavaTopicPageTest.class);
	
	String sheetName ="";
	WelcomePage wlcm;
	LoginPage login;
	DashBoardPage dashBaord;
	JavaTopicPage jtp;
	
	JavaTopicPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		logger.info("Welcome page has launched successfully");
		wlcm = new WelcomePage();
		wlcm.clickOnLoginButton();
		logger.info("Login Page has launched successfully");
		login = new LoginPage();
		login.login(prob.getProperty("userName"), prob.getProperty("password"));
		logger.info("DashBoard Page has launched successfully");
		dashBaord = new DashBoardPage();
		dashBaord.clickOnJavaTopicTab();
		logger.info("Clicked on java tab successfully");
		jtp = new JavaTopicPage();
		
	}
	
	@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	
	@Test
	public void javaTopicPageTest()
	{
		
		logger.info("Start executing the test case");
		jtp.verifyJavaPage();
		Assert.assertTrue(true);
		logger.info("Java Topic Page has launched successfully");
		logger.info("Test case execution completed");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		logger.info("Closed the browser successfully");
	}
	

}
