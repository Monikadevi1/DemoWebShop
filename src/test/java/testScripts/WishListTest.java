package testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Utilities.BaseTest;
import generic_Utilities.WebDriver_Utility;

public class WishListTest extends BaseTest{
	
	@Test(priority = 1)
	public void addToWishlistTest() throws IOException {
		
		driver.findElement(By.xpath("//strong[text()='Categories']/ancestor::div[@class='block block-category-navigation']/descendant::a[contains(text(),'Apparel')]")).click();
		
		driver.findElement(By.xpath("//a[text()='Blue and green Sneaker']")).click();
		
		WebElement wishList = driver.findElement(By.id("add-to-wishlist-button-28"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", wishList);
		
		wishList.click();
		
		driver.findElement(By.linkText("Wishlist")).click();
		
		WebDriver_Utility.takesScreenshot(driver);
		
		
	}
	
	@Test(priority = 2)
	public void updateWishListTest() throws IOException {
		
		
		driver.findElement(By.linkText("Wishlist")).click();
		
		WebElement update = driver.findElement(By.xpath("//input[contains(@name,'itemquantity')]"));
		update.clear();
		update.sendKeys("5");
		
		driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();
		
		WebDriver_Utility.takesScreenshot(driver);
		
		
	}
	
	@Test(priority = 3)
	public void addToCart() throws IOException {
		
		driver.findElement(By.linkText("Wishlist")).click();
		
		driver.findElement(By.xpath("//input[@name='addtocart']")).click();
		
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		driver.findElement(By.partialLinkText("Shopping")).click();
		
		WebDriver_Utility.takesScreenshot(driver);
		
		
	}
	
	

}
