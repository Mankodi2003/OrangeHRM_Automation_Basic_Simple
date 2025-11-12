package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;

public class DashboardTest extends BaseClass {

	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setUpBrowser() {
		setUp();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	@Test
	public void verifyDashboardAndLogout() throws InterruptedException {
		// Step 1: Login
		loginPage.login("Admin", "admin123");
		Thread.sleep(2000);

		// Step 2: Verify dashboard header
		Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not displayed!");
		System.out.println("Dashboard Header: " + dashboardPage.getHeaderText());

		// Step 3: Logout
		dashboardPage.logout();
		Thread.sleep(2000);

		// Step 4: Verify user is back to login page
		String title = loginPage.getPageTitle();
		Assert.assertTrue(title.contains("OrangeHRM"), "Logout failed!");
		System.out.println("Successfully logged out!");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}