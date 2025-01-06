package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger; // log4j
	public Properties pty;

	@BeforeClass(groups = { "sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
		/*
		 * lodding config files
		 */
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		pty = new Properties();
		pty.load(file);

		logger = LogManager.getLogger(this.getClass());

		if (pty.getProperty("execution_environment").equalsIgnoreCase("remote")) {

			DesiredCapabilities cap = new DesiredCapabilities();

			// Operating system
			if (os.equalsIgnoreCase("windows")) {

				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			} else {
				System.out.println("No Matching os");
				return;
			}

			// Browser setup

			switch (br.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");

				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");

				break;
			case "firefox":
				cap.setBrowserName("Firefox");

			default:
				System.out.println("No Matching browser");
				return;
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

		}

		if (pty.getProperty("execution_environment").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("Invalid Browser name..");
				return;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pty.getProperty("appurl"));

		driver.manage().window().maximize();
		@Nullable
		String title = driver.getTitle();
		Assert.assertEquals("OrangeHRM", title);

	}

	@AfterClass(groups = { "sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();

	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);

		return generatedString;

	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumber() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return (generatedString + "@" + generatedNumber);
	}

	public String capture_screen(String tname) {
		String time_Stamp = new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source_file = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String target_file_path = System.getProperty("user.dir") + "\\Screenshots\\" + tname + "_" + time_Stamp;
		File target_file = new File(target_file_path);

		source_file.renameTo(target_file);

		return target_file_path;

	}

}
