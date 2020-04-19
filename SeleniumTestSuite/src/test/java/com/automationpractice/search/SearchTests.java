package com.automationpractice.search;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.core.TestBase;



public class SearchTests extends TestBase{
	
	
	//TC1
	
	@Test
	public void Price_Range_Search() {
		
		
//Training Keyword	keyboard press; Keys; Key Press; Actions; Robot; Drag n Drop; slider; 
		          //custom xpath; xpath traversing; for loop; while loop; do while loop; String to Double convert				
		
//	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
 //Click on DRESSES button
	  driver.findElement(By.xpath("(//a[@title='Dresses' and text()='Dresses'])[2]")).click();
		
//	slide the price range between  (around) $20.00 to (around) $40.00
		
		
//Verify product listed on right side with price ranges are between $20 to $40 only
		
		
	}
	
	
//TC2
	
	@Test
	public void Product_quick_view() throws InterruptedException {
		
 //Training Keyword	iframe; frame, driver.switchTo();popup; Actions; mouse hover; explicit wait	
		
//	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//	Click on the 'Quick View' icon of the product that has text has 'Printed Dress' and price is $26.00
		Actions action = new Actions(driver);
	WebElement e = driver.findElement(By.xpath("(//img[@title='Printed Dress'])[1]"));	
	action.moveToElement(e).build().perform();
	
	JavascriptExecutor javascriptExecutor =(JavascriptExecutor) driver;
	javascriptExecutor.executeScript("document.getElementsByClassName('quick-view')[2].click();");
	
	
//	Verify popup opened
	driver.switchTo().frame("fancybox-frame1587153032405");	
	
//	Verify text displayed 'Printed Dress' on top
	
	String msg = driver.findElement(By.xpath("//h1[@itemprop='name' and text()='Printed Dress']")).getText();
	Assert.assertEquals(msg, "Printed Dress");
		
//	Verify price is $26.00
	msg = driver.findElement(By.xpath("//p[child::span[@id='our_price_display' and text()='$26.00']]")).getText();
	Assert.assertEquals(msg, "$26.00");
		
//	Verify social media button appears for 'Twitter', 'Facebook', 'Google+' and "Pinterest'
	     msg = driver.findElement(By.xpath("//button[@type='button' and contains(@onclick,'socialsharing_twitter')]")).getText();
		  Assert.assertEquals(msg, "Tweet");
		
		
		
	    msg = driver.findElement(By.xpath("//button[@type='button' and contains(@onclick,'socialsharing_facebook')]")).getText();
		Assert.assertEquals(msg, "Share");
			
		 msg = driver.findElement(By.xpath("//button[@type='button' and contains(@onclick,'socialsharing_google')]")).getText();
		Assert.assertEquals(msg, "Google+");
				
		 msg = driver.findElement(By.xpath("//button[@type='button' and contains(@onclick,'socialsharing_pinterest')]")).getText();
			Assert.assertEquals(msg, "Pinterest");
					
		
//	mouse hover over both thumbnail and verify image changes on top after hovering
			
			 e = driver.findElement(By.id("//img[@id='thumb_8']"));
			 action.moveToElement(e).build().perform();
			 
			 String image_for_leftthumb = "http://automationpractice.com/img/p/8/8-large_default.jpg";
			  String imgActual = driver.findElement(By.id("bigpic")).getAttribute("src");
			  Assert.assertEquals(imgActual, image_for_leftthumb);
			  
			  Thread.sleep(5000);
			  
			  
			  e = driver.findElement(By.id("//img[@id='thumb_9']"));
				 action.moveToElement(e).build().perform();
				 
				 String image_for_rightthumb = "http://automationpractice.com/img/p/9/9-large_default.jpg";
				  imgActual = driver.findElement(By.id("bigpic")).getAttribute("src");
				 Assert.assertEquals(imgActual, image_for_rightthumb);
		
//	close the popup
			driver.findElement(By.xpath("//a[@title='Close']")).click();	 
		
		
}
	
	//TC3
	@Test
	public void Product_image_view() {
		
//	Training Keyword	explicit wait; action; for loop		
		
//	Go to http://automationpractice.com/index.php?id_product=7&controller=product
		driver.get("http://automationpractice.com/index.php?id_product=7&controller=product");
		
//	Verify there are 4 thumbnail on the page
		
		String src_for_firstThumb = "http://automationpractice.com/img/p/2/0/20-cart_default.jpg";
		String firstUrl = driver.findElement(By.xpath("//img[@id='thumb_20']")).getAttribute("src");
		Assert.assertEquals(firstUrl, src_for_firstThumb);
		
		String src_for_2ndThumb = "http://automationpractice.com/img/p/2/1/21-cart_default.jpg";
		 String secondUrl = driver.findElement(By.xpath("//img[@id='thumb_21']")).getAttribute("src");
		 Assert.assertEquals(secondUrl, src_for_2ndThumb);
		 
		 String src_for_thirdThumb = "http://automationpractice.com/img/p/2/2/22-cart_default.jpg";
		String thirdUrl = driver.findElement(By.xpath("//img[@id='thumb_22']")).getAttribute("src");
		Assert.assertEquals(thirdUrl, src_for_thirdThumb);
		
		String src_for_fourthThumb = "http://automationpractice.com/img/p/2/3/23-cart_default.jpg";
		String fourthUrl = driver.findElement(By.xpath("//img[@id='thumb_23']")).getAttribute("src");
		Assert.assertEquals(fourthUrl, src_for_fourthThumb);
		
		
//	click on the first thumbnail
		driver.findElement(By.xpath("//img[@id='thumb_20']")).click();
		
// Step 4 	verify popup displayed to slideshow
		String img_for_firstThumb = "http://automationpractice.com/img/p/2/0/20-thickbox_default.jpg";
		String imgUrl = driver.findElement(By.xpath("(//img[contains(@class,'fancybox-image')])[2]")).getAttribute("src");
		Assert.assertEquals(imgUrl, img_for_firstThumb);
		
		
//	Click next button and verify image changes, do the same for four images
		driver.findElement(By.xpath("//a[@title='Next' and contains(@class,'fancybox-next')]")).click();
		
//	close the popup
		driver.findElement(By.xpath("//a[@title='Close' and contains(@class,'fancybox-close')]")).click();
	
		
	}
	
	//TC4
	
	@Test
	
	public void Simple_negative_search() {
		
	//	Training Keyword	key press, actions	
		
// Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//	Enter 'invalid' in search text box on top
		driver.findElement(By.xpath("//input[@id='search_query_top' and @type='text']")).sendKeys("invalid");
		
		
//	Now, press Enter using keyboard
		Actions actions = new Actions (driver);
		actions.sendKeys(Keys.ENTER).build().perform();
		
		
//	Verify text: 'No results were found for your search "invalid"' displayed on the page
		String msg = driver.findElement(By.xpath("//p[@class='alert alert-warning' and contains(text(),'No results were found')]")).getText();
		Assert.assertEquals(msg, "No results were found for your search \"invalid\"");
		
	}
	
	
	//TC5
	
	@Test
	
	public void Simple_search_and_view_as_grid_and_list() {
		
//	Training Keyword	key press, actions	
		
//	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//	Enter 'Summer' in search text box on top
		driver.findElement(By.xpath("//input[@id='search_query_top' and @type='text']")).sendKeys("Summer");
		
//	Now, press Enter using keyboard
		Actions actions = new Actions (driver);
		actions.sendKeys(Keys.ENTER).build().perform();
		
//	Verify text: '4 results have been found.' on top right of the content
		String msg = driver.findElement(By.xpath("//span[contains(@class,'heading-counter') and contains(text(),'4 results have been found.')]")).getText();
		Assert.assertEquals(msg, "4 results have been found.");
		
//	Verify text: 'Showing 1 - 4 of 4 items' displayed
		msg = driver.findElement(By.xpath("//div[preceding-sibling::div[@id='pagination']]")).getText();
		Assert.assertEquals(msg, "Showing 1 - 4 of 4 items");
		
//	Click on 'Grid' icon from top right of panel
		driver.findElement(By.xpath("//li[@id='grid']")).click();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
//Step 7	Verify images are displaying as Grid
		
//	Click on 'List' icon now
		driver.findElement(By.xpath("//li[@id='list']")).click();
		
//Step 9  Verify images are displaying as list now
		
		
	}
	
	
	//TC6
	
	@Test
	
	public void Simple_Search_And_View_as_Grid_and_List() {
		
		
//	Training Keyword	Explicit wait; Select; For loop
		
//	Go to http://www.automationpractice.com
		
		driver.get("http://www.automationpractice.com");
		
//	Enter 'Dress' in search text box on top
		driver.findElement(By.xpath("//input[@id='search_query_top' and @type='text']")).sendKeys("Dress");
		
//	Click on search button icon
		driver.findElement(By.xpath("//button[@type='submit' and @name='submit_search']")).click();
		
//	Select Price: Lowest first option from Sort By Dropdown
		
		//WebElement e = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		//Select dropdown = new Select(e);
		//dropdown.selectByVisibleText("Price: Lowest first");
		
//	Verify the first product price is: $16.51
		
		//Actions action =  new Actions(driver);
		// e = driver.findElement(By.xpath("(//img[contains(@class,'replace-2x img-responsive')])[9]"));
		 //action.moveToElement(e).build().perform();
		
		//String msg = driver.findElement(By.xpath("(//div[child::span[@itemprop='price' and contains(text(),'$16.51')]])[2]")).getText();
		//Assert.assertEquals(msg, "$16.51");
		
//	Select Price: Highest first option from Sort By Dropdown
		
		//WebElement highest = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		//Select dropdownHighest = new Select(highest);
		//dropdownHighest.selectByVisibleText("Price: Highest first");
		
		
		
//	Verify the first product price is: $50.99
		
		 
		// e = driver.findElement(By.xpath("(//img[contains(@class,'replace-2x img-responsive')])[9]"));
		// action.moveToElement(e).build().perform();
		 
		 // msg = driver.findElement(By.xpath("(//div[child::span[@itemprop='price' and contains(text(),'$50.99')]])[2]")).getText();
			//Assert.assertEquals(msg, "$50.99");
		
		
//	Select Product name: A to Z option from Sort By Dropdown
		
		WebElement az = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		Select dropdownAZ = new Select(az);
		dropdownAZ.selectByVisibleText("Product Name: A to Z");
		
		
//	Verify the first product name is: Blouse
	
		String text = driver.findElement(By.xpath("//a[@title='Blouse' and contains(text(),'Blouse')]")).getText();
		Assert.assertEquals(text, "Blouse");
		
//	Select Product name: Z to A option from Sort By Dropdown
		
		WebElement ZA = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		Select dropdownZA= new Select(ZA);
		dropdownZA.selectByVisibleText("Product Name: Z to A");
		
		
//	Verify the first product name is: Printed Summer Dress
		text = driver.findElement(By.xpath("(//a[@title='Printed Summer Dress' and contains(text(),'Printed Summer Dress')])[1]")).getText();
		
		Assert.assertEquals(text, "Printed Summer Dress");
		
		
//	Select 'In Stock' option now from Sort By Dropdown
		WebElement Stock = driver.findElement(By.xpath("//select[@id='selectProductSort']"));
		Select InStock= new Select(Stock);
		InStock.selectByVisibleText("In stock");
		
		
//	Verify 'In Stock' green button appears for all displayed product
		
		  driver.findElements(By.xpath("//link[@itemprop='availability']")).size();
		
		
		for (int i = 0; i < 7; i++) {
			
			System.out.println("All the in Stock button is here"  );
			
		}
	}
	
	//TC7
	
	@Test
	
	public void Search_auto_suggestions() {
		
//	Training Keyword	Explicit wait; Select; For loop	
		
// Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//	Enter 'Chif' in search text box on top
		driver.findElement(By.xpath("//input[@id='search_query_top' and @type='text']")).sendKeys("Chif");
		
//Now, press Enter using keyboard
		
		//Actions actions = new Actions (driver);
		//actions.sendKeys(Keys.ENTER).build().perform();
		
//	Verify 'Summer Dresses > Printed Chiffon Dress' option get suggested in search textbox with 'Chif' in bold
		
		String msg = driver.findElement(By.xpath("(//li[contains(text(),'Summer Dresses > Printed ')])[1]")).getText();
		Assert.assertEquals(msg, "Summer Dresses > Printed Chiffon Dress");
		
		
		
	}
	
	//TC8
	
	@Test
	
	public void Search_with_filter() {
		
	//	Training Keyword	Actions, explicit wait, mouse hover	
		
//	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
//	Mouse hover over 'Women' menu
		
		Actions actions = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//a[@title='Women' and text()='Women']"));
		actions.moveToElement(e).build().perform();
		
		
//	Click on 'Summer Dresses' Under Dresses section
		
		driver.findElement(By.xpath("//a[@title='Summer Dresses' and text()='Summer Dresses']")).click();
		
//Step 4 	Click on 'White' option from left panel under color
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='button']"));
		checkboxes.get(0).click();
		
//	Verify text: There is 1 product displayed on right side
		
//	verify enabled filters option also displayed on left side with 'X' button
		
//	Click on 'X' button from enabled filters
//	Verify text: There is 3 product displayed on right side

	}
	
//TC9
	
	@DataProvider(name="items generator")
	public String[][] get_data(){
		String[][] data = new String[][] {
			
			{"Faded Short Sleeve T-shirts","$16.51"},
			{"Blouse ","$27.00"},
			//{"Printed Dress ","$26.00"},
			//{"Printed Dress ","$50.99"},
			{"Printed Summer Dress ","$28.98"},
			//{"Printed Summer Dress ","$16.40"},
			
		};
		return data;
	}
	
	@Test(dataProvider = "items generator")
	
	public void Search_items_and_verify_price(String itemName, String itemPrice){
		
		
// Training Keyword	TestNG parameters, TestNG DataProvider
		
//	Step 1	Go to http://www.automationpractice.com
		driver.get("http://www.automationpractice.com");
		
		
//	Step 2	"Now search by following items and verify item name and its price appears corectly.
		
		driver.findElement(By.id("search_query_top")).sendKeys(itemName);
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement e =driver.findElement(By.xpath("li[contains(@class,'ac_even ac_over')]"));
		wait.until(ExpectedConditions.visibilityOf(e)).click();
		
		String item = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
		Assert.assertEquals(item, itemName);
		
		String price = driver.findElement(By.id("our_price_display")).getText();
		Assert.assertEquals(price, itemPrice);
		
		System.out.println("Item name is : "    +itemName+     "and Item price is :"    +itemPrice);
//
//			Item name: Faded Short Sleeve T-shirts ** Item Price: $16.51
//			Item name: Blouse                       ** Item Price: $27.00
//			Item name: Printed Dress                **  Item Price: $26.00
//			Item name: Printed Dress                **  Item Price: $50.99
//			Item name: Printed Summer Dress        **  Item Price: $30.50
//			Item name: Printed Summer Dress        **  Item Price: $16.40

	
		
	}
	

}
