package com.IdentifyCourse.testcasescenario;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.*;

import com.IdentifyCourse.appmodule.DriverSetup;
import com.IdentifyCourse.appmodule.Pom;
import com.IdentifyCourse.datautilites.ExcelUtils;

import junit.framework.Assert;


public class TestScenerio extends DriverSetup{

	static WebDriver driver;
	String path=System.getProperty("user.dir");

	@BeforeClass(groups = { "Regression" })
	public void beforeClass() throws Exception {
		DriverSetup dri = new DriverSetup();
		driver = dri.setupDriver();
	}

	@AfterClass(groups = { "Regression" })
	public void afterClass() {
		driver.quit();
	}

	@Test(priority = 1, groups = { "Regression" })
	public void openWebSite() {
		String baseUrl = "https://www.coursera.org/";
		driver.get(baseUrl);
		Assert.assertEquals(driver.getTitle(),
				"Coursera | Online Courses & Credentials From Top Educators. Join for Free");
		System.out.println("Succesfully opened BaseUrl");
	}

	@Test(priority = 2, groups = { "Regression" })
	public void clickSearchTextbox() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Pom.searchBar().click();
		System.out.println("Successfully located the search textbox");
	}

	@Test(priority = 3, groups = { "Regression" })
	public void sendCourseName() {
		Pom.getCoursename().sendKeys(ExcelUtils.getCellValue(path, "InputData", 1, 1));
		Pom.getCoursenameclick().click();
		System.out.println("Successfully entered the course name");
	}

	@Test(priority = 4, groups = { "Regression" })
	public void selectLang() {
		Pom.getLang().click();
		Pom.getLangclick().click();
		System.out.println("Successfully selected the language");
	}

	@Test(priority = 5, groups = { "Regression" })
	public void selectLevel() {
		Pom.getLevel().click();
		Pom.getLevelclick().click();
		System.out.println("Successfully selected the level");
	}

	@Test(priority = 6, groups = { "Regression" })
	public void firstCourse() throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

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
		}
	}

	@Test(priority = 7, groups = {"Regression"} )
	public void navigateToUrl() {
		String baseUrl = "https://www.coursera.org/";
		driver.navigate().to(baseUrl);
		System.out.println("Succesfully navigated to the URL");
	}

	@Test(priority = 8, groups = { "Regression" })
	public void openLangWebSite() {
		Pom.searchBar().click();
		Pom.getCoursename().sendKeys(ExcelUtils.getCellValue(path, "InputData", 2, 1));
		Pom.getCoursenameclick().click();
		System.out.println("Successfully searched for the course");
	}

	@Test(priority = 9, groups = { "Regression" })
	public void displayLanguage() {

		Pom.languageBtn().click();
		Pom.showAllButton().click();
		String all = Pom.allTextLang().getText();
		System.out.println(all);
		Pom.closeBtn().click();
		System.out.println("Successfully displayed all the language");
	}

	@Test(priority = 10, groups = { "Regression" })
	public void diaplayLevel() {
		Pom.levelsBtn().click();
		List<WebElement> allLevels = Pom.allLevels();
		int size = allLevels.size() - 1;
		int c = 0;
		for (WebElement E : allLevels) {
			c++;
			if (c <= size)
				System.out.println(E.getText());
			else
				break;
		}
		System.out.println("Successfully displayed all the level");
	}
	
	@Test(priority=11,groups = { "Regression" })
	public void openEnterprise() 
	{
		String baseUrl = "https://www.coursera.org/in";
		driver.get(baseUrl);
		Pom.enterprise().click();
		System.out.println("Succesfully clicked enterprise");
	}  

	@Test(priority=12,groups = { "Regression" })
	public void openForCampus() 
	{
		Actions action = new Actions(driver);
		WebElement ProductHover = Pom.products();
		action.moveToElement(ProductHover);
		action.build().perform();
		Pom.forcampus().click();
		System.out.println("Succesfully clicked for campus");
	} 
	@Test(priority=13,groups = { "Regression" })
	public void getStarted() 
	{
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		WebElement element1 = Pom.transform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element1);
		System.out.println("Succesfully transformed");
	} 
	
	@Test(priority=14,groups = { "Regression" })
	public void FirstName() 
	{
		Pom.firstName().sendKeys(ExcelUtils.getCellValue(path, "InputData", 3, 1));
		System.out.println("first name entered");
	} 
	
	@Test(priority=15,groups = { "Regression" })
	public void lastName() 
	{
		Pom.lastName().sendKeys(ExcelUtils.getCellValue(path, "InputData", 4, 1));
		System.out.println("last name entered");
	}
	
	@Test(priority=16,groups = { "Regression" })
	public void jobFunction() 
	{
		Select function = new Select(Pom.jobFunction());
		function.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 5, 1));
		System.out.println("job function selected");
	}
	
	@Test(priority=17,groups = { "Regression" })
	public void jobTitle() 
	{
		Pom.jobTitle().sendKeys(ExcelUtils.getCellValue(path, "InputData", 6, 1));
		System.out.println("job title entered");
	}
	
	@Test(priority=18,groups = { "Regression" })
	public void mail() 
	{
		Pom.mail().sendKeys(ExcelUtils.getCellValue(path, "InputData", 7, 1));
		System.out.println("mail entered");
	}
	
	@Test(priority=19,groups = { "Regression" })
	public void Phone() 
	{
		Pom.Phone().sendKeys(ExcelUtils.getCellValue(path, "InputData", 8, 1));
		System.out.println("Phone number entered");
	}
	
	@Test(priority=20,groups = { "Regression" })
	public void Company() 
	{
		Pom.Company().sendKeys(ExcelUtils.getCellValue(path, "InputData", 9, 1));
		System.out.println("Company name entered");
	}
	
	@Test(priority=21,groups = { "Regression" })
	public void institutionType() 
	{
		Select ins_type = new Select(Pom.institutionType());
		ins_type.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 10, 1));
		System.out.println("institutionType selected");
	}
	
	@Test(priority=22,groups = { "Regression" })
	public void primaryDiscipline() 
	{
		Select dis=new Select(Pom.primaryDiscipline());
		dis.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 11, 1));
		System.out.println("primary Discipline selected");
	}
	
	@Test(priority=23,groups = { "Regression" })
	public void Country() 
	{
		Select country=new Select(Pom.Country());
		country.selectByVisibleText(ExcelUtils.getCellValue(path, "InputData", 12, 1));
		System.out.println("Country selected");
	}
	
	@Test(priority=24,groups = { "Regression" })
	public void help() 
	{
		Pom.help().sendKeys(ExcelUtils.getCellValue(path, "InputData", 13, 1));
		System.out.println("helped");
	}
	
	@Test(priority=25,groups = { "Regression" })
	public void submitButton() 
	{
		Pom.Company().click();
		System.out.println("All testcases succeeded");
	}
	
}
