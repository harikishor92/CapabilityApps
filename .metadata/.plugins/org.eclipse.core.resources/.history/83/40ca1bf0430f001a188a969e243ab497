package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capability.qa.Base.BaseTest;

public class JavaTopicPage extends BaseTest{
	
	@FindBy(xpath = "//h6[.='Questions']")
	private WebElement verifyJavaPage;
	
	@FindBy(xpath = "//body/div[@id='root']/div/div/div[@class='side-content mt-5']"
			+ "/div[@class='MuiPaper-root MuiPaper-elevation4 jss251 mt-5 MuiPaper-rounded']"
			+ "/div[@class='MuiToolbar-root MuiToolbar-regular jss286 MuiToolbar-gutters']"
			+ "/div[@class='jss288']/button[@class='MuiButtonBase-root MuiIconButton-root jss291']"
			+ "/span[@class='MuiIconButton-label']/*[1] ")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInput-input']")
	private WebElement enterValueSearchBox;
	
	@FindBy(xpath = "//button[.='Add Question']")
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
	
	public AddQuestionsPage clickOnaddQuestionBtn() throws InterruptedException
	{
		Thread.sleep(2000);
		addQuestionbtn.click();
		return new AddQuestionsPage();
	}
	
	public void clickOnSearchBtn()
	{
		searchBtn.click();
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
	
	public void selectCheckBoxBtn()
	{
		selectCheckbox.click();
	}

}
