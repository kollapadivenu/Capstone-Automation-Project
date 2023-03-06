package com.wipro.testcases;

import org.testng.annotations.Test;

import com.wipro.base.TestBase;
import com.wipro.pages.RegistrationPage;
import com.wipro.utilities.ReadFromExcelRegistration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Registration extends TestBase{
	
	@BeforeClass
	  public void beforeClass() {
		
		lanuchBrowser();
		navigateToURL();
		
	  }
  @Test(dataProvider = "dp")
  public void register(String firstname,String lastname,String email,String password,String confirmpassword) {
	  RegistrationPage rp = new RegistrationPage();
	  boolean actResult = rp.registerClick();
	  Assert.assertTrue(actResult);
	  
	  boolean actResult1 = rp.registrationDetails(firstname, lastname, email, password, confirmpassword);
	  Assert.assertTrue(actResult1);
  }

  @DataProvider
  public Object[][] dp() {
	  String[][] data = new String[1][5];
	  data = ReadFromExcelRegistration.getData();
	  return data;
    };

 

  @AfterClass
  public void afterClass() {
	  wait(1000);
	  driver.close();
  }

}
