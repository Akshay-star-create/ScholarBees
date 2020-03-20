package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.io.IOException;
import org.testng.Assert;
import com.qa.pages.LoginPage;
import com.qa.pages.dashboard;
import com.qa.testbase.TestBase;

public class LoginPageTest extends TestBase {
	
	

	LoginPage loginPage;
	dashboard Dashboard;



	public LoginPageTest() throws IOException {
		super();

	}





	@BeforeTest
	public void setUp() throws IOException {

		initialize();
		loginPage = new LoginPage();

	}

	@Test (priority = 1)
	public void titleTest() {
		loginPage.verifyPageTitle();


	}

	@Test (priority = 2)
	public void loginPageElementsVisiblityTest() {

		try {
			boolean Email = loginPage.validateEmailElementVisiblity();
			Assert.assertTrue(Email);

			boolean Password = loginPage.validatePasswordElementVisiblity();
			Assert.assertTrue(Password);


			boolean RememberMe = loginPage.validateRememberMeElementVisiblity();
			Assert.assertTrue(RememberMe);

			boolean ForgotPassword = loginPage.validateForgotPasswordElementVisiblity();
			Assert.assertTrue(ForgotPassword);

			boolean loginBtn = loginPage.validateLoginButtonElementVisiblity();
			Assert.assertTrue(loginBtn);

			boolean ScholarBeesLogo = loginPage.validateScholarBeesLogoVisiblity();
			Assert.assertTrue(ScholarBeesLogo);

			System.out.println("Login Page Elements are visible");


		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Test(priority = 3)
	public void LoginUrlTest() {
		loginPage.validateLoginUrl();


	}


	@Test(priority = 4)
	public void loginPageTest() throws IOException {
		try {

			Dashboard = loginPage.login(prop.getProperty("Email"),prop.getProperty("Password"));
			loginPage.validateLogin();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}




	@Test(priority = 5)
	public void browserNavigationTest() throws IOException, InterruptedException {
		Dashboard = loginPage.login(prop.getProperty("Email"),prop.getProperty("Password"));
		loginPage.validateBrowserNavigation();
	}


	

		@AfterTest
		public void driverQuitter() {
			driver.quit();

		}
}





	





