package com.inetbanking.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import inetbanking.Utilities.ReadConfig;

public class BaseClass {
    ReadConfig readconfig = new ReadConfig();
	public String URL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassWord();
	public  static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
     	 logger = logger.getLogger("ebanking");
     	PropertyConfigurator.configure("Log4j.properties");
     	if(br.equals("chrome"))
     	{
     		 System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
          	driver = new ChromeDriver();
     	}
     	else if(br.equals("firefox"))
     	{
     		 System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
          	driver = new FirefoxDriver();
     	}
     	driver.get(URL);
    }
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/"+ tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShots taken");
	}
	
}