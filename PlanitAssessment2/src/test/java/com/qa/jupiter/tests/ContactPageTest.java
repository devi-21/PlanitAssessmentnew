package com.qa.jupiter.tests;

import org.testng.annotations.Test;

import com.qa.jupiter.pages.ContactPage;

public class ContactPageTest extends BaseTest {
	
	
	@Test(priority =2)
	public void validateContactPage() throws InterruptedException{
		
//		String str = homePage.navigateContact();
		ContactPage str = homePage.navigateContact();
		Thread.sleep(5000);
		str.clickSubmit();
		Thread.sleep(5000);
		str.validateErrorMEssage();
		str.enterValidDetails();
		//str.validateConfirmationMessage();
		
	
//	home.navigateToContact();
//	contact.clickSubmit();
//	contact.validateErrorMEssage() //Validates the Error Message displayed
//	contact.enterValidDetails();
//	contact.validateErrorMessagesRemoved(); //Validates Messaages are removed
	}
	@Test(priority =1)
	public void validateConfirmationMessage() throws InterruptedException{
		ContactPage str = homePage.navigateContact();
		Thread.sleep(3000);
		str.enterValidDetails();
		str.clickSubmit();
		Thread.sleep(10000);
		str.validateConfirmationMessage();
	}


}
