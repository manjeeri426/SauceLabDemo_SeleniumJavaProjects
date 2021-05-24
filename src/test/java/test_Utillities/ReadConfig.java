package test_Utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() 
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("baseurl");
		return url;
	}
	
	public String getusername()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getpassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFireFoxPath()
	{
		String firefoxpath=prop.getProperty("firefoxpath");
		return firefoxpath;
	}
}
