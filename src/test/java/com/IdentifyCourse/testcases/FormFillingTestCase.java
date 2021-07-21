package com.IdentifyCourse.testcases;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import com.IdentifyCourse.appmodule.DriverSetup;
import com.IdentifyCourse.appmodule.Pom;
import com.IdentifyCourse.datautilites.ExcelUtils;
import com.IdentifyCourse.datautilites.ExtentReportManager;
import com.IdentifyCourse.datautilites.Screenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class FormFillingTestCase extends DriverSetup{
	public static WebDriver driver = null;
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	static String path=System.getProperty("user.dir");
	@BeforeClass(groups = { "Regression" })
	public void beforeClass() throws Exception {
		logger=report.createTest("Form filling TestCase");
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
		logger.log(Status.INFO, "Website is Opening ...");
		String driverpath=System.getProperty("user.dir");
	    FileInputStream fis=new FileInputStream(driverpath+"\\Resources\\config.properties");
	    Properties p;
	    p=new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		logger.log(Status.PASS, "Website is Opened...");
	}
	  

	@Test(priority=2,groups= {"Smoke"})
	public void enterprise() 
	{
		logger.log(Status.INFO, "For Enterprise is selected");
		Pom.enterprise().click();
		logger.log(Status.PASS, "For Enterprise page is Redirected");
	}
	@Test(priority=3,groups= {"Smoke"})
	public void products() {
		logger.log(Status.INFO, "cursor is placed on products menu");
		Actions action = new Actions(driver);
		WebElement ProductHover = Pom.products();
		action.moveToElement(ProductHover);
		action.build().perform();
		Pom.forcampus().click();
		logger.log(Status.PASS, "For Campus is selected");
	}
	@Test(priority=4,groups= {"Smoke"})
	public void forCampus() {
		logger.log(Status.INFO, "For Campus page is redirected");
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		WebElement element1=Pom.transform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(Status.PASS, "Ready to Transform your campus form is displayed");
	}

	@Test(priority=5,groups= {"Smoke"})
	public void formfilling()
	{
		logger.log(Status.INFO, "Filling of Form is Started");
		Pom.firstName().sendKeys(ExcelUtils.getCellValue(path, "InputData", 3, 1));
		Pom.lastName().sendKeys(ExcelUtils.getCellValue(path, "InputData", 4, 1));
		Select function = new Select(Pom.jobFunction());
		function.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 5, 1));
		Pom.jobTitle().sendKeys(ExcelUtils.getCellValue(path, "InputData", 6, 1));
		Pom.mail().sendKeys(ExcelUtils.getCellValue(path, "InputData", 7, 1));
		Pom.Phone().sendKeys(ExcelUtils.getCellValue(path, "InputData", 8, 1));
		Pom.Company().sendKeys(ExcelUtils.getCellValue(path, "InputData", 9, 1));
		Select ins_type = new Select(Pom.institutionType());
		ins_type.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 10, 1));
		Select dis=new Select(Pom.primaryDiscipline());
		dis.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 11, 1));
		Select country=new Select(Pom.Country());
		country.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 12, 1));
		Pom.help().sendKeys(ExcelUtils.getCellValue(path, "InputData", 13, 1));
		Pom.submitButton().click();
		System.out.println(Pom.email().getText());
		logger.log(Status.PASS, "Form filled Succesfully");
	}
	@Test(priority=6)
	public void screenshot() throws Exception
	{
		Screenshot.takeScreenShot("Formfilling");
		logger.log(Status.PASS, "Screenshot captured!....");
	}
}
