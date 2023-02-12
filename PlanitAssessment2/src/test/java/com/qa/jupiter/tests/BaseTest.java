package com.qa.jupiter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.jupiter.factory.DriverFactory;
import com.qa.jupiter.pages.CartPage;
import com.qa.jupiter.pages.ContactPage;
import com.qa.jupiter.pages.HomePage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	HomePage homePage;
	ContactPage contactpage;
	CartPage cartpage;
	@BeforeMethod
	public void setup() {
		df= new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		
		homePage = new HomePage(driver);
		
	
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
		
	}

}
