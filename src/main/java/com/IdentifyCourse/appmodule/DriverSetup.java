package com.IdentifyCourse.appmodule;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	public static WebDriver driver;
	static WebElement element;
	
	
	/***********Open and setup the driver*********/
	public WebDriver setupDriver() throws IOException {
		String driverpath = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(driverpath + "\\Resources\\config.properties");
		Properties p;
		p = new Properties();
		p.load(fis);
		String browser = (p.getProperty("Browser"));
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();

		} 
		else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.manage().window().maximize();

		}
		return driver;
	}

}
