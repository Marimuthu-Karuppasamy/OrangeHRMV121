package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	@CacheLookup
	private WebElement txtDashboard;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	@CacheLookup
	private WebElement crisRodriguez;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	@CacheLookup
	private WebElement btnLogout;

	public boolean isDashBoradPageExists() {
		try {
			return (txtDashboard.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}
	
	public void clickLogout() {
		crisRodriguez.click();
		btnLogout.click();
	}

}
