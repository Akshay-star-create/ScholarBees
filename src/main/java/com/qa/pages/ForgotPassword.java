package com.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.testbase.TestBase;

public class ForgotPassword extends TestBase {

	public ForgotPassword() throws IOException {
		super();

	}

	// Page Factory - OR:


	@FindBy(xpath ="//input[@formcontrolname='email']")
	WebElement email;

	@FindBy(linkText="Forgot password?")
	WebElement ForgotPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SendResetLink;

	// Initializing the Page Objects:

	public void forgotPassword() {
		PageFactory.initElements(driver, this);

	}


	// Actions

	public boolean ForgotPasswordLinkVisiblity() {
		return ForgotPassword.isDisplayed();	
	}


	public void validateForgotPasswordclickable() {

		//Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait  = new WebDriverWait(driver,30);
		//ForgotPassword = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot password?")));
		ForgotPassword.click();

		//WebDriverWait wait1 = new WebDriverWait(driver,30);
		//email = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='email']")));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//email.sendKeys("akshay.kulshrestha@talentelgia.in");

		//WebDriverWait wait2 = new WebDriverWait(driver,30);
		//SendResetLink = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//SendResetLink.clic	k();
	}


	public void validateResetPasswordFunctionality() {
		email.sendKeys("akshay.kulshrestha@talentelgia.in");
		SendResetLink.click();

	}

}

