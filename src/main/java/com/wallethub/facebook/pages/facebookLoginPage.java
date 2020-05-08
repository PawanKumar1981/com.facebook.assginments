package com.wallethub.facebook.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.facebook.base.BaseClass;

public class facebookLoginPage extends BaseClass {

	// Object Rep
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "pass")
	WebElement password;

	@FindBy(xpath = "//label[@id='loginbutton']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement FaceBook_HomePage;

	@FindBy(xpath = "//div[@id='userNavigationLabel']")
	WebElement userNavigationLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	WebElement facebook_LogOut;

	// Initializing the Page Objects:
	public facebookLoginPage() {
		PageFactory.initElements(driver, this);

	}

	public void facebook_login(String usrname, String passwrd) {

		username.sendKeys(usrname);
		password.sendKeys(passwrd);
		loginBtn.click();
	}

	public void facebook_out() {
		userNavigationLabel.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		facebook_LogOut.click();
	}

	public boolean navigateHomepageofFace_book() {

		return FaceBook_HomePage.isDisplayed();

	}

}
