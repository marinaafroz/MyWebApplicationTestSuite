package com.automationpractice.registration;


//import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import com.automationpractice.core.TestBase;


public class RegistrationTests extends TestBase{
	
	//@Test
	//public void randomTextGenerator() {
		
		//int randomNumber = ThreadLocalRandom.current().nextInt(100, 999);
	//}
	

	
	
	//TC1
	
	@Test
	public void Register_a_new_account(){
		
		String emailAddress= "m@mailinator.com";
		String fName= "John";
		String lName= "Smith";
		
//	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//	Click Sign in button from top right corner of the page
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		
//	Enter email address 'hellow@mailinator.com' in email address text field of left side
		driver.findElement(By.xpath("//input[@id='email_create' and @type='text']")).sendKeys("hellow@mailinator.com");
		
//	Click create an account button
		driver.findElement(By.xpath("//button[@id='SubmitCreate' and @type='submit']")).click();
		
//	Verify error message displayed 'An account using this email address has already been registered. Please enter a valid password or request a new one.'
		
		String msg = driver.findElement(By.xpath("//li[contains(text(),'An account using this')]")).getText();
		Assert.assertEquals(msg, "An account using this email address has already been registered. Please enter a valid password or request a new one.");
		
//	Enter a valid email address in email address text field. (You can use xxxxxxx@mailinator.com)
		WebElement e = driver.findElement(By.xpath("//input[@id='email_create' and @type='text']"));
		          e.clear();
		           e.sendKeys("m@mailinator.com");
//	Click create an account button
		driver.findElement(By.xpath("//button[@id='SubmitCreate' and @type='submit']")).click();	
		
//	Click 'Register' button
		driver.findElement(By.xpath("//button[@id='submitAccount' and @type='submit']")).click();
		
// Verify "There are 8 errors"	message displayed	
		
		 msg = driver.findElement(By.xpath("//p[text()='There are 8 errors']")).getText();
		 Assert.assertEquals(msg, "There are 8 errors");
		
//	Verify error message displayed 'You must register at least one phone number.'
		 
		 msg = driver.findElement(By.xpath("//li[text()='You must register at least one phone number.']")).getText();
		 Assert.assertEquals(msg, "You must register at least one phone number.");
		 
//	Verify error message displayed 'lastname is required.'
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[1]")).getText();
		 Assert.assertEquals(msg, "lastname is required.");
		 
//	Verify error message displayed 'firstname is required.'
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[2]")).getText();
		 Assert.assertEquals(msg, "firstname is required.");
		 
//	Verify error message displayed 'passwd is required.'
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[3]")).getText();
		 Assert.assertEquals(msg, "passwd is required.");
		 
//	Verify error message displayed 'address1 is required.'
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[4]")).getText();
		 Assert.assertEquals(msg, "address1 is required.");
		 
//	Verify error message displayed 'city is required.'
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[5]")).getText();
		 Assert.assertEquals(msg, "city is required.");
		 
//	Verify error message displayed 'The Zip/Postal code you've entered is invalid. It must follow this format: 00000'
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[6]")).getText();
		 Assert.assertEquals(msg, "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
		 
//	Verify error message displayed 'This country requires you to choose a State.'
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[7]")).getText();
		 Assert.assertEquals(msg, "This country requires you to choose a State.");
		 
		 
//	Select 'Mr' radio button
		 
		 driver.findElement(By.xpath("//div[@id='uniform-id_gender1']")).click();
		 
//	Enter First name as 'John'
		 driver.findElement(By.xpath("//input[@id='customer_firstname' and @type='text']")).sendKeys("John");
		 
//	Enter Last name as 'Smith'
		 driver.findElement(By.xpath("//input[@id='customer_lastname' and @type='text']")).sendKeys("Smith");
		 
//	Verify Email text box has email address defined as used in step 6
		 msg = driver.findElement(By.id("email")).getAttribute("value");
		 Assert.assertEquals(msg, emailAddress);
		 
//	Enter password as 'MyStrong_Password'
		driver.findElement(By.xpath("//input[@id='passwd' and @type='password']")).sendKeys("MyStrong_Password"); 
		
//	Select day 15 from day dropdown
		 e = driver.findElement(By.id("days"));
		Select day = new Select(e);
		day.selectByValue("15");
		 
//	Select year 1984 from year dropdown
		 e = driver.findElement(By.id("years"));
		Select year = new Select(e);
		year.selectByValue("1984");
		
//	Select month September from month dropdown
		
		WebElement months = driver.findElement(By.id("months"));
		Select month = new Select(months);
		month.selectByIndex(9);
		
//	Verify First name text field below has first name defined as used in step 18
		msg = driver.findElement(By.id("firstname")).getAttribute("value");
		Assert.assertEquals(msg, fName);
		
//	Verify Last name text field below has last name defined as used in step 19
		
		msg = driver.findElement(By.id("lastname")).getAttribute("value");
		Assert.assertEquals(msg, lName);
		
//	Enter Company as 'Time and Training' in Company text field
		driver.findElement(By.xpath("//input[@id='company' and @type='text']")).sendKeys("Time and Training");
		
//	Enter address as '123 abc street' in address text field
		driver.findElement(By.xpath("//input[@id='address1' and @type='text']")).sendKeys("123 abc street");
		
//	Enter city New York in city text field
		driver.findElement(By.xpath("//input[@id='city' and @type='text']")).sendKeys("New York");
		
//	Select state New York from state drop down
		WebElement states = driver.findElement(By.id("id_state"));
		Select state = new Select(states);
		state.selectByVisibleText("New York");
		
		
//	Enter '10001' in Zip/Postal Code text field
		driver.findElement(By.xpath("//input[@id='postcode' and @type='text']")).sendKeys("10001");
		
		
//	Select country United States from country dropdown
		WebElement countries = driver.findElement(By.xpath("//select[@id='id_country' and @name='id_country']"));
		Select country = new Select(countries);
		country.selectByVisibleText("United States");
		
		
//	Enter text 'Registering ac account with all fields' in Additional information text area
		driver.findElement(By.xpath("//textarea[@id='other' and @name='other']")).sendKeys("Registering ac account with all fields");
		
//	Enter '7031234567' in Home Phone text field
		driver.findElement(By.xpath("//input[@id='phone' and @name='phone']")).sendKeys("7031234567");
		
//	Enter Enter '7039876543214' in Mobile phone text field
		driver.findElement(By.xpath("//input[@id='phone_mobile' and @name='phone_mobile']")).sendKeys("7039876543214");
		
//	Replace text 'My Address' to 'Home' in Assign an address alias for future reference text field
		WebElement replace = driver.findElement(By.xpath("//input[@id='alias' and @type='text']"));
		replace.clear();
		replace.sendKeys("Home");
		 
//	Click 'Register' button
		//driver.findElement(By.xpath("//button[@id='submitAccount' and @type='submit']")).click();
		
//	Verify 'MY ACCOUNT' text displayed
		//msg = driver.findElement(By.xpath("//h1[text()='My account' and parent::div[@id='center_column']]")).getText();
		//Assert.assertEquals(msg, "MY ACCOUNT");
		
//	Verify 'Welcome to your account. Here you can manage all of your personal information and orders.' text displayed
		//msg = driver.findElement(By.xpath("//p[contains(text(),'Welcome to your')]")).getText();
		//Assert.assertEquals(msg, "Welcome to your account. Here you can manage all of your personal information and orders.");
		
		
//	Verify 'My personal information' text displayed
		//msg = driver.findElement(By.xpath("//li[child::a[@title='Information']]")).getText();
		//Assert.assertEquals(msg, "MY PERSONAL INFORMATION");
		
//	Click 'Sign out' button from top right corner
		//driver.findElement(By.xpath("//a[@title='Log me out' and contains(text(),'Sign out')]")).click();
		

}

//TC2
	
	@Test
	public void Register_a_new_account_with_missing_required_fields() {
		
//	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");	
		
//	Click Sign in button from top right corner of the page
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		
//	Click on 'Create New Account' button
		driver.findElement(By.xpath("//button[@id='SubmitCreate' and @type='submit']")).click();
		
//	Verify validation message displayed 'Invalid email address.'
		String msg = driver.findElement(By.xpath("//li[text()='Invalid email address.']")).getText();
		Assert.assertEquals(msg, "Invalid email address.");
		
//	Enter an email address 'xyz915@mailinator.com' in order to register into the text field
		driver.findElement(By.xpath("//input[@id='email_create' and @type='text']")).sendKeys("xyz915@mailinator.com");
		
//	Click on 'Create New Account' button
		driver.findElement(By.xpath("//button[@id='SubmitCreate' and @type='submit']")).click();
		
//	Click on Register Button
		driver.findElement(By.xpath("//button[@id='submitAccount' and @type='submit']")).click();
		
//	"Verify following validation messages displays:

//	There are 8 errors
		 msg = driver.findElement(By.xpath("//p[text()='There are 8 errors']")).getText();
		 Assert.assertEquals(msg, "There are 8 errors");
		
//	You must register at least one phone number.
		 msg = driver.findElement(By.xpath("//li[text()='You must register at least one phone number.']")).getText();
		 Assert.assertEquals(msg, "You must register at least one phone number.");
		
//	lastname is required.
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[1]")).getText();
		 Assert.assertEquals(msg, "lastname is required.");
		
//	firstname is required.
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[2]")).getText();
		 Assert.assertEquals(msg, "firstname is required.");
		 
		 
//	passwd is required.
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[3]")).getText();
		 Assert.assertEquals(msg, "passwd is required.");	 
		 
//	address1 is required.
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[4]")).getText();
		 Assert.assertEquals(msg, "address1 is required."); 
		 
//	city is required.
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[5]")).getText();
		 Assert.assertEquals(msg, "city is required."); 
		 
//	The Zip/Postal code you've entered is invalid. It must follow this format: 00000
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[6]")).getText();
		 Assert.assertEquals(msg, "The Zip/Postal code you've entered is invalid. It must follow this format: 00000"); 
		 
//	"This country requires you to choose a State."
		 msg = driver.findElement(By.xpath("(//li[preceding-sibling::li[contains(text(),'You must')]])[7]")).getText();
		 Assert.assertEquals(msg, "This country requires you to choose a State.");
		
	}
	
	//TC3
	
	@Test
	
	public void Register_a_new_account_only_with_required_fields() {
		
// Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//	Click Sign in button from top right corner of the page
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		
//	Enter email address 'mrn123@mailinator.com' in email address text field of left side, where 'XYZ123' can be random letter and random number
		driver.findElement(By.xpath("//input[@id='email_create' and @type='text']")).sendKeys("mrn123@mailinator.com");
		
//	Click create an account button
		driver.findElement(By.xpath("//button[@id='SubmitCreate' and @type='submit']")).click();
		
//  Enter first name
		driver.findElement(By.xpath("//input[@id='customer_firstname' and @type='text']")).sendKeys("John");
		
//	Enter last name
		 driver.findElement(By.xpath("//input[@id='customer_lastname' and @type='text']")).sendKeys("Smith");
		
//	Enter password
		 driver.findElement(By.xpath("//input[@id='passwd' and @type='password']")).sendKeys("MyStrong_Password");  
		
//	Enter address
		 driver.findElement(By.xpath("//input[@id='address1' and @type='text']")).sendKeys("123 abc street"); 
		
//	Enter city
		 driver.findElement(By.xpath("//input[@id='city' and @type='text']")).sendKeys("New York");
		
//	Select state
		 WebElement states = driver.findElement(By.id("id_state"));
			Select state = new Select(states);
			state.selectByVisibleText("New York");
		
//	Enter zipcode
		 driver.findElement(By.xpath("//input[@id='postcode' and @type='text']")).sendKeys("10001");	 
		
//	Enter country
		 driver.findElement(By.xpath("//select[@id='id_country' and @name='id_country']")).sendKeys("United States");
		
//	Enter mobile phone number
		 driver.findElement(By.xpath("//input[@id='phone_mobile' and @name='phone_mobile']")).sendKeys("7039876543214");
		
//	Enter alias as 'My Home Address'
		 WebElement e = driver.findElement(By.xpath("//input[@id='alias' and @type='text']"));
		 e.clear();;
		 e.sendKeys("My Home Address");
		
//	Click on Regitser button
		 driver.findElement(By.xpath("//button[@id='submitAccount' and @type='submit']")).click();
		
//	Verify welcome message displays 'Welcome to your account. Here you can manage all of your personal information and orders.'
		String  msg = driver.findElement(By.xpath("//p[contains(text(),'Welcome to your')]")).getText();
			Assert.assertEquals(msg, "Welcome to your account. Here you can manage all of your personal information and orders.");
		 
//	Verify firstname and lastname displays on top right corner
			 msg = driver.findElement(By.xpath("//span[text()='John Smith']")).getText();
			Assert.assertEquals(msg, "John Smith");


	}

}
