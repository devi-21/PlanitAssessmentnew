package com.qa.jupiter.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.jupiter.utils.Constants;

public class HomePageTest extends BaseTest{

	@Test
	public void homePageTitle() {
		
		String acttitle = homePage.getHomePageTitle();
		System.out.println("page titel :" + acttitle);
		Assert.assertEquals(acttitle, Constants.HOME_PAGE_TITLE);
		
	}
	
	
}
