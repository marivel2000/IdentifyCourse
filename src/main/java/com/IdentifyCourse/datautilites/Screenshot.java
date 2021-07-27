package com.IdentifyCourse.datautilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.IdentifyCourse.appmodule.DriverSetup;
import com.IdentifyCourse.exceptions.ScreenshotNotTakenException;

public class Screenshot extends DriverSetup{
	
	static String driverpath=System.getProperty("user.dir");
	static FileInputStream fis;
	static Properties p;
	
	/***********The screenshot of result page*********/
	public static void takeScreenShot(String value1) throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TakesScreenshot takeScreenShot = ((TakesScreenshot) driver);
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("./Screenshots/" + value1 + ".png");
		
		try {
			FileUtils.copyFile(srcFile, DestFile);
			System.out.println("Screenshot taken successfully");
		} catch (Exception e) {
			throw new ScreenshotNotTakenException("Screenshot not taken successfully");
		}
	}

}
