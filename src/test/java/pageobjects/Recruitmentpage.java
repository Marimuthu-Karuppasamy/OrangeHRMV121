package pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Recruitmentpage extends BasePage {
	public Recruitmentpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h6[normalize-space()='Recruitment']")
	@CacheLookup
	private WebElement verifyRecruitment;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	@CacheLookup
	private WebElement txtFirstName;

	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	@CacheLookup
	private WebElement txtMiddleName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	@CacheLookup
	private WebElement txtLastName;

	@FindBy(xpath = "//label[text()='Email']//following::input[@placeholder='Type here']")
	@CacheLookup
	private WebElement txtEmail;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	@CacheLookup
	private WebElement btnSave;

	@FindBy(xpath ="//span[text()='Recruitment']")
	@CacheLookup
	private WebElement menuRecruitment;
	
	
	@FindBy(xpath ="//button[text()=' Add ']")
	@CacheLookup
	private WebElement btnAdd;
	
	public boolean isMyRegistrationPageExists() {

		try {
			return (verifyRecruitment.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}
	
	public void clickRecruitmentMenu() {
		menuRecruitment.click();
		verifyRecruitment.isDisplayed();
	}
	
	public void addCandidate() {
		btnAdd.click();
		RandomStringUtils rs = new RandomStringUtils();
		String randomAlphabetic = rs.randomAlphabetic(2);
		String firstName ="Test";
		String lastName = "Manager";
				
		txtFirstName.sendKeys(firstName);
		txtMiddleName.sendKeys(randomAlphabetic);
		txtLastName.sendKeys(lastName);
		txtEmail.sendKeys(firstName+lastName+randomAlphabetic+"@ymail.com");
		btnSave.click();
	}
}
