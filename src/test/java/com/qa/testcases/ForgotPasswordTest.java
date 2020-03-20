package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;


import org.testng.annotations.BeforeTest;
import java.io.IOException;

import com.qa.pages.ForgotPassword;
import com.qa.testbase.TestBase;

public class ForgotPasswordTest extends TestBase {

	public ForgotPasswordTest() throws IOException {
		super();

	}


	ForgotPassword forgotPassword;



	@BeforeTest
	public void setUp() throws IOException {

		initialize();

		forgotPassword = new ForgotPassword();

	}


	@Test(priority = 0)
	public void forgotPasswordlinkvisiblitytest() {

		try {
			boolean ForgotPassword = forgotPassword.ForgotPasswordLinkVisiblity();
			Assert.assertTrue(ForgotPassword);

			System.out.println("Forgot Password link is visible");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/*@Test(priority = 1)
	public void resetPasswordTest() {
		try {

			forgotPassword.validateResetPasswordFunctionality();

			System.out.println("Reset password functionality is working ");

		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}*/


	@Test(priority = 1)
	public void resetPasswordTest() {

		try {
			forgotPassword.validateForgotPasswordclickable();
			forgotPassword.validateResetPasswordFunctionality();
			System.out.println("Reset password functionality is working");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/*@AfterTest
	public void driverQuitter() {
		driver.quit();*/
}




