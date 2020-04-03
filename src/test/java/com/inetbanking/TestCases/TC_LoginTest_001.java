package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void LoginTest() throws IOException
	{
	logger.info("URL is opened");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.setUserName(username);
	logger.info("Enter username");
	loginpage.setPassword(password);
	logger.info("Enter password");
	loginpage.clickSubmit();
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
		logger.info("Login Test Passed");
	}
	else{
		captureScreen(driver, "LoginTest");
		Assert.assertTrue(false);
		logger.info("Login Failed");
	}
	
	} 
	

}
