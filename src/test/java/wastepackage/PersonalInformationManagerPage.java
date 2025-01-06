package wastepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import pageobjects.BasePage;

public class PersonalInformationManagerPage extends BasePage {

	public PersonalInformationManagerPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='PIM']")
	@CacheLookup

	private WebElement pIM;

	@FindBy(xpath = "//h6[normalize-space()='PIM']")
	@CacheLookup
	private WebElement txtVerifypIM;
	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	@CacheLookup
	private WebElement addEmployee;
	@FindBy(xpath = "//input[@placeholder='First Name']")
	@CacheLookup
	private WebElement firstName;
	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	@CacheLookup
	private WebElement middleName;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	@CacheLookup
	private WebElement lastName;
	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	@CacheLookup
	private WebElement employeeId;
	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	@CacheLookup
	private WebElement createLoginDetails;
	@FindBy(xpath = "//body/div/div/div/div/div/div/form/div/div/div/div/div[2]/div[1]/div[2]/input[1]")
	@CacheLookup
	private WebElement username;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	@CacheLookup
	private WebElement password;
	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	@CacheLookup
	private WebElement confirmPassword;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	@CacheLookup
	private WebElement save;

}
