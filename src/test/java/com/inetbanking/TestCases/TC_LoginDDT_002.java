package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import inetbanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider ="LoginData")
	public void loginData(String user, String psd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(psd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(5000);
		
		if(isAlertPresent()== true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}	
		public boolean isAlertPresent()
		{
			try
			{
				driver.switchTo().alert();
				return true;
			}
			catch(NoAlertPresentException e)
			{
				return false;
			}
		}
	
	@DataProvider(name="LoginData")
	String[][]getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/inetbanking/Testdata/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colnum = XLUtils.getCellCount(path, "sheet1", 1);
		String loginData[][] = new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return loginData;
	}

}
