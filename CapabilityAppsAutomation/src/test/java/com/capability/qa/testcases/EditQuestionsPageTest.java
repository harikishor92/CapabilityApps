package com.capability.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.Pages.AddQuestionsPage;
import com.capability.qa.Pages.DashBoardPage;
import com.capability.qa.Pages.EditQuestionsPage;
import com.capability.qa.Pages.JavaTopicPage;
import com.capability.qa.Pages.LoginPage;
import com.capability.qa.Pages.WelcomePage;
import com.capability.qa.Util.TestUtil;

public class EditQuestionsPageTest extends BaseTest{
	
Logger logger = Logger.getLogger(EditQuestionsPageTest.class);
	
	String sheetName ="editQuestions";
	WelcomePage wlcm;
	LoginPage login;
	DashBoardPage dashBaord;
	JavaTopicPage jtp;
	AddQuestionsPage addQues;
	EditQuestionsPage editQuestion;
	
	EditQuestionsPageTest()
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
		jtp.verifyJavaPage();
		logger.info("Java Topic Page has launched successfully");
		jtp.clickOnSearchBtn();
		
		
		
	}
	
	@DataProvider()
	public Object[][] getCapabilityTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider = "getCapabilityTestData")
	public void editQuestion(String searchQuestion, String topic, String Complexcity, String type,
			String chapter, String eQuestion, String editA, String editB, String editC, 
			String editD, String selectA, String selectB, String selectC, String selectD)
	{
		jtp.enterValueInSearchBox(searchQuestion);
		jtp.selectCheckBox();
		jtp.clickOnEditBtn();
		addQues = new AddQuestionsPage();
		addQues.selectTopicDropDown(topic);
		addQues.selectComplexicityDropDown(Complexcity);
		addQues.selectTypeDropDown(type);
		addQues.selectChapterDropDown(chapter);
		editQuestion = new EditQuestionsPage();
		editQuestion.editQuestion(eQuestion, editA, editB, editC, editD);
		addQues.selectAnswarOptions(type, selectA, selectB, selectC, selectD);
		
		
	}

}
