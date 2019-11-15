package com.capability.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capability.qa.Base.BaseTest;

public class LoginPage extends BaseTest{
	
	@FindBy(xpath = "//h3[contains(text(),'Welcome To Capability App')]")
	WebElement LoginPagelogotext;
	
	
	@FindBy(xpath = "//input[@placeholder='Enter Email or Username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Enter Password'] ")
	WebElement passwd;
	
	@FindBy(xpath = "//button[@class='btn btn-primary w-25 ml-auto login-button']")
	WebElement LoginPageLoginbtn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLoginPage()
	{
		return LoginPagelogotext.isDisplayed();
	}
	
	public DashBoardPage login(String un, String pwd)
	{
		username.sendKeys(un);
		passwd.sendKeys(pwd);
		LoginPageLoginbtn.click();
		return new DashBoardPage();
	}

}
