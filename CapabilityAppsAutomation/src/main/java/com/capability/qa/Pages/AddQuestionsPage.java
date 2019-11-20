package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.capability.qa.Base.BaseTest;
import com.capability.qa.ObjectRepository.OR;
import com.capability.qa.Util.TestUtil;



public class AddQuestionsPage extends BaseTest{
	//drop downs
	@FindBy(xpath = "(//select[@class = 'form-control'])[1]")
	private  WebElement selectTopic;
	
	@FindBy(xpath = "(//select[@class = 'form-control'])[2]")
	private WebElement selectComplexcity;
	
	@FindBy(xpath = "(//select[@class = 'form-control'])[3]")
	//@FindBy(xpath = OR.selectType)
	private WebElement selectType;
	
	@FindBy(xpath = "(//select[@class = 'form-control'])[4]")
	//@FindBy(xpath = OR.selectChapter)
	private WebElement selectChapter;
	
	//write text
	@FindBy(xpath = "//textarea[@id='text']")
	private WebElement writeQuestion;
	
	@FindBy(xpath = "(//input[@class = 'form-control'])[1]")
	private WebElement writeOptionA;
	
	@FindBy(xpath = "(//input[@class = 'form-control'])[2]")
	private WebElement writeOptionB;
	
	@FindBy(xpath = "(//input[@class = 'form-control'])[3]")
	private WebElement writeOptionC;
	
	@FindBy(xpath = "(//input[@class = 'form-control'])[4]")
	private WebElement writeOptionD;
	
	//Select Answar for single select radio button
	@FindBy(xpath = "(//input[@name = 'selectedRadio'])[1]")
	private WebElement selectOptionA;
	@FindBy(xpath = "(//input[@name = 'selectedRadio'])[2]")
	private WebElement selectOptionB;
	@FindBy(xpath = "(//input[@name = 'selectedRadio'])[3]")
	private WebElement selectOptionC;
	@FindBy(xpath = "(//input[@name = 'selectedRadio'])[4]")
	private WebElement selectOptionD;
	
	//Select Answar for multi select radio button
	@FindBy(xpath = "(//input[@class = 'ans1'])[4]")
	private WebElement mSelectOptionA;
	@FindBy(xpath = "(//input[@class = 'ans1'])[5]")
	private WebElement mSelectOptionB;
	@FindBy(xpath = "(//input[@class = 'ans1'])[6]")
	private WebElement mSelectOptionC;
	@FindBy(xpath = "(//input[@class = 'ans1'])[7]")
	private WebElement mSelectOptionD;
	
	//save
	@FindBy(xpath = "(//button[.='Save'])[1]")
	private WebElement saveBtn;
	//cancel
	@FindBy(xpath = "(//button[.='Cancel'])[2]")
	private WebElement cancelBtn;
	
	public AddQuestionsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public  void selectTopicDropDown(String option)
	{
		Select s1 = new Select(selectTopic);
		s1.selectByVisibleText(option);
	}
	
	public  void selectComplexicityDropDown(String option)
	{
		Select s1 = new Select(selectComplexcity);
		s1.selectByVisibleText(option);
	}
	
	public  void selectTypeDropDown(String option)
	{
		Select s1 = new Select(selectType);
		s1.selectByVisibleText(option);
	}
	
	public  void selectChapterDropDown(String option)
	{
		Select s1 = new Select(selectChapter);
		s1.selectByVisibleText(option);
	}
	//write question
	public void writeQuestion(String option)
	{
		writeQuestion.sendKeys(option);
	}
	
	public void writeOptionA(String option)
	{
		writeOptionA.sendKeys(option);
	}
	
	public void writeOptionB(String option)
	{
		writeOptionB.sendKeys(option);
	}
	
	public void writeOptionC(String option)
	{
		writeOptionC.sendKeys(option);
	}
	
	public void writeOptionD(String option)
	{
		writeOptionD.sendKeys(option);
	}
	
	//Action for Single select
	
	public void selectOptionA()
	{
		selectOptionA.click();
	}
	
	public void selectOptionB()
	{
		selectOptionB.click();
	}
	
	public void selectOptionC()
	{
		selectOptionC.click();
	}
	
	public void selectOptionD()
	{
		selectOptionD.click();
	}
	
	//Action for Multi select
	
	public void mSelectOptionA()
	{
		mSelectOptionA.click();
	}
	
	public void mSelectOptionB()
	{
		mSelectOptionB.click();
	}
	
	public void mSelectOptionC()
	{
		mSelectOptionC.click();
	}
	
	public void mSelectOptionD()
	{
		mSelectOptionD.click();
	}
	public void selectAnswarOptions(String choice, String A, String B, String C, String D)
	{
		if(choice.equals("Single Choice Question"))
		{
			if(A.equals("yes")&& B.equals("no") && C.equals("no") && D.equals("no"))
			{
				selectOptionA();
			}
			else if(A.equals("no") && B.equals("yes") && C.equals("no") && D.equals("no"))
			{
				selectOptionB();
			}
			else if(A.equals("no") && B.equals("no") && C.equals("yes") && D.equals("no"))
			{
				selectOptionC();
			}
			else if(A.equals("no") && B.equals("no") && C.equals("no") && D.equals("yes"))
			{
				selectOptionD();
			}
		}
		else if(choice.equals("Multiple Choice Question"))
		{
			if(A.equals("yes"))
			{
				mSelectOptionA();
			}
			if(B.equals("yes"))
			{
				mSelectOptionB();
			}
			if(C.equals("yes"))
			{
				mSelectOptionC();
			}
			if(D.equals("yes"))
			{
				mSelectOptionD();
			}
		}
	}
	
	public void clickOnSaveButton()
	{
		saveBtn.click();
	}
	
	public void clickOnCancelButton()
	{
		cancelBtn.click();
	}
	
	/*public void addQuestions()
	{
		
		TestUtil.selectDropDown(selectTopic, "JAVA");
		TestUtil.selectDropDown(selectComplexcity, "Simple");
		TestUtil.selectDropDown(selectType, "Single Choice Question");
		TestUtil.selectDropDown(selectChapter, "Inheritance");
		TestUtil.passValues(writeQuestion, "What is Java ??");
		TestUtil.passValues(writeOptionA, "It's a programming language. ");
		TestUtil.passValues(writeOptionB, "It's not a programming language.");
		TestUtil.passValues(writeOptionC, "It's a method.");
		TestUtil.passValues(writeOptionD, "It's a query.");
	}*/
	
	/*if(type.equals("Single Choice Question"))
	{
		if(A.equals("yes")&& B.equals("no") && C.equals("no") && D.equals("no"))
		{
			addQues.selectOptionA();
		}
		else if(A.equals("no") && B.equals("yes") && C.equals("no") && D.equals("no"))
		{
			addQues.selectOptionB();
		}
		else if(A.equals("no") && B.equals("no") && C.equals("yes") && D.equals("no"))
		{
			addQues.selectOptionC();
		}
		else if(A.equals("no") && B.equals("no") && C.equals("no") && D.equals("yes"))
		{
			addQues.selectOptionD();
		}
	}
	else if(type.equals("Multiple Choice Question"))
	{
		if(A.equals("yes"))
		{
			addQues.mSelectOptionA();
		}
		if(B.equals("yes"))
		{
			addQues.mSelectOptionB();
		}
		if(C.equals("yes"))
		{
			addQues.mSelectOptionC();
		}
		if(D.equals("yes"))
		{
			addQues.mSelectOptionD();
		}
	}
	*/
	
	
	
	
}
