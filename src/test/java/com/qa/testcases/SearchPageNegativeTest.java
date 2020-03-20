package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.SearchPage;
import com.qa.pages.dashboard;
import com.qa.testbase.TestBase;

public class SearchPageNegativeTest extends TestBase {


	LoginPage loginPage;
	dashboard Dashboard;
	SearchPage searchPage;

	public SearchPageNegativeTest() throws IOException {
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

	public void specialCharactersTest() {
		Dashboard = searchPage.login();
		searchPage.ValidateLogin();
		boolean Search = searchPage.validateSearchFieldVisiblity();
		Assert.assertTrue(Search);
		boolean SearchPlaceholder = searchPage.validateSearchFieldPlaceholderVisiblity();
		Assert.assertTrue(SearchPlaceholder);
		searchPage.validateSpecialCharacters();
		System.out.println("Special characters are not allowed in search field");

	}


	/*@AfterTest
	public void driverQuitter() {
		driver.quit();*/


	}

