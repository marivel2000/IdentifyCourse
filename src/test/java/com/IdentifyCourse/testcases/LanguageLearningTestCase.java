package com.IdentifyCourse.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.IdentifyCourse.appmodule.DriverSetup;
import com.IdentifyCourse.appmodule.Pom;
import com.IdentifyCourse.datautilites.ExtentReportManager;
import com.IdentifyCourse.datautilites.Screenshot;
import com.IdentifyCourse.exceptions.ScreenshotNotTakenException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LanguageLearningTestCase extends DriverSetup{
	
	public static WebDriver driver = null;
	public static ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	String path = System.getProperty("user.dir");
	public static WebDriverWait wait;
	
	@BeforeClass(groups = { "Regression" })
	public void beforeClass() throws Exception {
		logger=report.createTest("Language learning Test Case");
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
		String driverpath=System.getProperty("user.dir");
	    FileInputStream fis=new FileInputStream(driverpath+"\\Resources\\config.properties");
	    Properties p;
	    p=new Properties();
		p.load(fis);
		driver.get(p.getProperty("url"));
		logger.log(Status.PASS, "Website is opened....");
	}
	
	/*********Searching for Language learning Courses**********/
	@Test(priority=2,groups= {"Smoke"},dataProvider ="test-data")
	public void secondCourse(String keyvalue) throws IOException 
	{
		
		logger.log(Status.INFO, "Searching for Language learning Courses");
		Pom.searchBar().sendKeys(keyvalue + Keys.ENTER);
		logger.log(Status.PASS, "Language Learning courses displayed succesfully");
	}
	
	/*********Language Option is selected**********/
	@Test(priority = 3,groups= {"Smoke"})
	public void selectLanguage2() {
		logger.log(Status.INFO, "Language Option is selected");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pom.languageBtn));
		Pom.languageBtn().click();
		Pom.showAllButton().click();
		
		String all=Pom.allTextLang().getText();
		Reporter.log(all,true);
		
		Pom.closeBtn().click();
		
	logger.log(Status.PASS,"All languages are displayed correctly");
	
	}

	/*********Level Option is selected**********/
	@Test(priority = 4,groups= {"Smoke"})
	public void selectLevel2() {
		logger.log(Status.INFO, "Level Option is selected");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Pom.levelsBtn));
		Pom.levelsBtn().click();
		List<WebElement> allLevels=Pom.allLevels();
		int size=allLevels.size()-1;
		int c=0;
		for(WebElement E:allLevels) {
			c++;
			if(c<=size)
				Reporter.log(E.getText(), true);
			else 
				break;	
		}

		logger.log(Status.PASS, "All Levels are displayed correctly");
		
		
	}
	
	
	@DataProvider(name = "test-data")
  	public static Object[][] dataProvFunc(){
        	return new Object[][]{
              	{"Language learning"}
        	};
  	}
	
	/*********Taking Screenshot**********/
	@Test(priority=5)
	public void screenshot() throws Exception
	{
		try {
			Screenshot.takeScreenShot("Languagelearning");
			logger.log(Status.PASS, "Screenshot captured!....");
			}
			catch(ScreenshotNotTakenException e)
			{
				e.getMessage();
				
			}
	}
	

}
