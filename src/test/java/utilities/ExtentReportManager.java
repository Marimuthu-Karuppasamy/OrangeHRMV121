package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the Report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test
							// methods.

	String repName;

	@Override
	public void onStart(ITestContext context) {
//		ITestListener.super.onStart(context);

		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MMM/dd-HH:mm:ss");
		 * Date dt = new Date(); String current_date_time_stamp = dateFormat.format(dt);
		 */

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

		repName = "Test-Report-" + timeStamp + ".html";

		String pathReport = System.getProperty("user.dir") + "\\Reports\\"+ repName;
		
//		String pathReport1 = System.getProperty("user.dir") + "\\Reports\\"+ repName;

		sparkReporter = new ExtentSparkReporter(pathReport);
		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
		sparkReporter.config().setReportName("Functional Testing"); // Name of the Report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "OrangeHRM");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Recruitment");

		extent.setSystemInfo("Username", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

//		
//		extent.setSystemInfo("Computer Name", "localhost");
//		extent.setSystemInfo("Tester Name", "Marimuthu");
//		extent.setSystemInfo("OS", "Windows 11 Pro");
//		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());

		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		System.out.println("On onTestStart Method : Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		create a new entry in the report
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() + " got successfully executed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.SKIP, result.getName() + " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String img_path = new BaseClass().capture_screen(result.getName());
			test.addScreenCaptureFromPath(img_path);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

		String path_of_Extent_Report = System.getProperty("user.dir") + "\\Reports\\" + repName;
		File extent_report = new File(path_of_Extent_Report);

		try {
			Desktop.getDesktop().browse(extent_report.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//		
//			URL url = new URL("file:///"+System.getProperty("user.dir")+"\\Reports\\"+repName);
//			ImageHtmlEmail email = new ImageHtmlEmail();
//			email.setDataSourceResolver(new DataSourceUrlResolver(url));
//			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("marimuthu.k@ciglobalsolutions.com", "password"));
//			email.setSSLOnConnect(true);
//			email.setFrom("marimuthu.k@ciglobalsolutions.com");
//			email.setSubject("Test Result");
//			email.setMsg("Please find the attached reports...");
//			email.addTo("anyone@example.com");
//			email.attach(url,"extent report","please check report");
//			email.send();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
