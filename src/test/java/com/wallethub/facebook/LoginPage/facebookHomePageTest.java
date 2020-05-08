package com.wallethub.facebook.LoginPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.wallethub.facebook.base.BaseClass;
import com.wallethub.facebook.pages.facebookHomePage;
import com.wallethub.facebook.pages.facebookLoginPage;

public class facebookHomePageTest extends BaseClass {
	facebookLoginPage Loginpage;
	facebookHomePage Homepage;
	String message = "Hello World";

	// Calling the Constructor

	public facebookHomePageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		browserinitialization();
		Loginpage = new facebookLoginPage();
		Homepage = new facebookHomePage();
		log.info("intitialzation and setup");
	}

	@Test
	public void login() throws InterruptedException {

		Loginpage.facebook_login(prop.getProperty("username"), prop.getProperty("password"));

		Assert.assertTrue(Loginpage.navigateHomepageofFace_book());

		log.info("Log in sucessfull and Landed to Homepage");

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		try {
//    	 WebDriverWait wait = new WebDriverWait(driver, 20);
//         wait.until(ExpectedConditions.alertIsPresent());
//         Alert alert = driver.switchTo().alert();
//         alert.accept();

			Robot robot = new Robot();
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);

		} catch (Exception e) {

		}
		Homepage.create_newpost(message);
		log.info("Post created sucessfully from my account");
	}
}
