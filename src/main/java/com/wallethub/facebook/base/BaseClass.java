package com.wallethub.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() throws IOException   {
		prop = new Properties();
		try {
			FileInputStream src = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\wallethub\\facebook\\config\\config.properties");
			prop.load(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void browserinitialization() {
		//String browserName=;
		switch (prop.getProperty("Browser")) {
		case "chrome":
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "E://ChromeDriver//chromedriver.exe");	
			
			driver = new ChromeDriver();
			break;
		case "FF":
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

}

