package com.wipro.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wipro.base.TestBase;
import com.wipro.utilities.WriteIntoFileMenuLinks;

public class ValidateMenuPage extends TestBase{
	By topMenuNotMobiles = By.xpath("/html/body/div[6]/div[2]/ul[1]/li");
	
	By computers = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
	By electronics = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a");
	By apparel = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a");
	By digitals = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a");
	By books = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a");
	By jewelry = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a");
	By giftCards = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a");
	
	//Function is used to write data into text file
	public void writeData() {
		List<WebElement> ls = driver.findElements(topMenuNotMobiles);
		WriteIntoFileMenuLinks wim =new WriteIntoFileMenuLinks();
		for(int i=0;i<ls.size();i++) {
			String count = Integer.toString(i+1);
			WebElement menuLink = ls.get(i);
			wim.writeData(count, menuLink);
		}
	}
	
	//Function is used to validate menu list
	public boolean validateMenuList() {
		
		driver.findElement(computers).click();
		captureScreenshot("Computer");
		wait(1000);
		driver.findElement(electronics).click();
		captureScreenshot("Electronics");
		wait(1000);
		driver.findElement(apparel).click();
		captureScreenshot("Apparel");
		wait(1000);
		driver.findElement(digitals).click();
		captureScreenshot("Digitals");
		wait(1000);
		driver.findElement(books).click();
		captureScreenshot("Books");
		wait(1000);
		driver.findElement(jewelry).click();
		captureScreenshot("Jewelry");
		wait(1000);
		driver.findElement(giftCards).click();
		captureScreenshot("GiftCards");
		
		boolean actResult=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Gift Cards']")));
		}catch(TimeoutException te) {
			actResult=false;
			captureScreenshot("GiftCards failure");
		}
		
		return actResult;
	}

}
