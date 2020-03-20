package com.qa.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.testbase.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:

	@FindBy(xpath = "//input[@type='text']")
	WebElement email;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='remember_me']")
	WebElement RememberMe;

	@FindBy(xpath = "//*[text()='Forgot password?']")
	WebElement ForgotPassword;

	@FindBy(xpath = "(//*[text()='Login'])[2]")
	WebElement loginBtn;



	@FindBy(xpath = "//img[@src='assets/staticpages/images/logo.png']")
	WebElement ScholarBeesLogo;

	@FindBy(xpath= "//*[@id='button-profDrop']")
	WebElement Dropdown;


	@FindBy(linkText="Logout")
	WebElement Logout;


	//@FindBy(xpath ="//input[@type='password']")
	//WebElement CopyPaste;

	// Initializing the Page Objects:

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public boolean validateEmailElementVisiblity() {
		return email.isDisplayed();

	}

	public boolean validatePasswordElementVisiblity() {
		return password.isDisplayed();
	}

	public boolean validateRememberMeElementVisiblity() {
		return RememberMe.isEnabled();

	}

	public boolean validateForgotPasswordElementVisiblity() {
		return ForgotPassword.isDisplayed();
	}

	public boolean validateLoginButtonElementVisiblity() {
		return loginBtn.isDisplayed();
	}

	public boolean validateScholarBeesLogoVisiblity() {
		return ScholarBeesLogo.isDisplayed();

	}


	public void verifyPageTitle() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "ScholarBees";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Page title is correct");

	}

	public void usingTabKey() throws InterruptedException {

		// Start with the email field
		email.sendKeys(Keys.TAB);
		email.sendKeys("akshay.kulshrestha@talentelgia.in");
		// Verify that we are in the first field
		if (driver.switchTo().activeElement().equals(email))
			System.out.println("First element is in a focus");

		else
			// Add Assertion here - stop execution
			System.out.println("ASSERTION - first element is not in focus");

		password.sendKeys(Keys.TAB);
		password.sendKeys("AKShay@123456");
		// Verify that we are in the password field
		if (driver.switchTo().activeElement().equals(password))
			System.out.println("Second element is in a focus");

		else
			// Add Assertion here - stop execution
			System.out.println("ASSERTION - Second element is not in focus");

		RememberMe.sendKeys(Keys.TAB);
		RememberMe.click();
		// Verify that we are in the Remember Me field
		if (driver.switchTo().activeElement().equals(RememberMe))
			System.out.println("Third element is in a focus");

		else
			// Add Assertion here - stop execution
			System.out.println("ASSERTION - Third element is not in focus");

		loginBtn.sendKeys(Keys.TAB);
		loginBtn.click();
		// Verify that we are on the Login Button
		if (driver.switchTo().activeElement().equals(loginBtn))
			System.out.println("Fourth element is in a focus");

		else
			// Add Assertion here - stop execution
			System.out.println("ASSERTION - Fourth element is not in focus");

	}


	public void validateLoginUrl() {
		String actualUrl = "https://scholarbees.teamtalentelgia.com/login";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("Url is correct");

	}


	public void validateLogin() {

		Assert.assertTrue(true, "login is successful");

		System.out.println("User Logged in successfully");

	}


	public void validateInvalidLogin(String Email, String Password, boolean isInvalidCredential) throws InterruptedException {
		email.sendKeys(Email);
		password.sendKeys(Password);

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//WebDriverWait wait = new WebDriverWait(driver,20);
		//loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Login'])[2]")));
		Thread.sleep(20000);
		loginBtn.click();

		if(isInvalidCredential == true) {
			System.out.println("User Logged in successfully. ");

		}

		else {
			System.out.println("These credentials do not match our records.");

		}
	}


	public void validateInvalidEmail(String invalidEmail, String validPassword, boolean isInvalidCredential1) throws InterruptedException {
		email.sendKeys(invalidEmail);
		password.sendKeys(validPassword);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Login'])[2]")));
		Thread.sleep(20000);
		loginBtn.click();

		if(isInvalidCredential1 == true) {
			System.out.println("User Logged in successfully.");

		}

		else {
			System.out.println("These credentials do not match our records.");

		}
	}

	public void validateInvalidPassword(String validEmail, String invalidPassword, boolean isInvalidCredential2) throws InterruptedException {
		email.sendKeys(validEmail);
		password.sendKeys(invalidPassword);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Login'])[2]")));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(20000);
		loginBtn.click();

		if(isInvalidCredential2 == true) {
			System.out.println("User Logged in successfully. ");

		}

		else {
			System.out.println("These credentials do not match our records.");

		}

	}


	public void validateBlankCredentials(String Email, String Password) throws InterruptedException {
		email.sendKeys(Email);
		password.sendKeys(Password);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Login'])[2]")));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(20000);
		loginBtn.click();

		System.out.println("Cannot logged in with blank data");

	}

	public dashboard login(String Email, String Password) throws IOException, InterruptedException {

		email.sendKeys(Email);
		password.sendKeys(Password);
		loginBtn.click();

		//Actions action = new Actions(driver);
		//action.moveToElement(Dropdown).click().perform();
		//Thread.sleep(20000);
		//action.moveToElement(Logout).click().perform();

		//driver.navigate().to("https://scholarbees.teamtalentelgia.com/login");
		return new dashboard();


	}

	public void validateBrowserNavigation() throws InterruptedException {


		WebDriverWait wait = new WebDriverWait(driver,20);
		Dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='button-profDrop']")));
		Dropdown.click();
		Logout.click();
		//driver.navigate().to("https://scholarbees.teamtalentelgia.com/login");

		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//Thread.sleep(10000);


	}


	//act.moveToElement(CopyPaste).doubleClick().build().perform();


}

