package com.capability.qa.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.events.WebDriverEventListener;

import com.capability.qa.Util.WebEventListener;

public class BaseTest {
	static Logger logger = Logger.getLogger(BaseTest.class);
	public static Properties prob;
	public static WebDriver driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public BaseTest()
	{
		logger.info("Start reading the config file");
		prob = new Properties(); 
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/capability/qa/Config/config.properties");
			prob.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Read the config file");
		
	}
	
	public static void initialization()
	{
		logger.info("Lunching the browser");
		String browserName = prob.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("fireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else 
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEdriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prob.getProperty("url"));
		logger.info("Lunched the browser");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
