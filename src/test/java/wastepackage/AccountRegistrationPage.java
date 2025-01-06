package wastepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import pageobjects.BasePage;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	@CacheLookup
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	@CacheLookup
	private WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	@CacheLookup
	private WebElement txtEMail;

	@FindBy(xpath = "//input[@id='input-password']")
	@CacheLookup
	private WebElement txtPassword;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	@CacheLookup
	private WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Register Account']")
	@CacheLookup
	private WebElement txtRegisterAccount;

	@FindBy(xpath="//a[normalize-space()='Your Account Has Been Created!']") 
	@CacheLookup 
	private WebElement msgConfirmation;
	
	@FindBy(xpath = "//input[@name='agree']")
	@CacheLookup
	private WebElement btnAgree;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEMail.sendKeys(email);
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);

	}

	public void clickAgree() {
		btnAgree.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
