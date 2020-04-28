package com.automationpractice.product;





import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.core.TestBase;



public class ProductTests extends TestBase{
	
	
	private void myCustomWait(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement found = null;
		int retry=0;
		while(found==null && retry <=5) {
		driver.navigate().refresh();
		found = wait.ignoring(Exception.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		retry++;
		}

		}
	
	
	// TC1

	@Test
	public void Review_on_product() {
//Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
//Click Sign in button from top right corner of the page
		driver.findElement(By.className("login")).click();
//Enter valid email address 'hellow@mailinator.com' in email address text field of right side
		driver.findElement(By.id("email")).sendKeys("hellow@mailinator.com");
//Enter valid password 'hellow' in password text field
		driver.findElement(By.id("passwd")).sendKeys("hellow");
//Click 'Sign in' button
		driver.findElement(By.id("SubmitLogin")).click();
//Go to http://automationpractice.com/index.php?id_product=7&controller=product
		driver.get("http://automationpractice.com/index.php?id_product=7&controller=product");
//Click on Write a review
		driver.findElement(By.xpath("//a[@class='open-comment-form'and contains(text(),'Write a review')]")).click();
//Click Send button without typing anything
		driver.findElement(By.xpath("//span[text()='Send' and parent::button[@id='submitNewMessage']]")).click();
//Verify 'Title is incorrect' text displayed
		String msg = driver.findElement(By.xpath("//li[text()='Title is incorrect']")).getText();
		Assert.assertEquals(msg, "Title is incorrect");
//Verify 'Comment is incorrect' text displayed
		WebDriverWait webdriverWait = new WebDriverWait(driver, 100);
		WebElement element = driver.findElement(By.xpath("//li[text()='Comment is incorrect']"));
		webdriverWait.until(ExpectedConditions.textToBePresentInElement(element, "Comment is incorrect"));
		msg = element.getText();
		Assert.assertEquals(msg, "Comment is incorrect");
//Enter 'Awesome dress' in title
		driver.findElement(By.xpath("//input[@id='comment_title' and @name='title']")).sendKeys("Awesome dress");
//Enter 'Best purchase ever!!!' in Comment
		driver.findElement(By.xpath("//textarea[@id='content' and @name='content']")).sendKeys("Best purchase ever!!!");
//Click Send button
		driver.findElement(By.xpath("//span[text()='Send' and parent::button[@id='submitNewMessage']]")).click();
//Verify 'Your comment has been added and will be available once approved by a moderator' text displayed in popup
		msg = driver.findElement(By.xpath("//p[contains(text(),'Your comment')]")).getText();
		Assert.assertEquals(msg, "Your comment has been added and will be available once approved by a moderator");
//Click OK
		driver.findElement(By.xpath("//span[text()='OK' and parent::button[@type='submit']]")).click();
// Step16  Verify 'write a review' button gets appeared after few seconds. You may need to refresh the page until the button gets appear
		
//		webdriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Write a review')]"))));
		
//		boolean  writeReviewButtonFound = false;
//		int counter=0;
//		while(  (writeReviewButtonFound == false)    && ( counter < 20)    ) {
//			
//			
//			System.out.println("driver could not find write review button");
//			TestBase.turnOffImplicitTimeOut();
//			try {
//				writeReviewButtonFound = driver.findElement(By.xpath("//a[contains(text(),'Write a review')]"))!=null;
//			} catch (Exception e) {
//				driver.navigate().refresh();
//				System.out.println("driver refreshed the page");
//				counter++;
//			}
//			
//			
//			WebElement e = driver.findElement(By.xpath("//abc"));//throws exception
//			List<WebElement> e1 = driver.findElements(By.xpath("//abc"));//
//			int totalel = e1.size();
//		}
//		
		
		
		boolean  writeReviewButtonFound = false;
		int counter=0;
		while(  (writeReviewButtonFound == false)    && ( counter < 20)    ) {
			
			
			System.out.println("driver could not find write review button");
			TestBase.turnOffImplicitTimeOut();
			List<WebElement> elms = driver.findElements(By.xpath("//a[contains(text(),'Write a review')]"));
			writeReviewButtonFound = elms.size()==1;
			driver.findElement(null);
			driver.navigate().refresh();
			System.out.println("driver refreshed the page");
			
			counter++;
		}
		TestBase.turnOnImplicitTimeOut();
		Assert.assertEquals(writeReviewButtonFound, true, "Verify write review button appeared back");
		

		
	}



//TC2

@Test
public void Discounted_product_listing() {
	
//	Go to http://automationpractice.com/index.php
	driver.get("http://automationpractice.com/index.php");
	
//		Verify -5% displayed on product 'Printed Summer Dress'
	
	Actions actions = new Actions(driver);
	WebElement e = driver.findElement(By.xpath("(//img[@title='Printed Summer Dress' and @itemprop='image'])[1]"));
	actions.moveToElement(e).build().perform();
	
	WebDriverWait webdriverWait = new WebDriverWait(driver, 100);
	
    WebElement element = webdriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""
    		+ "(//div[ descendant::span[@class='price-percent-reduction' and text()='-5%']  and @class='left-block' and following-sibling::div[@class='right-block' and descendant::a[contains(text(),'Printed Summer Dress')]]])[1]"
    		+ "")));
	 String msg = element.getText();
	 
	 String[] splits = StringUtils.split(msg);
	 int total_length = splits.length;
	 String temp = splits[total_length-1];
	 //Quick view
	 //$28.98 $30.51 -5%
	  Assert.assertEquals(temp, "-5%");
//	 Assert.assertEquals(msg.contains("-5%"), true);
	  
	 // WebElement element = driver.findElement(By.xpath("(//span[preceding-sibling::span[contains(@class,'old-price product-price') and contains(text(),'$30.51')]])[2]"));
	 // webdriverWait.until(ExpectedConditions.textToBePresentInElement(element, "-5%"));
	// String msg = element.getText();
	 // Assert.assertEquals(msg, "-5%");
	
//	Click on More for this product
	  
	  driver.findElement(By.xpath("(//a[@title='View'])[5]")).click();
	
//	Verify -5% also displays on right side
	  
	 msg =  driver.findElement(By.xpath("//span[@id='reduction_percent_display']")).getText();
	Assert.assertEquals(msg, "-5%");
	
}


//TC3

@Test
public void Colour_choosing_on_product() {
	
	String img_for_blue = "http://automationpractice.com/img/p/3/3-large_default.jpg";
	String img_for_orange = "http://automationpractice.com/img/p/1/1-large_default.jpg";
	
//	Go to http://automationpractice.com/index.php?id_product=1&controller=product#/size-s/color-blue
	
	driver.get("http://automationpractice.com/index.php?id_product=1&controller=product#/size-s/color-blue");
	
//		Click colour button 'blue' from right side
	
	driver.findElement(By.xpath("//a[@id='color_14' and @name='Blue']")).click();
	
//		Verify left side image changes
	String imgUrl = driver.findElement(By.id("bigpic")).getAttribute("src");
	Assert.assertEquals(imgUrl, img_for_blue);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
//		Click colour orange now
	driver.findElement(By.xpath("//a[@id='color_13' and @name='Orange']")).click();
	
//		Verify image on left side is not the same one before
	 imgUrl = driver.findElement(By.id("bigpic")).getAttribute("src");
	 Assert.assertEquals(imgUrl, img_for_orange);

}


//TC4

@Test
public void Product_Compare() {
	
 // Training Keyword	Explicit wait; Select; For loop
	
//	Go to http://www.automationpractice.com
	driver.get("http://www.automationpractice.com");
	
//		Enter 'Dress' in search text box on top
	driver.findElement(By.xpath("//input[@id='search_query_top' and @name='search_query']")).sendKeys("Dress");
	
//		Click on search button icon
	driver.findElement(By.xpath("//button[@type='submit' and @name='submit_search']")).click();
	
//		Click 'Add to Compare' link for first product
	
	Actions actions = new Actions(driver);
	WebElement e = driver.findElement(By.xpath("(//img[@title='Printed Summer Dress' and @itemprop='image'])[1]"));
	actions.moveToElement(e).build().perform();
	 driver.findElement(By.xpath("//div[contains(@class,'compare') and child::a[@data-id-product='5']]")).click();
	
	
	
	
	
//	Verify On top right of panel, Green Compare button has text 'Compare (1)'
	 WebDriverWait driverWait = new WebDriverWait(driver, 100);
	 
	 WebElement element = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
	 driverWait.until(ExpectedConditions.textToBePresentInElement(element, "Compare (1)"));
	String msg = element.getText();
	Assert.assertEquals(msg, "Compare (1)");
	
//	Click 'Add to Compare' link for second product now
	
	Actions actions1 = new Actions(driver);
	WebElement ee = driver.findElement(By.xpath("(//img[@title='Printed Dress' and @itemprop='image'])[1]"));
	actions1.moveToElement(ee).build().perform();
	driver.findElement(By.xpath("//div[contains(@class,'compare') and child::a[@data-id-product='4']]")).click();
	
//	Verify On top right of panel, Green Compare button text changes to  'Compare (2)'
     
	     WebDriverWait wait = new WebDriverWait(driver, 100);
	 
	     WebElement element2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
	     wait.until(ExpectedConditions.textToBePresentInElement(element2, "Compare (2)"));
	    String msg2 = element2.getText();
	    Assert.assertEquals(msg2, "Compare (2)");
	
	
	
//		Click on Green Compare button
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	
//Step9		Verify Properties for first product is: Short Dress
	    
	   
	     // String properties1 = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
	     // Assert.assertEquals(properties1, "Short Dress");
	
//Step10	Verify Properties for second product is: Maxi Dress
	      
	      //String properties2 = driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
	     // Assert.assertEquals(properties2, "Maxi Dress");
	
//Step11		Verify Styles for first product is: Dressy
	      
	     // String styles1 = driver.findElement(By.xpath("//tr[3]/td[2]")).getText();
	     // Assert.assertEquals(styles1, "Dressy");
	
//Step12		Verify Style for second product is: Casual
	      
	      //String styles2 = driver.findElement(By.xpath("//tr[3]/td[3]")).getText();
	    // Assert.assertEquals(styles2, "Casual");
	
//Step13		Verify Compositions for first product is: Viscose
	      
	      //String compositions1 = driver.findElement(By.xpath("//tr[4]/td[2]")).getText();
	     // Assert.assertEquals(compositions1, "Viscose");
	
//Step14		Verify Compositions for second product is: Viscose
	      
	      //String compositions2 = driver.findElement(By.xpath("//tr[4]/td[3]")).getText();
	     // Assert.assertEquals(compositions2, "Viscose");
	
//		Verify Price for first product is: $50.99
	     String price1 = driver.findElement(By.xpath("//div[child::span[text()='$50.99']]")).getText();
	     Assert.assertEquals(price1, "$50.99");
	
//		Verify Price for second product is: $28.98 and 'reduced price' also displayed
	     
	     String price2 = driver.findElement(By.xpath("//span[text()='$28.98']")).getText();
	     Assert.assertEquals(price2, "$28.98");
	     
	     String prod_dis = driver.findElement(By.xpath("//div[contains(@class,'product_discount')]")).getText();
	     Assert.assertEquals(prod_dis, "Reduced price!");
	     
	
	
//		Delete second product from compare list by clicking delete button on right top of the product
	     driver.findElement(By.xpath("(//a[@title='Remove'])[2]")).click();
	
//Step18		Verify second product is not in the list any more
	     
	     driverWait = new WebDriverWait(driver, 10);
		boolean  isPresent = driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//img[@title='Printed Summer Dress' and @itemprop='image'])[1]")));
		  System.out.println(isPresent    +       " element is now NOT visisble  ");
		  Assert.assertEquals(isPresent, true);
		  
	     
	     
}
}