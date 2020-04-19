package com.automationpractice.other;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.core.TestBase;

public class OtherTests extends TestBase {
	
	//TC1
	@Test
	public void Send_message_using_contact_us_form() {
		
//	Training Keyword	Select; Drop Down;
		
//	Step 1	     Go to http://www.automationpractice.com
		
		    driver.get("http://www.automationpractice.com");
		    
//	Step 2      Click Sign in button from top right corner of the page
		    driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		    
//	Step 3	    Enter valid email address 'hellow@mailinator.com' in email address text field of right side
		    driver.findElement(By.id("email")).sendKeys("hellow@mailinator.com");
		    
//	Step 4	    Enter valid password 'hellow' in password text field
		    driver.findElement(By.id("passwd")).sendKeys("hellow");
		    
//	Step 5	    Click 'Sign in' button
		    driver.findElement(By.id("SubmitLogin")).click();
		    
//	Step 6	    Click Contact us button from top right menu
		    driver.findElement(By.xpath("//div[@id='contact-link']")).click();
		    
//	Step 7	   Select 'Webmaster' from Subject Heading drop down
		   WebElement e = driver.findElement(By.id("id_contact"));
		   Select dropdown = new Select(e);
		   dropdown.selectByVisibleText("Webmaster");
		    
//	Step 8	   Type message 'I have not received my order yet' in Message text area
		   driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I have not received my order yet");
		   
//	Step 9	   Click Send button
		   driver.findElement(By.xpath("//button[@name='submitMessage']")).click();
		   
//	Step 10	    Verify 'Your message has been successfully sent to our team.' message displayed	
		  String msg =  driver.findElement(By.xpath("//p[contains(@class,'alert alert-success') and contains(text(),'Your message')]")).getText();
		Assert.assertEquals(msg, "Your message has been successfully sent to our team.");
		
}
	
	//TC2
@Test
public void Send_message_with_file_attached_using_contact_us_form() throws InterruptedException {
	
//Training Keyword	Select; Drop Down; File Upload
	
//  Step 1	 Go to http://www.automationpractice.com
	         driver.get("http://www.automationpractice.com");
	
//	Step 2	 Click Sign in button from top right corner of the page
	         driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
	
//	Step 3	 Enter valid email address 'hellow@mailinator.com' in email address text field of right side
	         driver.findElement(By.id("email")).sendKeys("hellow@mailinator.com");
	
//	Step 4	 Enter valid password 'hellow' in password text field
	         driver.findElement(By.id("passwd")).sendKeys("hellow");
	
//	Step 5	 Click 'Sign in' button
	         driver.findElement(By.id("SubmitLogin")).click();
	
//	Step 6	 Click Contact us button from top right menu
	         driver.findElement(By.xpath("//div[@id='contact-link']")).click();
	
//	Step 7	 Select 'Webmaster' from Subject Heading drop down
	         WebElement e = driver.findElement(By.id("id_contact"));
			   Select dropdown = new Select(e);
			   dropdown.selectByVisibleText("Webmaster");
	
//	Step 8	 Type message 'I have not received my order yet' in Message text area
			   driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I have not received my order yet");
	
//	Step 9	 Upload a text file in Attach file option
			   
			   driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\marin\\aboutMyself");
			   
			   Thread.sleep(4000);
	
//	Step 10	 Click Send button
			   driver.findElement(By.xpath("//button[@name='submitMessage']")).click();
	
//	Step 11	  Verify 'Your message has been successfully sent to our team.' message displayed
			   String msg =  driver.findElement(By.xpath("//p[contains(@class,'alert alert-success') and contains(text(),'Your message')]")).getText();
				Assert.assertEquals(msg, "Your message has been successfully sent to our team.");
		
}
	
//TC3
@Test

public void Send_message_with_order_reference_using_contact_us_form() {

//Training Keyword	Select; Drop Down;
	
//Step 1	Go to http://www.automationpractice.com
	       driver.get("http://www.automationpractice.com");
	
//Step 2	Click Sign in button from top right corner of the page
	       driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
	
//Step 3	Enter valid email address 'abc213@mailinator.com' in email address text field of right side
	       driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
	
//Step 4	Enter valid password 'xyz1234' in password text field
	       driver.findElement(By.id("passwd")).sendKeys("xyz1234");
	
//Step 5	Click 'Sign in' button
	       driver.findElement(By.id("SubmitLogin")).click();
	
//Step 6	Click Contact us button from top right menu
	       driver.findElement(By.xpath("//div[@id='contact-link']")).click();
	
//Step 7	Select 'Customer 'Service' from Subject Heading drop down
	       WebElement e = driver.findElement(By.id("id_contact"));
		   Select dropdown_heading = new Select(e);
		   dropdown_heading.selectByVisibleText("Customer service");
	
//Step 8	Select 'OVSNICQGG - 11/27/2018' from Order reference drop down
		   
		    e = driver.findElement(By.name("id_order"));
		  Select dropdown_order = new Select(e);
		   dropdown_order.selectByVisibleText("OVSNICQGG - 11/27/2018");
	
//Step 9	Select 'Printed Dress - Color : Orange, Size :S' from Product drop down
		   
		   e = driver.findElement(By.id("84033_order_products"));
		   Select dropdown_product = new Select(e);
		   dropdown_product.selectByVisibleText("Printed Dress - Color : Orange, Size : S");
	
//Step 10	Type message 'I have not received my order yet' in Message text area
		   driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("I have not received my order yet");
	
//Step 11	Click Send button
		   driver.findElement(By.xpath("//button[@name='submitMessage']")).click();
	
//Step 12	Verify 'Your message has been successfully sent to our team.' message displayed
		   String msg =  driver.findElement(By.xpath("//p[contains(@class,'alert alert-success') and contains(text(),'Your message')]")).getText();
			Assert.assertEquals(msg, "Your message has been successfully sent to our team.");
	
	
}
//TC4
@Test
public void Newsletter_subscription() throws InterruptedException {
	
//Training Keyword	keyboard press; ENTER key; Actions; Robot;
	
//Step 1	Go to http://www.automationpractice.com
	        driver.get("http://www.automationpractice.com");
	
//Step 2	Enter an email address to Newsletter textfield at the bottom
	        driver.findElement(By.xpath("//input[@id='newsletter-input' and @name='email' and ancestor::div[@id='newsletter_block_left']]")).sendKeys("opi@mailinator.com");
	 Thread.sleep(5000);
//Step 3	Press Enter by keyboard
	        Actions actions = new Actions (driver);
			actions.sendKeys(Keys.ENTER).build().perform();
	
//Step 4	Verify message 'Newsletter : You have successfully subscribed to this newsletter.' displayed
			String msg = driver.findElement(By.xpath("//p[contains(@class,'alert alert-success') and contains(text(),'Newsletter')]")).getText();
		    Assert.assertEquals(msg, "Newsletter : You have successfully subscribed to this newsletter.");
}

//TC5
@Test
public void Homepage_image_sliding() {
	
//	Training Keyword	Image recognition; sikuli; GUI automation
	
//	Step 1	 Go to http://www.automationpractice.com
	         driver.get("http://www.automationpractice.com");
	
//	Step 2	 verify big slide image has one man and woman in image
	
//	Step 3	 click next slide icon
	
//	Step 4	 verify now image changed and new image has two women
	
//	Step 5	 click next slide icon again
	
//	Step 6	 verify new image has one woman in purple dress
		
}
	

}
