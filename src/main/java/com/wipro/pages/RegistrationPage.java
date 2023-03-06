package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class RegistrationPage extends TestBase{
	By register = By.xpath("//a[@class='ico-register']");
	By firstName = By.xpath("//*[@id=\"FirstName\"]");
	By lastName = By.xpath("//*[@id=\"LastName\"]");
	By email = By.xpath("//*[@id=\"Email\"]");
	By pass = By.xpath("//*[@id=\"Password\"]");
	By cnfPass = By.xpath("//*[@id=\"ConfirmPassword\"]");
	By regBtn = By.xpath("//button[@id='register-button']");
	
	//Function is used to click on register
	public boolean registerClick() {
		driver.findElement(register).click();
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("register failure");
		}
		
		return actResult;
	}
	
	//Function is used to register the user
	public boolean registrationDetails(String firstname,String lastname,String Email,String password,String confirmPassword) {
		driver.findElement(firstName).sendKeys(firstname);	
		wait(1000);
		driver.findElement(lastName).sendKeys(lastname);
		wait(1000);
		driver.findElement(email).sendKeys(Email);
		wait(1000);
		driver.findElement(pass).sendKeys(password);
		wait(1000);
		driver.findElement(cnfPass).sendKeys(confirmPassword);
		wait(1000);
		driver.findElement(regBtn).click();
		
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='result']")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("register failure");
		}
		
		return actResult;
	}
		
}

