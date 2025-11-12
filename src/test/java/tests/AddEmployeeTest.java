package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import pages.AddEmployeePage;
import org.openqa.selenium.By;

public class AddEmployeeTest extends BaseClass {

	LoginPage loginPage;
	AddEmployeePage addEmpPage;

	@BeforeMethod
	public void setUpBrowser() {
		setUp();
		loginPage = new LoginPage(driver);
		addEmpPage = new AddEmployeePage(driver);
	}

	@Test
	public void verifyAddEmployee() throws InterruptedException {

		// step-1 : Login...
		loginPage.login("Admin", "admin123");
		Thread.sleep(2000);

		// step-2 : Go To Add Employee Page...
		addEmpPage.openAddEmployeePage();

		// step-3 : Enter Details and Save...
		addEmpPage.enterEmployeeDetails("John", "D", "Smith");
		addEmpPage.clickSave();
		Thread.sleep(3000);

		// step-4 : Verify success...
		String header = driver.findElement(By.xpath("//h6[text()='Personal Details']")).getText();
		System.out.println("Header Text: " + header);

		Assert.assertEquals(header, "Personal Details",
				"Employee not added successfully — Personal Details page not displayed!");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}