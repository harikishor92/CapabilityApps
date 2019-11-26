package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.Util.TestUtil;

public class EditQuestionsPage extends BaseTest{
	
	@FindBy(xpath = "//input[@class='form-control question']")
	private  WebElement editQuestion;
	
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private  WebElement editOptionA;
	
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private  WebElement editOptionB;
	
	@FindBy(xpath = "(//input[@class='form-control'])[3]")
	private  WebElement editOptionC;
	
	@FindBy(xpath = "(//input[@class='form-control'])[4]")
	private  WebElement editOptionD;
	
	public EditQuestionsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void editQuestion(String que, String sValueA, String sValueB, String sValueC, String sValueD)
	{
		editQuestion.clear();
		editQuestion.sendKeys(que);
		TestUtil.editOptions(editOptionA, sValueA);
		TestUtil.editOptions(editOptionB, sValueB);
		TestUtil.editOptions(editOptionC, sValueC);
		TestUtil.editOptions(editOptionD, sValueD);
	}

}
