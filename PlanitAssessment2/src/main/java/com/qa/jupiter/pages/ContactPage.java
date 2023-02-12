package com.qa.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class ContactPage {
	
	private WebDriver driver;
	public ContactPage(WebDriver driver) {
		
		this.driver = driver;
	}
	private By submitbtn = By.xpath("/html/body/div[2]/div/form/div/a");
	private By headererr = By.xpath("//*[@id='header-message']/div");
	private By headerSubMsg = By.xpath("//div[@id='header-message']/div/strong/following::span[1]");
	private By foreNameErr = By.xpath("//input[@id='forename']/following::span[1]");
	private By EmailErr = By.xpath("//input[@id='email']/following::span[1]");
	private By msgBoxEr = By.xpath("//textarea[@id='message']/following::span[1]");
	private By forenametxt = By.xpath("//input[@id='forename']");
	private By emailtxt = By.xpath("//input[@id='email']");
	private By messagetxt = By.xpath("//textarea[@id='message']");
	private By confHeaderMsg = By.xpath("/html/body/div[2]/div/div");
	private By confHeaderSubMsg = By.xpath("div[@class='alert alert-success']/strong/following::span[1]");
	private String errHeaderMessage="We welcome your feedback - but we won't get it unless you complete the form correctly.";
	private String errSubHeaderMsg="- but we won't get it unless you complete the form correctly.";
	private String errForeNAmeMsg="Forename is required";
	private String errEmail ="Email is required";
	private String errMesgBox="Message is required";
	private String confMsg="Thanks Name, we appreciate your feedback.";
	
	public void clickSubmit(){
		
		driver.findElement(submitbtn).click();
		System.out.println("Submit button is selected");
		}

	/* Validates the error in Header
	*/
	public void validateHeaderMsg(){
	String errorheadermsg = driver.findElement(headererr).getText();
	System.out.println("header error message " +errorheadermsg);
	driver.findElement(headerSubMsg).getText().trim();

	Assert.assertEquals(errorheadermsg, errHeaderMessage);
	//Assert.assertEquals(headerSubMsg, errSubHeaderMsg);
	}
	
	/* Validates the error in Forname field
	*/
	public void validateForNameMsg(){
	String foreNameerrmsg = driver.findElement(foreNameErr).getText().trim();
	Assert.assertEquals(errForeNAmeMsg, foreNameerrmsg);
	}

	/* Validates the error in EMail field
	*/
	public void validateEmaileMsg(){
		String emailerrmsg = driver.findElement(EmailErr).getText().trim();
		Assert.assertEquals(emailerrmsg, errEmail);
	}

	/* Validates the error in Message
	*/
	public void validateMessageBoxError(){
	String msgboxerrmsg = driver.findElement(msgBoxEr).getText().trim();
	Assert.assertEquals(msgboxerrmsg, errMesgBox);
	}

	/*
	Validates the Error MEssage DIsplayed
	*/
	public void validateErrorMEssage(){
	validateHeaderMsg();
	validateForNameMsg();
	validateEmaileMsg();
	validateMessageBoxError();
	}

	public void enterValidDetails(){
	driver.findElement(forenametxt).sendKeys("Name");
	driver.findElement(emailtxt).sendKeys("Good@we.com");
	driver.findElement(messagetxt).sendKeys("Good");
	System.out.println("Details are entered");
	}

//	public void validateErrorMessageDisplayed(String xpathString field){
//	try{
//	driver.findElement(By.xpath(xpath)).isDisplayed();
//	Assert.fail("Error message is still displayed for "+field+" Field");
//	}
//	catch(Exception ex){
//	sysout("Error message is not displayed as expected for "+field+" Field");
//	}
//	}


//	public void validateErrorMessagesRemoved(){
//	validateErrorMessageDisplayed(//input[@id='forename']/following::span[1],"Forename");
//	validateErrorMessageDisplayed(//input[@id='email']/following::span[1],"Email")
//	validateErrorMessageDisplayed(//textarea[@id='message']/following::span[1],"Message Box");
//	}


	/* Validates the error in Header
	*/
	public void validateConfirmationMessage() throws InterruptedException{

	Thread.sleep(3000);
	String confmesg =  driver.findElement(confHeaderMsg).getText().trim();

	//driver.findElement(confHeaderSubMsg).getText().trim();

	Assert.assertEquals(confmesg,confMsg);
//Assert.assertEquals(confHeaderSubMsg, confSubMsg);
	}

}
