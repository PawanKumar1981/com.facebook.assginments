package com.wallethub.facebook.LoginPage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wallethub.facebook.base.BaseClass;
import com.wallethub.facebook.pages.facebookLoginPage;



public class facebookLoginPageTest extends BaseClass {
	facebookLoginPage Loginpage;
	public facebookLoginPageTest() throws IOException{
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		browserinitialization();
		Loginpage = new facebookLoginPage();	
		//log.info("setup");
	}
	@Test
	public void login() {
		Loginpage.facebook_login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
