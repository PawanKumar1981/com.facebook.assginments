package com.wallethub.facebook.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wallethub.facebook.base.BaseClass;
import com.wallethub.facebook.pages.facebookHomePage;
import com.wallethub.facebook.pages.facebookLoginPage;

public class facebookHomePageTest extends BaseClass{
	facebookLoginPage Loginpage;
	facebookHomePage  Homepage;
	String message="Hello World";
	/*
	 * Constructor
	 */
	public facebookHomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws IOException {
		browserinitialization();
		Loginpage = new facebookLoginPage();	
		log.info("setup");
	}
	
	@Test
	public void login() {
		
     Loginpage.facebook_login(prop.getProperty("username"),prop.getProperty("password"));
     
     Assert.assertTrue(Loginpage.navigateHomepageofFace_book());
    
     log.info("Log in sucessfull and Landed to Homepage");
    
      //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
     
     
     try {
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
         wait.until(ExpectedConditions.alertIsPresent());
         Alert alert = driver.switchTo().alert();
         System.out.println(alert.getText());
         alert.accept();
		
	} catch (Exception e) {
		
	}
    	 
            
     
     if (Homepage.isplaceHoldertextBoxDisplayed()==true) {
    	 try {
			Homepage.enterStatus(message);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
	}

}
