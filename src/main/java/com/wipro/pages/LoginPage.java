package com.wipro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;

public class LoginPage extends TestBase{
	By login = By.linkText("Log in");
	By email = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='Password']");
	By loginButton=By.xpath("//button[text()='Log in' and @type='submit']");
	
	public boolean validateLogin(String userName,String passWord) {
		driver.findElement(login).click();
		wait(1000);
		driver.findElement(email).sendKeys(userName);
		wait(1000);
		driver.findElement(password).sendKeys(passWord);
		wait(1000);
		driver.findElement(loginButton).click();	
		
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("login failure");
		}
		
		return actResult;
	}
}
