package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capability.qa.Base.BaseTest;

public class DashBoardPage extends BaseTest{
	@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
	private WebElement dashboard;
	
	@FindBy(xpath = "//h6[contains(text(),'DEv2')]")
	private WebElement dev2Topicbtn;
	
	@FindBy(xpath = "//h6[contains(text(),'JAVA')]")
	private WebElement javaTopicbtn;
	
	
	public DashBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public boolean velidateDashBoard()
	{
		return dashboard.isDisplayed();
	}
	
	public boolean velidateDev2Tab()
	{
		return dev2Topicbtn.isDisplayed();
	}
	
	
	public JavaTopicPage clickOnJavaTopicTab()
	{
		javaTopicbtn.click();
		return new JavaTopicPage();
	}
	

}
