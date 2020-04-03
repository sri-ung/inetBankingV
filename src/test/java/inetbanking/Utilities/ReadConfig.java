package inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("./Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("URL");
		return url;
	}
	
	public String getUserName()
	{
		String username = prop.getProperty("username");
		return username;
	}
	public String getPassWord()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxPath()
	{
		String firefoxpath= prop.getProperty("firefoxpath");
		return firefoxpath;
	}
}
