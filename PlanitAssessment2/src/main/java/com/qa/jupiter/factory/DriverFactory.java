package com.qa.jupiter.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver ;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		
		System.out.println("browser name is: " +browserName);
		
		if(browserName.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("safari")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new SafariDriver();
		}
		else {
			System.out.println("please pass the right browser" + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://jupiter.cloud.planittesting.com/");
		return driver;
		
		
		
	}
	
	public Properties init_prop() {
		
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fp);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

}
