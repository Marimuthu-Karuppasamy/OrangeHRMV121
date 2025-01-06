package wastepackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_AccountRegistrationTest {
//	
//	public WebDriver driver;
//
//	@BeforeClass
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//		
//		driver.manage().window().maximize();
//	}
//	
//	@AfterClass
//	public void tearDown() {
////		driver.quit();
//		
//	}
//	
//	@Test
//	public void verify_account_registration() throws InterruptedException{
//		
//		
//		Thread.sleep(2000);
//		HomePage hp = new HomePage(driver);
//		
//		hp.clickMyAccount();
//		hp.clickRegister();
//		
//		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
//		regPage.setFirstName("John");
//		regPage.setLastName("David");
//		regPage.setEmail("john.david@gmail.com");
//		
//		regPage.setPassword("John@123");
//		
//		regPage.clickAgree();
//		regPage.clickContinue();
//		
//		String confirmationMsg = regPage.getConfirmationMsg();
//		Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");
//	}
}
