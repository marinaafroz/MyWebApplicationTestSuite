package com.automationpractice.purchase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.core.TestBase;

public class PurchaseTests extends TestBase {
	
	
//TC1
	@Test
	public void PurchaseAT_Shirt(){
		
		
//Training Keyword	Actions; Mouse hover; getTitle; 	
		
//	Step 1      Go to http://www.automationpractice.com
		        driver.get("http://www.automationpractice.com");
		
//	Step 2       Click 'DRESSES' button
		       driver.findElement(By.xpath("(//a[@title='Dresses' and @class='sf-with-ul'  and text()='Dresses'])[1] ")).click();
		
		
//	Step 3         Click 'CASUAL DRESSES' thumnail under Subcategories
		       driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/c/9-medium_default.jpg']")).click();
		
		
//	Step 4         Mouse hover to the thumbnail of 'Printed Dress' image
		
		WebElement e = driver.findElement(By.xpath("//img[@title='Printed Dress' and @itemprop='image']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
		
		
//	Step 5           Click 'Add to Cart' button
		driver.findElement(By.xpath("//span[text()='Add to cart' and parent::a[@title='Add to cart']]")).click();
		
		
//	Step 6       Verify message displayed 'Product successfully added to your shopping cart'
		         String msg =driver.findElement(By.xpath("//h2[preceding-sibling::span[@title='Close window']]")).getText();
		           Assert.assertEquals(msg, "//h2[preceding-sibling::span[@title='Close window']]");
		
//	Step 7       Verify message displayed 'There are 1 items in your cart.
		        msg =  driver.findElement(By.xpath("//span[contains(text(),'There is 1 item in your cart.')]")).getText();
		        Assert.assertEquals(msg, "There are 1 items in your cart.");
		        
//	Step 8      Verify message displayed 'Total products $26.00'
		        driver.findElement(By.xpath("//strong[contains(text(),'Total product')] "));
		        driver.findElement(By.xpath("//span[text()='$26.00' and preceding-sibling::strong[contains(text(),'Total product')]]"));
		
//	Step 9	      Verify message displayed 'Total shipping $2.00'
		        driver.findElement(By.xpath("//strong[contains(text(),'Total shipping')] "));
		        driver.findElement(By.xpath("//span[text()='$2.00' and preceding-sibling::strong[contains(text(),'Total shipping')]]"));

//	Step 10       Verify message displayed 'Total $28.00'
		        driver.findElement(By.xpath("//strong[contains(text(),'Total') and following-sibling::span[text()='$28.00']]")); 
		        driver.findElement(By.xpath("//span[text()='$28.00' and preceding-sibling::strong[contains(text(),'Total')]]"));
		
//	Step 11		   Verify message displayed 'Customers who bought this product also bought:'
	
//	Step 12       Click 'Proceed to checkout' button
		        driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
	
//	Step 13       Verify url has 'controller=order'


//	Step 14       Verify page title is: 'Order - My Store'
		
//	Step 15	      Click 'Proceed to checkout' button
	
//	Step 16	   Verify page title is: 'Login - My Store'
	
//	Step 17		 Enter valid email address 'abc213@mailinator.com' in email address text field of right side
	

//	Step 18		   Enter valid password 'abc1234' in password text field
	
//	Step 19       Click 'Sign in' button


//	Step 20      Verify delivery address and billing address are same
		
//	Step 21	      Click 'Proceed to checkout' button

//	Step 22	   Click 'Proceed to checkout' button again
//	Step 23	    Verify popup displayed with message 'You must agree to the terms of service before continuing.'
//	Step 24	   Close the popup
//	Step 25  	Check I agree to the term ... checkbox
//	Step 26  	Click 'Proceed to checkout' button
//	Step 27  	Verify text displayed 'Your payment method'
//	Step 28 	Verify total price is: $28.00
//	Step 29	   Click 'Pay by bank wire' button
//	Step 30	   Verify popup displayed with message 'ORDER SUMMARY'		
//	Step 31	  Verify popup displayed with message 'BANK-WIRE PAYMENT.'
//	Step 32	  Verify popup displayed with message 'You have chosen to pay by bank wire. Here is a short summary of your order:'
//	Step 33 	Verify popup displayed with message '- The total amount of your order comes to: $28.00 (tax incl.)'
//	Step 34 	Verify popup displayed with message '- We allow the following currency to be sent via bank wire: Dollar'
//	Step 35 	Verify popup displayed with message 'You must agree to the terms of service before continuing.'
//	Step 36 	Verify popup displayed with message '- Bank wire account information will be displayed on the next page. '
//	Step 37	  Verify popup displayed with message '- Please confirm your order by clicking "I confirm my order.".'
//	Step 38	  Click 'I confirm my order' button
//	Step 39	  Verify popup displayed with message 'Your order on My Store is complete.'
//	Step 40	  Verify popup displayed with message 'Please send us a bank wire with '
//	Step 41	  Verify popup displayed with message '- Amount $28.00 '
//	Step 42 	Verify popup displayed with message '- Name of account owner Pradeep Macharla '
//	Step 43 	Verify popup displayed with message '- Bank name RTP'
//	Step 44	 Verify popup displayed with message 'You must agree to the terms of service before continuing.'
//	Step 45	 Verify popup displayed with message '- Bank wire account information will be displayed on the next page. '
//	Step 46	 Verify popup displayed with message '- Please confirm your order by clicking "I confirm my order.".'
//	Step 47	  Click on name 'Misir Ali' from top right corner
//	Step 48	  Click on ORDER HISTORY AND DETAILS button
//	Step 49	  Verify there is an order placed today.
//	Step 50	     Click 'Sign out' button from top right corner	
		
		
}
	
	
//TC2
	
	@Test
	
	public void Add_remove_items_in_cart() {
		
//Training Keyword	Actions; Mouse hover; Explicit wait; try catch
		
//	Step 1	    Go to http://www.automationpractice.com
//	Step 2	   Mouse hover on  product one
//	Step 3	   Click 'Add to Cart'
//	Step 4	    Click 'Continue shopping' button
//	Step 5	  Verify Cart has text '1 Product'
//	Step 6	   Mouse hover over 'Cart 1 product' button
//	Step 7	   Verify product listed
//	Step 8	   Now mouse hover on another product
//	Step 9	   click 'Add to cart' button
//	Step 10	    Click on Porceed to checkout
//	Step 11	    Mouse hover over 'Cart 2 product' button
//	Step 12	   Verify 2 product listed now
//	Step 13	   click 'X'button for first product
//	Step 14	   Verify 1 product deleted and other remain
		
	}
			
	
}
