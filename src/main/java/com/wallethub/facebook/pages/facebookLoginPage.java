package com.wallethub.facebook.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.facebook.base.BaseClass;

public class facebookLoginPage extends BaseClass {


		//Object Rep
		@FindBy(name="email")
		WebElement username;
		
		@FindBy(name="pass")
		WebElement password;
		
		@FindBy(xpath="//label[@id='loginbutton']")
		WebElement loginBtn;
		//Initializing the Page Objects:
		
		public facebookLoginPage() throws IOException {
			PageFactory.initElements(driver, this);	
			
		}
		
		public void facebook_login(String usrname, String passwrd) {
			
			username.sendKeys(usrname);
			password.sendKeys(passwrd);
			loginBtn.click();
			
		}
		

}
