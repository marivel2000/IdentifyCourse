package com.IdentifyCourse.grid;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;


/***********Performing Grid operations*********/
public class Grid {
	public static WebDriver driver=null;
	String nodeUrl;

	@BeforeClass(groups = { "Regression" })
	public void beforeClass() throws Exception {
		nodeUrl = "http://192.168.43.216:4444/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL(nodeUrl), capability);
	}

	@AfterClass(groups = { "Regression" })
	public void afterClass() {
		driver.quit();
	}

	@Test(priority = 1, groups = { "Regression" })
	public void openWebSite() {
		String baseUrl = "https://www.coursera.org/";
		driver.get(baseUrl);
	}

	@Test(priority = 2, groups = { "Smoke" })
	public void secondCourse() {
		driver.findElement(By.xpath("//*[contains(@placeholder,'W')]")).sendKeys("Language Learning" + Keys.ENTER);
	}

	@Test(priority = 3, groups = { "Smoke" })
	public void selectLanguage2() {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@class,'Select-pl') and contains(text(),'La')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Show All')]")).click();

		String all = driver.findElement(By.xpath("//div[@class='filters-modal-content horizontal-box']")).getText();
		System.out.println(all);

		driver.findElement(By.xpath("//a[@class='nostyle']")).click();

	}

	@Test(priority = 4, groups = { "Smoke" })
	public void selectLevel2() {
		driver.findElement(By.xpath("//div[@id='react-select-3--value']")).click();
		List<WebElement> allLevels = driver.findElements(By.xpath("//div[@id='react-select-3--list']/div"));
		int size = allLevels.size() - 1;
		int c = 0;
		for (WebElement E : allLevels) {
			c++;
			if (c <= size)
				System.out.println(E.getText());
			else
				break;
		}
	}
}
