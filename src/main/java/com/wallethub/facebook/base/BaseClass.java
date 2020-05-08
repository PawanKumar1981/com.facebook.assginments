package com.wallethub.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(BaseClass.class.getName());

	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream src = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\wallethub\\facebook\\config\\config.properties");
			prop.load(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String log4jConfPath = "./log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public static void browserinitialization() throws IOException {

		switch (prop.getProperty("Browser")) {

		case "chrome":
			// WebDriverManager.chromedriver().setup();

			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			// below line of code to fix-> Timed out receiving message from renderer: 0.100
			// System.setProperty("Webdriver.chrome.silentOutput", "true");
			// mention the below chrome option to solve timeout exception issue
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			options.addArguments("--disable-notifications");
			// Instantiate the chrome driver
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver();
			break;

		case "FF":
			// Instantiate the firefox driver
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void tearDown() {

		driver.quit();
		log.info("Browser was closed sucessfully");

	}

}
