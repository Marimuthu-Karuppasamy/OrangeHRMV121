package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.DashboardPage;
import pageobjects.LoginPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) {
		try {
			logger.info("***** Starting TC003_OrangeHRM_LoginDDT Test *****");

			LoginPage login = new LoginPage(driver);
			login.setuserName(email);
			logger.info("Enter the UserName");

			login.setPassword(pwd);
			logger.info("Enter the Password");

			login.clickLogin();
			logger.info("Clicked on Login button");

//		String txtVerifyDashBoard = login.txtVerifyDashBoard();
//		logger.info("Validating expected message!");
//
//		if (txtVerifyDashBoard.equals("Dashboard")) {
//
//			Assert.assertTrue(true);
//		}

			DashboardPage dp = new DashboardPage(driver);
			boolean targetPage = dp.isDashBoradPageExists();

			if (exp.equalsIgnoreCase("valid")) {
				if (targetPage == true) {

					dp.clickLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					dp.clickLogout();
					Assert.assertTrue(false);

				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*******TC003_Test End!...******");
	}
}
