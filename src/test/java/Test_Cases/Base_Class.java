package Test_Cases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
import org.testng.annotations.Test;

import test_Utillities.ReadConfig;

public class Base_Class {
	
		ReadConfig rc= new ReadConfig();  // creating object of readconfig class , rc is an object
		
		public String baseURL=rc.getApplicationURL();
		public String username=rc.getusername();
		public String password=rc.getpassword();
		
		public static WebDriver driver;
		public static Logger logger;
		
		
	    @Parameters("browser")
		@BeforeClass
		public void setup( String br)
		{
			 logger=Logger.getLogger("SeleniumWithJavaProject");
			PropertyConfigurator.configure("log4j.properties");
			
			if(br.equals("chrome"))
			{
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());  //rc is an object reffering to ReadConfig class
			driver=new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", rc.getFireFoxPath());  //rc is an object reffering to ReadConfig class
				driver=new FirefoxDriver();
			} 
			
			driver.get(baseURL);	
			driver.manage().window().maximize();
			
		}
		
		@AfterClass
		public void teardown()
		{
			driver.quit();
		}
		
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		
		public String randomestring()
		{
			String generatedstring=RandomStringUtils.randomAlphabetic(8);
			return(generatedstring);
		}
		
		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}
	}

