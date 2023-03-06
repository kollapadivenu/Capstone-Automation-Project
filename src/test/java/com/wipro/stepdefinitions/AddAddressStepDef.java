package com.wipro.stepdefinitions;

import org.testng.Assert;

import com.wipro.base.TestBase;
import com.wipro.pages.AddressPage;
import com.wipro.pages.LogOut;
import com.wipro.pages.LoginPage;
import com.wipro.pages.MyAccountPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAddressStepDef extends TestBase {
	
	@Before()
	public void setUp() {
		
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   lanuchBrowser();
	   navigateToURL();
	    
	}

	@When("user enter {string} and {string} and click login button")
	public void user_enter_and_and_click_login_button(String string, String string2) {
	    LoginPage lP = new LoginPage();
	    boolean actResult=lP.validateLogin(string,string2);
		Assert.assertTrue(actResult);
	}
	
	@Then("user clicks on My Account then Address")
	public void user_clicks_on_my_account_then_address() {
		MyAccountPage map = new MyAccountPage();
		boolean actResult = map.myAccountClick();
		Assert.assertTrue(actResult);
		
		boolean actResult1 = map.clickAddress();
		Assert.assertTrue(actResult1);
		
	}
	
	@Then("user enter {string} , {string} , {string}  , {string} , {string} , {string} and {string} and click save button")
	public void user_enter_and_and_click_save_button(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
	   AddressPage ap = new AddressPage();
	   boolean actResult = ap.addAddress(string, string2, string3, string4, string5, string6, string7);
	   Assert.assertTrue(actResult);
	}
	
	@Then("user logouts")
	public void user_logouts() {
		LogOut lo = new LogOut();
		boolean actResult = lo.logOut();
		Assert.assertTrue(actResult);
	}
	
	@After()
	public void tearDown() {
		wait(2000);
		driver.close();
	}
	
	
}
