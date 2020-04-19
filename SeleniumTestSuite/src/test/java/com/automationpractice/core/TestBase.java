package com.automationpractice.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	
public WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		
		 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	//@AfterMethod
	//public void closewindow() {
		//driver.close();
		
	//}

}
