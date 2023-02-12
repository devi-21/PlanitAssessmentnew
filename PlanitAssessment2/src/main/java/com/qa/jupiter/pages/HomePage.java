package com.qa.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
	
	private WebDriver driver;
	private By contactbtn = By.xpath("//*[@id='nav-contact']/a");
	private By shopbtn = By.xpath("//*[@id='nav-shop']/a");
	private By cartbtn = By.xpath("//*[@id='nav-cart']/a");
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public ContactPage navigateContact(){
		driver.findElement(contactbtn).click();
		System.out.println("Contact Page is displayed");
		return new ContactPage(driver);}
	public CartPage navigateToShopping(){
		driver.findElement(shopbtn).click();
		return new CartPage(driver);
		}
	public CartPage navigateToCart(){
		driver.findElement(cartbtn).click();
		return new CartPage(driver);
		}

}
