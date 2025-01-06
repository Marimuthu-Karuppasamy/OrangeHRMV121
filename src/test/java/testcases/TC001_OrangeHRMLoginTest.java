package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import testbase.BaseClass;

public class TC001_OrangeHRMLoginTest extends BaseClass {

	@Test(groups = {"sanity","Master"})
	public void verify_Login() {
		logger.info("***** Starting TC001_OrangeHRMLoginTest *****");
		try {
			LoginPage login = new LoginPage(driver);
			login.setuserName(pty.getProperty("username"));
			logger.info("Enter the UserName");

			login.setPassword(pty.getProperty("password"));
			logger.info("Enter the Password");

			login.clickLogin();
			logger.info("Clicked on Login button");

			String txtVerifyDashBoard = login.txtVerifyDashBoard();
			logger.info("Validating expected message!");

			if (txtVerifyDashBoard.equals("Dashboard")) {

				Assert.assertTrue(true);

			} else {
				logger.info("Verify the Dashboard in text");
				logger.error("Test faild...");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
				;
			}

			System.out.println("Executed successfully!...");

		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("Finished TC001_OrangeHRMLoginTest!....");

	}

}
