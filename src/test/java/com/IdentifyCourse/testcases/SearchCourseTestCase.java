package com.IdentifyCourse.testcases;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.IdentifyCourse.appmodule.DriverSetup;
import com.IdentifyCourse.appmodule.Pom;
import com.IdentifyCourse.datautilites.ExcelUtils;
import com.IdentifyCourse.datautilites.ExtentReportManager;
import com.IdentifyCourse.datautilites.Screenshot;
import com.IdentifyCourse.exceptions.ScreenshotNotTakenException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class SearchCourseTestCase extends DriverSetup {
	public static WebDriver driver = null;
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	static String path = System.getProperty("user.dir");
	public static WebDriverWait wait;

	@BeforeClass(groups = { "Regression" })
	public void beforeClass() throws Exception {
		logger = report.createTest("Search coursename Test Case");
		DriverSetup dri = new DriverSetup();
		driver = dri.setupDriver();
		wait=new WebDriverWait(driver,30);
	}

	@AfterClass(groups = { "Regression" })
	public void afterClass() {
		driver.quit();
		report.flush();
	}

	
	@Test(priority = 1, groups = { "Regression" })
	public void openWebSite() throws IOException {
		logger.log(Status.INFO, "Website is opening...");
		String driverpath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(driverpath + "\\Resources\\config.properties");
		Properties p;
		p = new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		logger.log(Status.PASS, "Website is opened");
	}

	/*********Searching Web Development Course**********/
	@Test(priority = 2, groups = { "Regression" })
	public static void execution() throws InterruptedException, IOException {

		logger.log(Status.INFO, "Searching Web Development Course");
		String driverpath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(driverpath + "\\Resources\\config.properties");
		Properties p;
		p = new Properties();
		p.load(fis);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Pom.getCoursename().sendKeys(ExcelUtils.getCellValue(path, "InputData", 1, 1));
		Pom.getCoursenameclick().click();
		logger.log(Status.PASS, "Web Development Courses is searched");
	}
	
	/*********Selection of different filters**********/
	@Test(priority = 3, groups = { "Regression" })
	public void selectLevels() throws InterruptedException {
		logger.log(Status.INFO, "Selection of different filters");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pom.lang));
		Pom.getLang().click();
		Pom.getLangclick().click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Pom.level));
		Pom.getLevel().click();
		Pom.getLevelclick().click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Pom.learning));
		Pom.getLearning().click();
		Pom.getLearningclick().click();
		logger.log(Status.PASS, "different filters is selected");
	}
	
	/*********Fetching course details**********/
	@Test(priority = 4, groups = { "Regression" })
	public void courseDetails() throws Exception {
		logger.log(Status.INFO, "Fetching course details");
		String firstcoursename =Pom.getFirstcoursename().getText();
		System.out.println("FirstName is:" + firstcoursename);
		String secondcoursename = Pom.getSecondcoursename().getText();
		System.out.println("secondName is:" + secondcoursename);

		String firstreview = Pom.getFirstreview().getText();
		String secondreview = Pom.getSecondreview().getText();
		System.out.println("FirstReview is:" + firstreview + " " + "SecondReview is" + secondreview);

		Pom.getButton1().click();
		String parentwindow = driver.getWindowHandle();
		Set<String> fcourse = driver.getWindowHandles();
		for (String i : fcourse) {
			if (!i.contentEquals(parentwindow)) {
				driver.switchTo().window(i);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String value1 = Pom.getFirstduration().getText();
				System.out.println("Firstcoursenamehours" + value1);
				driver.close();

			}

			driver.switchTo().window(parentwindow);
		}

		Pom.getButton2().click();
		Set<String> scourse = driver.getWindowHandles();
		for (String i : scourse) {
			if (!i.contentEquals(parentwindow)) {
				driver.switchTo().window(i);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String value1 =Pom.getSecondduration().getText();
				System.out.println("secondcoursenamehours" + value1);
				driver.close();

			}

			driver.switchTo().window(parentwindow);
			logger.log(Status.PASS, "Course Details fetched Succesfully");
		}

	}

	/*********Taking Screenshot**********/
	@Test(priority = 5)
	public void screenshot() throws Exception {
		
		try {
			Screenshot.takeScreenShot("SearchCourse");
			logger.log(Status.PASS, "Screenshot captured!....");
			}
			catch(ScreenshotNotTakenException e)
			{
				e.getMessage();
				
			}
	}
}
