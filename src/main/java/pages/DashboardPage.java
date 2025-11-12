package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;

	// ---- Locators ----
	By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	By profileMenu = By.xpath("//p[@class='oxd-userdropdown-name']");
	By logoutLink = By.xpath("//a[text()='Logout']");

	// ---- Constructor ----
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// ---- Page Actions ----
	public String getHeaderText() {
		return driver.findElement(dashboardHeader).getText();
	}

	public void clickProfileMenu() {
		driver.findElement(profileMenu).click();
	}

	public void clickLogout() {
		driver.findElement(logoutLink).click();
	}

	public boolean isDashboardDisplayed() {
		return driver.findElement(dashboardHeader).isDisplayed();
	}

	public void logout() throws InterruptedException {
		clickProfileMenu();
		Thread.sleep(1000); // just to make sure dropdown is visible
		clickLogout();
	}
}