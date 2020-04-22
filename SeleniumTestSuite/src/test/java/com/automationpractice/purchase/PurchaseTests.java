package com.automationpractice.purchase;




import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		       driver.findElement(By.xpath("(//li[child::a[text()='Dresses']])[2] ")).click();
		
		
//	Step 3         Click 'CASUAL DRESSES' thumnail under Subcategories
		       driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/c/9-medium_default.jpg']")).click();
		
		
//	Step 4         Mouse hover to the thumbnail of 'Printed Dress' image
		
		WebElement e = driver.findElement(By.xpath("//img[@title='Printed Dress' and @itemprop='image']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
		
		
//	Step 5           Click 'Add to Cart' button
		driver.findElement(By.xpath("//span[text()='Add to cart' and parent::a[@title='Add to cart']]")).click();
	
		
//	Step 6       Verify message displayed 'Product successfully added to your shopping cart'
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		 e = driver.findElement(By.xpath("//h2[preceding-sibling::span[@title='Close window']]"));
		wait.until(ExpectedConditions.textToBePresentInElement(e, "Product successfully added to your shopping cart"));
		
		         String msg = e.getText();
		           Assert.assertEquals(msg, "Product successfully added to your shopping cart");
		
//	Step 7       Verify message displayed 'There is 1 item in your cart.
		        msg =  driver.findElement(By.xpath("//h2[child::span[contains(text(),'There is 1 item in your cart.')]]")).getText();
		        Assert.assertEquals(msg, "There is 1 item in your cart.");
		        
//	Step 8      Verify message displayed 'Total products $26.00'
		        
		        msg = driver.findElement(By.xpath("//div[child::strong[@class='dark'] and child::span[contains(@class,'ajax_block_products_total')]] ")).getText();
		        Assert.assertEquals(msg, "Total products $26.00");
		        
		
//	Step 9	      Verify message displayed 'Total shipping $2.00'
		        
		        msg = driver.findElement(By.xpath("//div[child::strong[@class='dark'] and child::span[contains(@class,'ajax_cart_shipping_cost')]] ")).getText();
		        Assert.assertEquals(msg, "Total shipping  $2.00");
		        

//	Step 10       Verify message displayed 'Total $28.00'
		        
		        msg = driver.findElement(By.xpath("//div[child::strong[@class='dark'] and child::span[contains(@class,'ajax_block_cart_total')]] ")).getText();
		        Assert.assertEquals(msg, "Total $28.00");
		        
		        
//	Step 11		   Verify message displayed 'Customers who bought this product also bought:'
	
//	Step 12       Click 'Proceed to checkout' button
		        driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
	
//	Step 13       Verify url has 'controller=order'
		        
		         String current_Url = driver.getCurrentUrl();
		         current_Url.contains("controller=order");
		         System.out.println("Current url contains "    +  "'controller=order'");


//	Step 14       Verify page title is: 'Order - My Store'
		        
		        String page_title = driver.getTitle();
		        page_title.compareTo("Order - My Store");
		        System.out.println("Title is " +page_title);
		
//	Step 15	      Click 'Proceed to checkout' button
		        
		        driver.findElement(By.xpath("//a[child::span[text()='Proceed to checkout']]")).click();
	
//	Step 16	   Verify page title is: 'Login - My Store'
		        
		       String current_page_title = driver.getTitle();
		       current_page_title.compareTo("Login - My Store");
		       System.out.println("The page title is now " +current_page_title);
		        
//	Step 17		 Enter valid email address 'abc213@mailinator.com' in email address text field of right side
		       driver.findElement(By.id("email")).sendKeys("abc213@mailinator.com");
	              

//	Step 18		   Enter valid password 'xyz1234' in password text field
		       driver.findElement(By.id("passwd")).sendKeys("xyz1234");
	
//	Step 19       Click 'Sign in' button
                driver.findElement(By.id("SubmitLogin")).click();

//	Step 20      Verify delivery address and billing address are same
                
                
                
                 List<WebElement> l1 = driver.findElements(By.xpath("//li[preceding-sibling::li[child::h3[text()='Your delivery address']]]"));
		         List<WebElement> l2 = driver.findElements(By.xpath("//li[preceding-sibling::li[child::h3[text()='Your billing address']]]"));
		        
		        if(l1.equals(l2)) {
		        	
		        	System.out.println("Delivery address are same as Billing address");
		        }else {
		        	
		        }
		      
		  
//	Step 21	      Click 'Proceed to checkout' button
		        driver.findElement(By.xpath("//button[@type='submit' and @name='processAddress']")).click();
		        

//	Step 22	   Click 'Proceed to checkout' button again
		        driver.findElement(By.xpath("//button[@type='submit' and @name='processCarrier']")).click();
		        
//	Step 23	    Verify popup displayed with message 'You must agree to the terms of service before continuing.'
		        
		      String popUp_message =  driver.findElement(By.xpath("//div[child::p[contains(text(),'You must')]]")).getText();
		        
		        Assert.assertEquals(popUp_message, "You must agree to the terms of service before continuing.");
		        System.out.println("Popup_message is "  +   "You must agree to the terms of service before continuing.");
		        
		        
//	Step 24	   Close the popup
		        
		        driver.findElement(By.xpath("//a[@title='Close']")).click();
		        
//	Step 25  	Check I agree to the term ... checkbox
		        driver.findElement(By.id("cgv")).click();
		        
//	Step 26  	Click 'Proceed to checkout' button
		        driver.findElement(By.xpath("//button[@type='submit' and @name='processCarrier']")).click();
		        
//	Step 27  	Verify text displayed 'Your payment method'
		       msg = driver.findElement(By.xpath("(//span[preceding-sibling::a[@title='Return to Home']])[2]")).getText();
		       Assert.assertEquals(msg, "Your payment method");
		        
//	Step 28 	Verify total price is: $28.00
		       msg = driver.findElement(By.xpath("//tr[contains(@class,'cart_total_price') and descendant::span[text()='Total']  and descendant::span[text()='$28.00']]")).getText();
		       Assert.assertEquals(msg, "TOTAL $28.00");
		       
//	Step 29	   Click 'Pay by bank wire' button
		       driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		       
//	Step 30	   Verify popup displayed with message 'ORDER SUMMARY'
		       msg = driver.findElement(By.xpath("//h1[contains(text(),'Order summary')]")).getText();
		       Assert.assertEquals(msg, "ORDER SUMMARY");
		       
//	Step 31	  Verify popup displayed with message 'BANK-WIRE PAYMENT.'
		       msg = driver.findElement(By.xpath("//h3[contains(text(),'Bank-wire payment.')]")).getText();
		       Assert.assertEquals(msg, "BANK-WIRE PAYMENT.");
		       
//	Step 32	  Verify popup displayed with message 'You have chosen to pay by bank wire. Here is a short summary of your order:'
		       msg = driver.findElement(By.xpath("//p[child::strong[contains(text(),'You have chosen')]]")).getText();
		       Assert.assertEquals(msg, "You have chosen to pay by bank wire. Here is a short summary of your order:");
		       
//	Step 33 	Verify popup displayed with message '- The total amount of your order comes to: $28.00 (tax incl.)'
		       msg = driver.findElement(By.xpath("//p[contains(text(),'The total') and child::span[contains(text(),'$28.00')]]")).getText();
		       Assert.assertEquals(msg, "- The total amount of your order comes to: $28.00 (tax incl.)");
		       
//	Step 34 	Verify popup displayed with message '- We allow the following currency to be sent via bank wire: Dollar'
		       msg = driver.findElement(By.xpath("//p[contains(text(),'We allow') and child::b[text()='Dollar']]")).getText();
		       Assert.assertEquals(msg, "- We allow the following currency to be sent via bank wire: Dollar");
		       
// Step 35 message is not on the webpage.		       
//	Step 35 	Verify popup displayed with message 'You must agree to the terms of service before continuing.'
		       
// Step 36 and 37 is not highlighted separately. How do Write code together?		       
//	Step 36 	Verify popup displayed with message '- Bank wire account information will be displayed on the next page. '
		       
		       //String expected = "- Bank wire account information will be displayed on the next page. "
		       	//	+ "- Please confirm your order by clicking \"I confirm my order.\".";
		      // msg = driver.findElement(By.xpath("//p[contains(text(),'Bank wire account')]")).getText();
		      // Assert.assertEquals(msg, expected);
		       
//	Step 37	  Verify popup displayed with message '- Please confirm your order by clicking "I confirm my order.".'
		       
//	Step 38	  Click 'I confirm my order' button
		        driver.findElement(By.xpath("//button[@type='submit' and child::span[text()='I confirm my order']]")).click();
		        
//	Step 39	  Verify popup displayed with message 'Your order on My Store is complete.'
		        msg = driver.findElement(By.xpath("//p[child::strong[contains(text(),'Your order')]]")).getText();
		        Assert.assertEquals(msg, "Your order on My Store is complete.");
		        
//	Step 40	  Verify popup displayed with message 'Please send us a bank wire with '
		        
		        
//	Step 41	  Verify popup displayed with message '- Amount $28.00 '
//	Step 42 	Verify popup displayed with message '- Name of account owner Pradeep Macharla '
//	Step 43 	Verify popup displayed with message '- Bank name RTP'
//	Step 44	 Verify popup displayed with message 'You must agree to the terms of service before continuing.'
//	Step 45	 Verify popup displayed with message '- Bank wire account information will be displayed on the next page. '
//	Step 46	 Verify popup displayed with message '- Please confirm your order by clicking "I confirm my order.".
		        
//	Step 47	  Click on name 'Misir Ali' from top right corner
		        
		        driver.findElement(By.xpath("//a[child::span[text()='Misir Ali']]")).click();
		        
//	Step 48	  Click on ORDER HISTORY AND DETAILS button
		        driver.findElement(By.xpath("//li[descendant::span[text()='Order history and details']]")).click();
		        
//	Step 49	  Verify there is an order placed today.
		       // String order_reference = driver.findElement(By.xpath("//tr[1]/td[1]")).getText();
		        String date = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
		        String total_price = driver.findElement(By.xpath("//tr[1]/td[3]")).getText();
		        
		        //Assert.assertEquals(order_reference, " MGNJBZUJV");
		        Assert.assertEquals(date, "04/21/2020");
		        Assert.assertEquals(total_price, "$28.00");
		        
		        System.out.println("An order is placed today, "  +    date    + "Total price is "   +   total_price    );
		        
		        
		        
		        
//	Step 50	     Click 'Sign out' button from top right corner	
		        //driver.findElement(By.xpath("//div[child::a[contains(text(),'Sign out')]]")).click();
		
		
}
	
	
//TC2
	
	@Test
	
	public void Add_remove_items_in_cart() {
		
//Training Keyword	Actions; Mouse hover; Explicit wait; try catch
		
//	Step 1	    Go to http://www.automationpractice.com
		
		    driver.get("http://www.automationpractice.com");
		    
//	Step 2	   Mouse hover on  product one
		    
		    Actions action = new Actions(driver);
		   WebElement e = driver.findElement(By.xpath("( //img[@title='Faded Short Sleeve T-shirts' and @itemprop = 'image'])[1]"));
		   action.moveToElement(e).build().perform();
		    
//	Step 3	   Click 'Add to Cart'
		   driver.findElement(By.xpath("(//a[child::span[text()='Add to cart']])[1]")).click();
		   
//	Step 4	    Click 'Continue shopping' button
		   driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
		   
//	Step 5	  Verify Cart has text '1 Product'
		   String msg = driver.findElement(By.xpath("//a[@title='View my shopping cart']")).getText();
		   Assert.assertEquals(msg, "Cart 1 Product");
		   
//	Step 6	   Mouse hover over 'Cart 1 product' button
		    e = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		    Actions action_for_cart1 = new Actions(driver);
		    action_for_cart1.moveToElement(e).build().perform();
		   
//	Step 7	   Verify product listed
		    
		    String img_thumb1 = "http://automationpractice.com/img/p/1/1-cart_default.jpg";
		   String img1_Url1 = driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).getAttribute("src");
		    Assert.assertEquals(img1_Url1, img_thumb1);
		  System.out.println("There is 1 thumbnail for Faded Short Sleeve");  
		    
		    
		  
//	Step 8	   Now mouse hover on another product
		  e = driver.findElement(By.xpath("//img[@title='Blouse' and @itemprop = 'image']"));
		  Actions action_img2 = new Actions(driver);
		  action_img2.moveToElement(e).build().perform();
		   
//	Step 9	   click 'Add to cart' button
		  driver.findElement(By.xpath("(//a[child::span[text()='Add to cart']])[2]")).click();
		   
//	Step 10	    Click on Proceed to checkout
		  driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		  
//	Step 11	    Mouse hover over 'Cart 2 product' button
		  
		  e = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		    Actions action_for_cart2 = new Actions(driver);
		    action_for_cart2.moveToElement(e).build().perform();
		  
		  
//	Step 12	   Verify 2 product listed now
		     img_thumb1 = "http://automationpractice.com/img/p/1/1-cart_default.jpg";
			    img1_Url1 = driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).getAttribute("src");
			    Assert.assertEquals(img1_Url1, img_thumb1);
			  System.out.println("There is 1 thumbnail for Faded Short Sleeve"); 
			  
			String  img_thumb2= "http://automationpractice.com/img/p/7/7-cart_default.jpg";
			String img_Url2 = driver.findElement(By.xpath("//img[@alt='Blouse']")).getAttribute("src");
			Assert.assertEquals(img_Url2, img_thumb2);
			
			System.out.println("There are 2 thumbnail in the cart now");    
		  
//	Step 13	   click 'X'button for first product
			driver.findElement(By.xpath("(//span[contains(@class,'remove_link') and preceding-sibling::div[@class='cart-info']])[1]")).click();
		  
//	Step 14	   Verify 1 product deleted and other remain
			
			  img_thumb2= "http://automationpractice.com/img/p/7/7-cart_default.jpg";
			 img_Url2 = driver.findElement(By.xpath("//img[@alt='Blouse']")).getAttribute("src");
			Assert.assertEquals(img_Url2, img_thumb2);
			
			System.out.println(" There is only 1 thumbnail in the cart now");    
		  
			
			
		
	}
			
	
}
