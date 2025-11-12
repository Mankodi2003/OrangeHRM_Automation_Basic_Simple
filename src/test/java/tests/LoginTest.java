package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage loginPage;

	@BeforeMethod
	public void setUpBrowser() {
		setUp();
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void verifyValidLogin() throws InterruptedException {

		loginPage.login("Admin", "admin123");
		Thread.sleep(2000);

		Assert.assertTrue(loginPage.getPageTitle().contains("OrangeHRM"));
	}

	@Test(priority = 2)
	public void verifyInvalidLogin() throws InterruptedException {

		loginPage.login("Admin", "wrongpass");
		Thread.sleep(2000);

		String msg = loginPage.getErrorMessage();
		System.out.println("Error message : " + msg);

		Assert.assertTrue(msg.contains("Invalid credentials"));
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}