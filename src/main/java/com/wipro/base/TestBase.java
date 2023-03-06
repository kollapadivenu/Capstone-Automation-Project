package com.wipro.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public static WebDriver driver;
	String fileName = "src\\main\\resources\\config\\config.properties";
	FileInputStream fis;
	Properties prop ;
	
	//function is used to launch browser
	public void lanuchBrowser() {
		try {
			fis = new FileInputStream(fileName);
		}catch(FileNotFoundException fnf) {
			System.out.println("File Path or name is not correct");
		}
		prop = new Properties();
		try {
			prop.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","src\\main\\resources\\driverfiles\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","src\\main\\resources\\driverfiles\\chromedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	//function is used to navigate to URL
	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
	}
	
	//function is used to wait (Thread.sleep())
	public void wait(int msec) {
		try {
			Thread.sleep(msec);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//function is used to capture the screen shot
	public String captureScreenshot(String scrName) {
		
		System.out.println("ScreenShot for "+scrName);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		String timeStamp = sdf.format(date);
		
		TakesScreenshot scrShot=((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String scnShotFileName="src\\test\\resources\\screenshots\\screenshots_"+timeStamp+".png";
		File DestFile = new File(scnShotFileName);
		try {
			FileUtils.copyFile(SrcFile,DestFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return scnShotFileName;
	}
	
}
