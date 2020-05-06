package com.wallethub.facebook.LoginPage;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.wallethub.facebook.base.BaseClass;
import com.wallethub.facebook.pages.facebookLoginPage;

public class facebookLoginPageTest extends BaseClass {
	
	facebookLoginPage Loginpage;
	public boolean landToHomePage;
	
	
	public facebookLoginPageTest(){
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
     landToHomePage =Loginpage.navigateHomepageofFace_book();
     Assert.assertTrue(landToHomePage);
     log.info("Log in sucessfull and Landed to Homepage");
     
	}
	
	

}
