package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	@CacheLookup
	private WebElement txtUsername;

	@FindBy(xpath = "//input[@placeholder='Password']")
	@CacheLookup
	private WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	@CacheLookup
	private WebElement btnLogin;

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	@CacheLookup
	private WebElement txtDashboard;

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']")
	@CacheLookup
	private WebElement menuRecruitment;

	public void setuserName(String username) {
		txtUsername.sendKeys(username);

	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);

	}

	public void clickLogin() {
		btnLogin.click();

	}

	public boolean isMyDashboardPageExists() {

		try {
			return (txtDashboard.isDisplayed());

		} catch (Exception e) {
			return false;
		}

	}

	public String txtVerifyDashBoard() {
		String text = txtDashboard.getText();

		return text;

	}

	public void clickRequirement() {
		menuRecruitment.click();

	}

}
