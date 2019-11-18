package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capability.qa.Base.BaseTest;

public class JavaTopicPage extends BaseTest{
	
	@FindBy(xpath = "//h6[.='Questions']")
	private WebElement verifyJavaPage;
	
	@FindBy(xpath = "//button[@xpath = '1' and  @class = 'MuiButtonBase-root MuiIconButton-root jss248']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//button[@id='btn']")
	private WebElement addQuestionbtn;
	
	@FindBy(xpath = "//span//button[@class='MuiButtonBase-root MuiIconButton-root jss248']")
	private WebElement filterBtn;
	
	@FindBy(xpath = " //tr[@id='MUIDataTableBodyRow-0']//*[@class='MuiSvgIcon-root']")
	private WebElement selectCheckbox;
	
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root jss797']")
	private WebElement editBtn;
	
	
	
	
	public JavaTopicPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyJavaPage()
	{
		return verifyJavaPage.isDisplayed();
	}
	
	public AddQuestionsPage clickOnaddQuestionBtn()
	{
		addQuestionbtn.click();
		return new AddQuestionsPage();
	}
	
	public void clickOnSearchBtn()
	{
		searchBtn.click();
	}
	
	public void clickOnFilterBtn()
	{
		filterBtn.click();
	}
	
	public EditQuestionsPage clickOnEditBtn()
	{
		editBtn.click();
		return new EditQuestionsPage();
	}
	
	public void selectCheckBoxBtn()
	{
		selectCheckbox.click();
	}

}
