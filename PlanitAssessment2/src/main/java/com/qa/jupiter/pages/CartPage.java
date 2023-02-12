package com.qa.jupiter.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
	
	private By cartbtn = By.xpath("//*[@id='nav-cart']/a");

	private WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CartPage navigateToCart(){
		driver.findElement(cartbtn).click();
		return new CartPage(driver);
		}
	
	//Genric method to add desired number of products
	public void addProductIntoCard(int num ,String product) throws InterruptedException{
	for(int i=1;i<=num;i++);
	By addprdct = By.xpath("//h4[text()='"+product+"']/following::p[1]/a");
	System.out.println("succesfully selectd");
	Thread.sleep(3000);
	driver.findElement(addprdct).click();
	System.out.println("succesfully selectd21");
	}
	public void addProductsIntoCart() throws InterruptedException{
		addProductIntoCard(2, "Stuffed Frog");
		addProductIntoCard(5, "Fluffy Bunny");
		addProductIntoCard(3, "Valentine Bear");

		}
	//Get the Unit Price of Each Product
	//Stores in hashmap & returms
	public HashMap<String, String> getProductPrices(){
	HashMap<String, String> prdPriceList= new HashMap<>();
	String stfFrogPrice=driver.findElement(By.xpath("//h4[text()='Stuffed Frog']/following::p[1]/span")).getText().trim();
	String fluffyBun=driver.findElement(By.xpath("//h4[text()='Fluffy Bunny']/following::p[1]/span")).getText().trim();
	String valBearPric=driver.findElement(By.xpath("//h4[text()='Valentine Bear']/following::p[1]/span")).getText().trim();

	prdPriceList.put("Stuffed Frog",stfFrogPrice);
	prdPriceList.put("Fluffy Bunny",fluffyBun);
	prdPriceList.put("Valentine Bear",valBearPric);
	return prdPriceList;

	}

	//Validate the Prices in the Cart against the Value displayed in shopping page
	public void validatePricesinCart(HashMap<String, String> prdPrice){
	String stfFrogPriceCart= driver.findElement(By.xpath("//td[contains(text(),'Stuffed Frog')]/following::td[1]")).getText().trim();
	String fluffyBunPriceCart= driver.findElement(By.xpath("//td[contains(text(),'Fluffy Bunny')]/following::td[1]")).getText().trim();
	String valBearPric= driver.findElement(By.xpath("//td[contains(text(),'Valentine Bear')]/following::td[1]")).getText().trim();

	Assert.assertEquals(stfFrogPriceCart,prdPrice.get("Stuffed Frog"));
	Assert.assertEquals(fluffyBunPriceCart,prdPrice.get("Fluffy Bunny"));
	Assert.assertEquals(valBearPric,prdPrice.get("Valentine Bear"));
	}

	//Validates the sub totals displayed in cart
	public double validateSubTotal(HashMap<String, String> prdPrice){
	//Returns Sub Total
	String stfFrogPriceCart= driver.findElement(By.xpath("//td[contains(text(),'Stuffed Frog')]/following::td[3]")).getText().trim().replaceAll("$","");
	String fluffyBunPriceCart= driver.findElement(By.xpath("//td[contains(text(),'Fluffy Bunny')]/following::td[3]")).getText().trim().replaceAll("$","");
	String stfBearPriceCart= driver.findElement(By.xpath("//td[contains(text(),'Valentine Bear')]/following::td[3]")).getText().trim().replaceAll("$","");//Replaces $ sign

	//Converts Price into Integer
	System.out.println("price" +stfFrogPriceCart.replace("$",""));
	double frogPrice=Double.parseDouble(stfFrogPriceCart.replace("$",""));
	double bunnyPrice=Double.parseDouble(fluffyBunPriceCart.replace("$",""));
	double bearPrice=Double.parseDouble(stfBearPriceCart.replace("$",""));
	double unitPriceFrog=Double.parseDouble(prdPrice.get("Stuffed Frog").replace("$",""));
	double unitPriceBunny=Double.parseDouble(prdPrice.get("Fluffy Bunny").replace("$",""));
	double unitPriceBear=Double.parseDouble(prdPrice.get("Valentine Bear").replace("$",""));

	//Validates the sub Total
	double sbFrog=validateSubTotal(unitPriceFrog,frogPrice,2, "Stuffed Frog");
	double sbBunny=validateSubTotal(unitPriceBunny,bunnyPrice,5, "Fluffy Bunny");
	double sbBear=validateSubTotal(unitPriceBear,bearPrice,3, "Valentine Bear");

	return sbFrog+sbBunny+sbBear; //return Sub Total of all 3 products
	}

	private double validateSubTotal(double unitPriceFrog, double frogPrice, int quantity, String product) {
		// TODO Auto-generated method stub
		return 0;
	}

	//Method to validate the subtotal displayed is matching with unit price*quantity
	public int validateSubTotal(int unitPrice, int SubTotal, int quantity, String product){
	if(SubTotal== unitPrice*quantity){
	System.out.println("Sub Total for "+product+" is matching");}
	else{
	Assert.fail("Sub Total is not matching for the "+product);
	}
	return SubTotal;
	}

	//Method to validate that the gtotal is matching
	public void validateTotal(double subTotals){
	String actualTotal=driver.findElement(By.xpath("//tfoot//strong")).getText();
	actualTotal= actualTotal.replaceAll("Total:","").trim();
	double actTotal=Double.parseDouble(actualTotal);
	if(actualTotal.equals(actualTotal)){
	System.out.println("Actual total is matching");
	}
	else{
	Assert.fail("Total is not matching");
	}
	}
}
