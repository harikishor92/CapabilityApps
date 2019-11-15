package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capability.qa.Base.BaseTest;

public class Dev2TopicPage extends BaseTest{
	
	@FindBy(xpath = "//h6[.='Questions']")
	private WebElement verifyDev2;
	
	@FindBy(xpath = "//button[@id='btn']")
	private WebElement addQuestionsbtn;
	
	
	public Dev2TopicPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyDev2Page()
	{
		return verifyDev2.isDisplayed();
	}
	
	public AddQuestionsPage clickOnAddQuestionbtn()
	{
		addQuestionsbtn.click();
		return new AddQuestionsPage();
	}
	

}
