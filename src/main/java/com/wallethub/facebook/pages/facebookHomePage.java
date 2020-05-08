package com.wallethub.facebook.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wallethub.facebook.base.BaseClass;

public class facebookHomePage extends BaseClass {
	@FindBy(xpath = "//div[contains(@id,'placeholder-')]")
	WebElement placeHoldertext;

	@FindBy(xpath = "//span[text()='Create Post']")
	WebElement createpostlnk;

	@FindBy(xpath = "//*[@data-editor]")
	WebElement editortext;

	@FindBy(xpath = "//span[text()='Post']")
	WebElement postBtn;

	public facebookHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void create_newpost(String msg) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		createpostlnk.click();
		editortext.click();
		Actions ac = new Actions(driver);
		ac.sendKeys(msg);
		ac.sendKeys(Keys.ENTER);
		ac.build().perform();
		postBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// return postBtn.isDisplayed();

	}

}
