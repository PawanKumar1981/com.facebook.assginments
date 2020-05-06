package com.wallethub.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log= Logger.getLogger(BaseClass.class.getName());
	
	public BaseClass()   {
		prop = new Properties();
		try {
			FileInputStream src = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\wallethub\\facebook\\config\\config.properties");
			prop.load(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 catch (IOException e) {
		e.printStackTrace();
	}
		//BasicConfigurator.configure();
		String log4jConfPath = "./log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	
	public static void browserinitialization() throws IOException {
		//String browserName=;
		switch (prop.getProperty("Browser")) {
		case "chrome":
			
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));	
			driver = new ChromeDriver();
			break;
		case "FF":
			 WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
				
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	
	}

}

