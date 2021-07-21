package com.IdentifyCourse.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.IdentifyCourse.appmodule.DriverSetup;
import com.IdentifyCourse.appmodule.Pom;
import com.IdentifyCourse.datautilites.ExcelUtils;
import com.IdentifyCourse.datautilites.ExtentReportManager;
import com.IdentifyCourse.datautilites.Screenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SearchCourseTestCase extends DriverSetup {
	public static WebDriver driver = null;
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	static String path = System.getProperty("user.dir");

	@BeforeClass(groups = { "Regression" })
	public void beforeClass() throws Exception {
		logger = report.createTest("Search coursename!...");
		DriverSetup dri = new DriverSetup();
		driver = dri.setupDriver();

	}

	@AfterClass(groups = { "Regression" })
	public void afterClass() {
		driver.quit();
		report.flush();
	}

	@Test(priority = 1, groups = { "Regression" })
	public void openWebSite() throws IOException {
		logger.log(Status.INFO, "Openwebsite");
		String driverpath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(driverpath + "\\Resources\\config.properties");
		Properties p;
		p = new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		logger.log(Status.PASS, "Done");
	}

	@Test(priority = 2, groups = { "Regression" })
	public static void execution() throws InterruptedException, IOException {

		logger.log(Status.INFO, "search course");
		String driverpath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(driverpath + "\\Resources\\config.properties");
		Properties p;
		p = new Properties();
		p.load(fis);

		String parentwindow = driver.getWindowHandle();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Pom.getCoursename().sendKeys(ExcelUtils.getCellValue(path, "InputData", 1, 1));

		Pom.getCoursenameclick().click();
		Pom.getLang().click();
		Pom.getLangclick().click();

		Pom.getLevel().click();
		Pom.getLevelclick().click();

		Pom.getLearning().click();
		Pom.getLearningclick().click();

		String firstcoursename = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]"))
				.getText();
		System.out.println("FirstName is:" + firstcoursename);
		String secondcoursename = driver.findElement(By.xpath(
				"//html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]"))
				.getText();
		System.out.println("secondName is:" + secondcoursename);

		String firstreview = driver.findElement(By.xpath(
				"//*[@id=\"main\"]/div/div/div[1]/div[2]/div/div/div/div/div/ul/li[1]/div/div/div/div/div/div[2]/div[4]/div[1]/div[1]/div/span[1]"))
				.getText();
		String secondreview = driver.findElement(By.xpath(
				"//*[@id=\"main\"]/div/div/div[1]/div[2]/div/div/div/div/div/ul/li[2]/div/div/div/div/div/div[2]/div[4]/div[1]/div[1]/div/span[1]"))
				.getText();
		System.out.println("FirstReview is:" + firstreview + " " + "SecondReview is" + secondreview);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]"))
				.click();
		Set<String> fcourse = driver.getWindowHandles();
		for (String i : fcourse) {
			if (!i.contentEquals(parentwindow)) {
				driver.switchTo().window(i);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String value1 = driver
						.findElement(
								By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[5]/div[2]"))
						.getText();
				System.out.println("Firstcoursenamehours" + value1);
				driver.close();

			}

			driver.switchTo().window(parentwindow);
		}

		driver.findElement(By.xpath(
				"//html[1]/body[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]"))
				.click();
		Set<String> scourse = driver.getWindowHandles();
		for (String i : scourse) {
			if (!i.contentEquals(parentwindow)) {
				driver.switchTo().window(i);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				String value1 = driver
						.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div/div[6]/div[2]"))
						.getText();
				System.out.println("secondcoursenamehours" + value1);
				driver.close();

			}

			driver.switchTo().window(parentwindow);
			logger.log(Status.PASS, "Done");
		}

	}

	@Test(priority = 3)
	public void screenshot() throws Exception {
		Screenshot.takeScreenShot("SearchCourse");
	}
}
