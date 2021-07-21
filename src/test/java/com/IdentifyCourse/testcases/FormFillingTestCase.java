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
		logger=report.createTest("Form filling!...");
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
		logger.log(Status.INFO, "openwebsite!....");
		String driverpath=System.getProperty("user.dir");
	    FileInputStream fis=new FileInputStream(driverpath+"\\Resources\\config.properties");
	    Properties p;
	    p=new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		logger.log(Status.PASS, "Done");
	}
	  

	@Test(priority=2,groups= {"Smoke"})
	public void enterprise() 
	{
		logger.log(Status.INFO, "Enterprise!....");
		Pom.enterprise().click();
		Actions action = new Actions(driver);
		WebElement ProductHover = Pom.products();
		action.moveToElement(ProductHover);
		action.build().perform();
		Pom.forcampus().click();
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		WebElement element1=Pom.transform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(Status.PASS, "Done");
	}

	@Test(priority=3,groups= {"Smoke"})
	public void formfilling()
	{
		logger.log(Status.INFO, "formfilling");
		Pom.firstName().sendKeys(ExcelUtils.getCellValue(path, "InputData", 3, 1));
		Pom.lastName().sendKeys(ExcelUtils.getCellValue(path, "InputData", 4, 1));
		
		Select function = new Select(Pom.jobFunction());
		function.selectByVisibleText("Dean");
		Pom.jobTitle().sendKeys(ExcelUtils.getCellValue(path, "InputData", 6, 1));
		Pom.mail().sendKeys(ExcelUtils.getCellValue(path, "InputData", 7, 1));
		Pom.Phone().sendKeys(ExcelUtils.getCellValue(path, "InputData", 8, 1));
		Pom.Company().sendKeys(ExcelUtils.getCellValue(path, "InputData", 9, 1));
		Select ins_type = new Select(Pom.institutionType());
		ins_type.selectByVisibleText("Government");
		Select dis=new Select(Pom.primaryDiscipline());
		dis.selectByVisibleText("Business");
		Select country=new Select(Pom.Country());
		country.selectByVisibleText("India");
		Pom.help().sendKeys(ExcelUtils.getCellValue(path, "InputData", 13, 1));
		Pom.submitButton().click();
		System.out.println(Pom.email().getText());
		logger.log(Status.PASS, "Done");
	}
	@Test(priority=4)
	public void screenshot() throws Exception
	{
		Screenshot.takeScreenShot("Formfilling");
		logger.log(Status.PASS, "Screenshot captured!....");
	}
}
