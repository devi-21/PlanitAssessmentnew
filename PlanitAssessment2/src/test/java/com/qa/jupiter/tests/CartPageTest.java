package com.qa.jupiter.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.qa.jupiter.pages.CartPage;

public class CartPageTest extends BaseTest{
	@Test
	public void validateAddCard() throws InterruptedException{
	CartPage tst = homePage.navigateToShopping();
	
	CartPage temp = new CartPage(driver);
	tst.addProductsIntoCart();
	HashMap<String, String> prdPrices= temp.getProductPrices();
	temp.navigateToCart();
	Thread.sleep(5000);
	tst.validatePricesinCart(prdPrices);
	double subTotals=tst.validateSubTotal(prdPrices);
	tst.validateTotal(subTotals);

	}
}
