package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capability.qa.Base.BaseTest;

public class JavaTopicPage extends BaseTest{
	
	@FindBy(xpath = "//h6[.='Questions']")
	private WebElement verifyJavaPage;
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[3]/div[1]/div[2]/button")
	//@FindBy(xpath = "(//button[@class = 'MuiButtonBase-root MuiIconButton-root jss258'])[1]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInput-input']")
	private WebElement enterValueSearchBox;
	
	//@FindBy(xpath = "//*[@id='MUIDataTableBodyRow-2']/td[1]/div/span/span[1]/svg")
	@FindBy(xpath = "(//span)[14]")
	private WebElement selectCheckBoxbtn;
	
	@FindBy(xpath = "//button[.='Add Question']")
	private WebElement addQuestionbtn;
	
	@FindBy(xpath = "//span//button[@class='MuiButtonBase-root MuiIconButton-root jss248']")
	private WebElement filterBtn;
	
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root jss264']")
	private WebElement editBtn;
	
	
	
	
	public JavaTopicPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyJavaPage()
	{
		return verifyJavaPage.isDisplayed();
	}
	
	public AddQuestionsPage clickOnaddQuestionBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		addQuestionbtn.click();
		return new AddQuestionsPage();
	}
	
	public void clickOnSearchBtn() throws InterruptedException
	{
		Thread.sleep(3000);
		searchBtn.click();
	}
	
	public void selectCheckBox()
	{
		if(selectCheckBoxbtn.isSelected())
		{
			System.out.println("ChechBox is already selected");
		}
		else 
		{
			selectCheckBoxbtn.click();
		}
	}
	
	public void enterValueInSearchBox(String value)
	{
		enterValueSearchBox.sendKeys(value);
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

}
