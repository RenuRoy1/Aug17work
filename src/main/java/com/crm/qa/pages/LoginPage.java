package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory

	@FindBy(name = "email")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[text()=\"Login\"]")
	WebElement LoginButton;

	@FindBy(xpath = "//a[text()=\"Sign Up\"]")
	WebElement signUpLink;

	// PageFactory.initElements is a method provided by the Page Object Model (POM)
	// design pattern in Selenium WebDriver. This method is used to initialize the
	// web elements on a page object class. initElements is a static method of the
	// PageFactory class provided by Selenium. It initializes the web elements on a
	// page object by using annotations.

//	Annotations:
//	Annotations such as
//	@FindBy, @CacheLookup, and others
//	are used in conjunction
//	with PageFactory.
//	initElements.These annotations help Selenium
//	locate the web elements	on the page.

	// Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this); // pointing to current class object
	}

	// Methods or Features
	public String validateLoginPageTitle() {

		return driver.getTitle();

	}

	public HomePage login(String un, String pd) {
		userName.sendKeys(un);
		password.sendKeys(pd);
		LoginButton.click();
		return new HomePage();

	}
}
