package com.automationpractice.login;



import org.openqa.selenium.By;


import org.testng.Assert;


import org.testng.annotations.Test;

import com.automationpractice.core.TestBase;

//
public class LoginTests extends TestBase {
	
	
	
	
	 
	@Test
	public void Login_with_invalid_userid() {
		
		
		
		// Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
		
		// Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
		
		
		// Enter invalid email address 'myunknowxaad@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("myunknowxaad@mailinator.com");
		
		//Click Sign in button
		driver.findElement(By.id("SubmitLogin")).click();
		
		//Verify error message displayed 'There is 1 error'
		
	      String msg =driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
	       Assert.assertEquals(msg, "There is 1 error");
	       
		//Verify error message displayed 'Password is required.'
	       
	       msg = driver.findElement(By.xpath("//li[text()='Password is required.']")).getText();
	       Assert.assertEquals(msg, "Password is required.");
	       
	       
	}
	
	//TC2
	
	@Test
	
	public void Login_with_valid_userid_but_invalid_password() {
		
		
		
//		Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");

//		Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
		
		
//		Enter valid email address 'hellow@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("hellow@mailinator.com");
		
//		Enter invalid password 'myinvalidpwd' in password text field
		driver.findElement(By.id("passwd")).sendKeys("myinvalidpwd");
		
//		Click 'Sign in' button
		driver.findElement(By.id("SubmitLogin")).click();
		
		
//		Verify error message displayed 'There is 1 error'
		String msg = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		Assert.assertEquals(msg, "There is 1 error");
		
		//Verify error message displayed 'Authentication failed.'
		msg = driver.findElement(By.xpath("//li[text()='Authentication failed.']")).getText();
		Assert.assertEquals(msg, "Authentication failed.");
		
	}
	
	//TC3
	
	@Test
	
	public void Login_with_valid_userid_and_password() {
		
		
		

//	Go to http://www.automationpractice.com
	driver.get("http://www.automationpractice.com");
	
//	Click Sign in button from top right corner of the page
	driver.findElement(By.className("login")).click();
	
//	Enter valid email address 'hellow@mailinator.com' in email address text field of right side
	driver.findElement(By.id("email")).sendKeys("hellow@mailinator.com");
	
//	Enter valid password 'hellow' in password text field
	driver.findElement(By.id("passwd")).sendKeys("hellow");
	
	
//	Click 'Sign in' button
	driver.findElement(By.id("SubmitLogin")).click();
	
//	Verify 'MY ACCOUNT' text displayed
	String msg = driver.findElement(By.xpath("//h1[text()='My account' and parent::div[@id='center_column']]")).getText();
	Assert.assertEquals(msg, "MY ACCOUNT");
	
	
	
//	Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
	msg = driver.findElement(By.xpath("//p[contains(text(),'Welcome to your')]")).getText();
	Assert.assertEquals(msg, "Welcome to your account. Here you can manage all of your personal information and orders.");
	
//	Verify 'My personal information' text displayed
	msg = driver.findElement(By.xpath("//li[child::a[@title='Information']]")).getText();
	Assert.assertEquals(msg, "MY PERSONAL INFORMATION");
	
	
	
//	Click 'Sign out' button from top right corner
	driver.findElement(By.xpath("//a[@title='Log me out']")).click();
	
	
	}
	
}
