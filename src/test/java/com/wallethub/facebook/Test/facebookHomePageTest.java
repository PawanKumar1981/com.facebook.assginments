package com.wallethub.facebook.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
	public void setUpandLogin() throws IOException, AWTException {
		browserinitialization();
		Loginpage = new facebookLoginPage();
		Homepage = new facebookHomePage();
		log.info("intitialzation and setup");

		Loginpage.facebook_login(prop.getProperty("username"), prop.getProperty("password"));

		Assert.assertTrue(Loginpage.navigateHomepageofFace_book());

		log.info("Logged in sucessfully and Landed to Homepage of facebook");

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		Robot robot = new Robot();
		robot.delay(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);

		log.info("Alert Closed sucessfully");
	}

	@Test(priority = 1)
	public void faceBook_createpost() throws InterruptedException {
		Homepage.create_newpost(message);
		log.info("create Post posted sucessfully from my account");
	}

	@AfterClass
	public void logOutpage() {

		Loginpage.facebook_out();
		log.info("Facebook Logged out sucessfully");
	}

}
