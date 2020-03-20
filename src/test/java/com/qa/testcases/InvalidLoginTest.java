package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.IOException;

import com.qa.pages.LoginPage;
import com.qa.pages.dashboard;
import com.qa.testbase.TestBase;



public class InvalidLoginTest extends TestBase {

	public InvalidLoginTest() throws IOException {
		super();

	}

	LoginPage loginPage;
	dashboard Dashboard;




	@BeforeMethod

	public void setUp() throws IOException {

		initialize();
		loginPage = new LoginPage();

	}

	@Test(priority = 0)
	public void invalidLoginTest() throws InterruptedException {

		loginPage.validateInvalidLogin("test@gmail.com","Test123",false);

	}


	@Test(priority = 1)
	public void InvalidEmailTest() throws InterruptedException {
		loginPage.validateInvalidEmail("test@gmail.com", "AKShay@123456", false);

	}

	@Test(priority = 2)
	public void InvalidPasswordTest() throws InterruptedException {
		loginPage.validateInvalidPassword("akshay.kulshrestha@talentelgia.in", "Test123", false);

	}


	@Test(priority = 3)
	public void blankLoginTest() throws InterruptedException {
		loginPage.validateBlankCredentials("Email", "Password");
	}



	@AfterMethod
	public void driverQuitter() {
		driver.quit();
	}



}
