package com.qa.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.testbase.TestBase;

public class SearchPage extends TestBase {


	// Page Factory - OR:

	@FindBy(xpath = "//input[@type='text']")
	WebElement email;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "(//*[text()='Login'])[2]")
	WebElement loginBtn;

	@FindBy(css ="input[placeholder='Search ...']")
	WebElement Search;

	//@FindBy(xpath = "//input[@type='text']")
	//WebElement Search;


	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;

	@FindBy(xpath = "//input[@value='Sun']")
	//(//label[@class= 'css-label yellow-check'])[1]
	//(//div[@class ='form-check-wrap ng-star-inserted'])[1]
	//label[contains(.,'Sun')]
	WebElement Suncheckbox;

	@FindBy(xpath = "(//button[@class = 'dropdown-item ng-trigger ng-trigger-typeaheadAnimation ng-tns-c12-6 ng-star-inserted'])[2]")
	WebElement KeyboardEnter;


	// Initializing the page objects

	public SearchPage() throws IOException {
		PageFactory.initElements(driver, this);

	}


	//Actions:


	public void ValidateLogin() {

		Assert.assertTrue(true, "Login is successful");
		System.out.println("User logged in successfully");

	}

	public dashboard login () {

		email.sendKeys("akshaykulshrestha57@gmail.com");
		password.sendKeys("AKShay@123456");
		loginBtn.click();

		return new dashboard();

	}

	public boolean validateSearchFieldVisiblity() {
		return Search.isDisplayed();

	}



	public boolean validateSearchFieldPlaceholderVisiblity() {
		return Search.isDisplayed();


	}


	public void validatePlaceholderDisappear() {


		Actions actions = new Actions(driver);
		actions.moveToElement(Search).perform();
		Search.click();
		Search.sendKeys("GRE");
		Submit.click();
	}

	public void validateCheckBox() {

		Suncheckbox.isSelected();
		Suncheckbox.click();
	}

	public void validateSpecialCharacters() {

		Actions actions = new Actions(driver);
		actions.moveToElement(Search).perform();
		WebDriverWait wait = new WebDriverWait(driver,20);
		Search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Search ...']")));
		Search.click();
		Search.sendKeys("*/");
		Submit.click();

	}


	public void validateAutoSuggestions() {

		Actions actions = new Actions(driver);
		actions.moveToElement(Search).perform();
		Search.click();
		Search.sendKeys("Biology");

	}


	public void validKeyboardTest() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(Search).perform();
		WebDriverWait wait = new WebDriverWait(driver,20);
		Search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Search ...']")));

		Search.click();
		Search.sendKeys("Biology");
		

		//WebDriverWait wait1 = new WebDriverWait(driver,20);
		//KeyboardEnter = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class ='dropdown-item ng-trigger ng-trigger-typeaheadAnimation ng-tns-c12-4 ng-star-inserted']")));
		//Thread.sleep(20000);
		
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void validateInvalidKeyword() {

		Actions actions = new Actions(driver);
		actions.moveToElement(Search).perform();
		WebDriverWait wait = new WebDriverWait(driver,20);
		Search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Search ...']")));
		Search.click();
		Search.sendKeys("anz");
		Submit.click();
	}
	
	public void validateBlankSearchField() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(Search).perform();
		WebDriverWait wait = new WebDriverWait(driver,20);
		Search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Search ...']")));
		Search.click();
		//Search.sendKeys("");
		Submit.click();
	}


	// This will select the checkbox
	//Suncheckbox.click();

	// Check whether the checkbox is selected
	/*if(Suncheckbox.isSelected()) {
			System.out.println("Sun checkbox is selected");
		} else {

			System.out.println("Sun checkbox is not selected");
		}

		// This should deselect the checkbox
		Suncheckbox.click();

		// Let see whether checkbox is not selected
		if(!Suncheckbox.isSelected()) {
			System.out.println("Sun checkbox is not selected");
		}*/

}






