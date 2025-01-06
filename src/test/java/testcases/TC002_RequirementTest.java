package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.Recruitmentpage;
import testbase.BaseClass;

public class TC002_RequirementTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_recruitment() {
		logger.info("*****Starting TC_002_RecruitmentTest******");
		try {
			
			
			LoginPage lp = new LoginPage(driver);
			lp.setuserName("Admin");
			lp.setPassword("admin123");
			lp.clickLogin();
			boolean myDashboardPageExists = lp.isMyDashboardPageExists();
			Assert.assertEquals(myDashboardPageExists, true, "Login failed!");
			
			Recruitmentpage rc = new Recruitmentpage(driver);
			logger.info("clicked on Recruitment!");
			rc.clickRecruitmentMenu();
			logger.info("Add Candidate");
			rc.addCandidate();
		} catch (Exception e) {
			Assert.fail();

		}
		logger.info("*****Finished TC_002_RequirementTest******");

	}

}
