package com.qa.testcases;


import org.testng.annotations.Test;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;
import com.qa.pages.dashboard;
import com.qa.testbase.TestBase;

public class SearchPageTest extends TestBase {

	LoginPage loginPage;
	dashboard Dashboard;
	SearchPage searchPage;

	public SearchPageTest() throws IOException {
		super();	

	}







	@BeforeTest
	public void setUp() throws IOException {

		initialize();

		searchPage = new SearchPage();
		loginPage = new LoginPage();
		Dashboard = new dashboard();
	}



	@Test(priority = 1)
	public void searchFieldTest() {

		Dashboard = searchPage.login();
		searchPage.ValidateLogin();
		boolean Search = searchPage.validateSearchFieldVisiblity();
		Assert.assertTrue(Search);
		boolean SearchPlaceholder = searchPage.validateSearchFieldPlaceholderVisiblity();
		Assert.assertTrue(SearchPlaceholder);
		searchPage.validatePlaceholderDisappear();
		System.out.println("Search field placeholder disappears");
		System.out.println("Search Field is visible");
		System.out.println("Search field placeholder is visible");
		System.out.println("Search is working");
		//searchPage.validateAutoSuggestions();
		//searchPage.validateCheckBox();

	}


	@Test(priority = 2)
	public void autoSuggestionsTest() {

		Dashboard = searchPage.login();
		searchPage.ValidateLogin();
		searchPage.validateAutoSuggestions();
		System.out.println("Auto suggestions are working");

	}

	@Test(priority = 3)
	public void keyboardTest() throws InterruptedException, AWTException {
		Dashboard = searchPage.login();

		try {
			searchPage.validKeyboardTest();
			System.out.println("Enter key on keyboard is working");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}


	@Test(priority = 4)
	public void invalidKeywordTest() {
		Dashboard = searchPage.login();
		//searchPage.validateSpecialCharacters();
		searchPage.validateInvalidKeyword();
		System.out.println("No results found");
	}


	@Test(priority = 5)
	public void BlankSearchFieldTest() {
		try {
			Dashboard = searchPage.login();
			searchPage.validateBlankSearchField();
			System.out.println("Search field cannot be blank");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}


	@Test(priority = 6)
	public void validateNavigationTest() {
		try {
			Dashboard = searchPage.login();
			searchPage.validateNavigation();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}




	@AfterTest
	public void driverQuitter() {
		driver.quit();

	}
}




