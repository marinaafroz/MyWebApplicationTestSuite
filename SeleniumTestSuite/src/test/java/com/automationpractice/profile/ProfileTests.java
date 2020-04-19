package com.automationpractice.profile;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.Test;

import com.automationpractice.core.TestBase;

public class ProfileTests extends TestBase {
	
//TC1
	
	@Test
 public void Update_name_in_User_Profile() {
		
		
		
// Training Keyword	for loop; if statement; try catch block; try catch finally block	
		
//		Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
		
//		Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
		
//		Enter valid email address 'hellow@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("hellow@mailinator.com");
		
//		Enter valid password 'hellow' in password text field
		driver.findElement(By.id("passwd")).sendKeys("hellow");
		
//		Click 'Sign in' button
		driver.findElement(By.id("SubmitLogin")).click();
		
//		Click on name 'Maliha Begum' from top right corner
		//driver.findElement(By.className("account")).click();
		
//		Click on button 'MY PERSONAL INFORMATION'
		driver.findElement(By.xpath("//li[child::a[@title='Information']]")).click();
		
		
//		Verify text displayed 'Please be sure to update your personal information if it has changed.'
		String msg = driver.findElement(By.xpath("//p[contains(text(),'Please be sure')]")).getText();
		Assert.assertEquals(msg, "Please be sure to update your personal information if it has changed.");
		
//		Enter new first name as 'Marina'
		WebElement web = driver.findElement(By.id("firstname"));
		web.clear();
		web.sendKeys("Marina");
		
//		Enter new last name as 'Afroz'
		WebElement web1 = driver.findElement(By.id("lastname"));
		web1.clear();
		web1.sendKeys("Afroz");
		
		
//      Click 'Save' button
		driver.findElement(By.name("submitIdentity")).click();
		
//	Verify error message displayed 'There is 1 error'
		msg = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
		Assert.assertEquals(msg, "There is 1 error");
		
//		Verify error message displayed 'The password you entered is incorrect'
		msg = driver.findElement(By.xpath("//li[text()='The password you entered is incorrect.']")).getText();
		Assert.assertEquals(msg, "The password you entered is incorrect.");
		
//		Enter current password 'hellow' in password text field
		driver.findElement(By.xpath("//input[@id='old_passwd']")).sendKeys("hellow");
		
//		Click 'Save' button
		driver.findElement(By.name("submitIdentity")).click();
		
//		Verify success message displayed 'Your personal information has been successfully updated.'
		msg = driver.findElement(By.xpath("//p[contains(text(),'Your personal')]")).getText();
		Assert.assertEquals(msg, "Your personal information has been successfully updated.");
		
//		Click on name 'Marina Afroz' from top right corner
		driver.findElement(By.xpath("//span[text()='Marina Afroz']")).click();
		
//		Click on button 'MY PERSONAL INFORMATION'
		driver.findElement(By.xpath("//li[child::a[@title='Information']]")).click();
		
//		Verify text displayed 'Please be sure to update your personal information if it has changed.'
		 msg = driver.findElement(By.xpath("//p[contains(text(),'Please be sure')]")).getText();
		Assert.assertEquals(msg, "Please be sure to update your personal information if it has changed.");
		
//		Enter first name back as 'Maliha'
		WebElement web2 = driver.findElement(By.id("firstname"));
		web2.clear();
		web2.sendKeys("Maliha");
		
//		Enter last name back as 'Begum'
		
		WebElement web3 = driver.findElement(By.id("lastname"));
		web3.clear();
		web3.sendKeys("Begum");
		
//		Click 'Save' button
     //driver.findElement(By.name("submitIdentity")).click();
		
//		Enter current password 'hellow' in password text field
		driver.findElement(By.xpath("//input[@id='old_passwd']")).sendKeys("hellow");
		
//		Click 'Save' button
		driver.findElement(By.name("submitIdentity")).click();
		
//		Verify success message displayed 'Your personal information has been successfully updated.'
	
		msg = driver.findElement(By.xpath("//p[contains(text(),'Your personal')]")).getText();
		Assert.assertEquals(msg, "Your personal information has been successfully updated.");
		
}

//TC2

@Test

public void Change_password() {
	

//Training Keyword	for loop; if statement; try catch block; try catch finally block	
	
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
	
	
//	Click on name 'Maliha Begum' from top right corner
	//driver.findElement(By.xpath("//span[text()='Maliha Begum']")).click();
	
	
	
//	Click on button 'MY PERSONAL INFORMATION'
	driver.findElement(By.xpath("//li[child::a[@title='Information']]")).click();
	 
	
//	Enter current password as 'hellow'
	driver.findElement(By.id("old_passwd")).sendKeys("hellow");
	
//	Enter new password as 'xyz1234' in new password text field
	driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("xyz1234");
	
	
//		Click 'Save' button
	driver.findElement(By.name("submitIdentity")).click();
	
	
//		Verify error message displayed 'There is 1 error'
	String msg = driver.findElement(By.xpath("//p[text()='There is 1 error']")).getText();
	Assert.assertEquals(msg, "There is 1 error");
	
//		Verify error message displayed 'The password and confirmation do not match.'
	msg = driver.findElement(By.xpath("//li[text()='The password and confirmation do not match.']")).getText();
	      Assert.assertEquals(msg, "The password and confirmation do not match.");
	
// Enter current password as 'hellow'
	      driver.findElement(By.id("old_passwd")).sendKeys("hellow");
	
//	Enter new password as 'xyz1234' in new password text field
	      driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("xyz1234");
	
//	Enter same password 'xyz1234' in confirmation text field
	driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("xyz1234");
	
//	Click 'Save' button
	driver.findElement(By.name("submitIdentity")).click();
	
	
//	Verify success message displayed 'Your personal information has been successfully updated.'
	msg = driver.findElement(By.xpath("//p[contains(text(),'Your personal')]")).getText();
	Assert.assertEquals(msg, "Your personal information has been successfully updated.");

	
//	Click on name 'Maliha Begum' from top right corner
	driver.findElement(By.xpath("//span[text()='Maliha Begum']")).click();
	
//	Click on button 'MY PERSONAL INFORMATION'
	driver.findElement(By.xpath("//li[child::a[@title='Information']]")).click();
	
//	Enter current password as 'xyz1234'
	driver.findElement(By.id("old_passwd")).sendKeys("xyz1234");
	
//	Enter new password as 'hellow' in new password text field
	 driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("hellow");
		
	
//	Enter same password 'hellow' in confirmation text field
	 driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("hellow");
	 
//	Click 'Save' button
	 driver.findElement(By.name("submitIdentity")).click();
		
	
//		Verify success message displayed 'Your personal information has been successfully updated.'	
	 msg = driver.findElement(By.xpath("//p[contains(text(),'Your personal')]")).getText();
		Assert.assertEquals(msg, "Your personal information has been successfully updated.");

	
	
	
   }

//TC3
@Test

public void Create_and_delete_Wish_List() {
	
	
//	Training Keyword	switch to alert; Date; Alert;	
	
//	Go to http://www.automationpractice.com
	driver.get("http://www.automationpractice.com");
	
	
//	Click Sign in button from top right corner of the page
	driver.findElement(By.xpath("//a[@class='login']")).click();
	
//	Enter valid email address 'hellow@mailinator.com' in email address text field of right side
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hellow@mailinator.com");
	
//	Enter valid password 'hellow' in password text field
	driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("hellow");
	
//	Click 'Sign in' button
	driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click(); 
	
//	Click MY WISH LISTS button
	driver.findElement(By.xpath("//li[contains(@class,'lnk_wishlist') and child::a[@title='My wishlists']]")).click();
	
//	Enter 'My Winter Shopping' in name test field
	driver.findElement(By.xpath("//input[@id='name' and @type='text']")).sendKeys("My Winter Shopping");
	
//	Click Save button
	driver.findElement(By.xpath("//button[@id='submitWishlist']")).click();
	
	
//Step 9		Verify new wish list created with name = 'My Winter Shopping', Qty=0, Viewed=0, Created=today's date, Direct Link = View
	
	String name = driver.findElement(By.xpath("//tr[1]/td[1]")).getText();
	String qty = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
	String viewed = driver.findElement(By.xpath("//tr[1]/td[3]")).getText();
	//String created = driver.findElement(By.xpath("//tr[1]/td[4]")).getText();
	String directlink = driver.findElement(By.xpath("//tr[1]/td[5]")).getText();
	
	Assert.assertEquals(name, "My Winter Shopping");
	Assert.assertEquals(qty, "0");
	Assert.assertEquals(viewed, "0");
	//Assert.assertEquals(created, "");
	Assert.assertEquals(directlink, "View");
	
	WebDriverWait driverWait = new WebDriverWait(driver, 10);
	boolean isPresent = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]/td[1]")))!=null;
	System.out.println(isPresent    +     "Yes element is visisble");


	
//		Delete the created wish list item
	  driver.findElement(By.xpath("//i[contains(@class,'icon-remove')]")).click();
	  
	  
//	Click OK from the alert popup
	  
	  Alert alert =driver.switchTo().alert();
	  alert.accept();
	
//Step 12	Verify wishlist item is removed
	  
	  driverWait = new WebDriverWait(driver, 10);
	  isPresent = driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tr[1]/td[1]")));
	  System.out.println(isPresent    +       "element is now NOT visisble");
	  Assert.assertEquals(isPresent, true);
	  
}

}
	
	
	
	
	
	
	
	
	

	
	
	
	























