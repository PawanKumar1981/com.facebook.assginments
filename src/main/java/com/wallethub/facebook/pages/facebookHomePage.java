package com.wallethub.facebook.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.facebook.base.BaseClass;

public class facebookHomePage extends BaseClass {
	@FindBy(xpath="//div[contains(@id,'placeholder')]")
	WebElement placeHoldertext;
	
	public facebookHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isplaceHoldertextBoxDisplayed() {
		
		return placeHoldertext.isDisplayed();
	}
	
	public void enterStatus(String msg) throws InterruptedException {
		placeHoldertext.sendKeys(msg);
		Thread.sleep(10000);
	}

}
