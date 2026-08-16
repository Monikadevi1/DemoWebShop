package testScripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_Utilities.BaseTest;
import generic_Utilities.WebDriver_Utility;



public class AddressModule extends BaseTest {
	
	
	@Test(priority = 1)
	public void addAdress() throws IOException {
		
		driver.findElement(By.xpath("//div[@class='header-links']/descendant::a[@class='account']")).click();
		driver.findElement(By.xpath("//strong[text()='My account']/ancestor::div[@class='block block-account-navigation']/descendant::a[text()='Addresses']")).click();
		driver.findElement(By.xpath("//input[@value='Add new']")).click();
		
		driver.findElement(By.id("Address_FirstName")).sendKeys("Monika");
		driver.findElement(By.id("Address_LastName")).sendKeys("devi");
		driver.findElement(By.id("Address_Email")).sendKeys("monika2407@gmail.com");
		
		WebElement ele = driver.findElement(By.id("Address_CountryId"));
		
		Select sel=new Select(ele);
		
		sel.selectByVisibleText("India");
		
		driver.findElement(By.id("Address_City")).sendKeys("Chennai");
		driver.findElement(By.id("Address_Address1")).sendKeys("Adam sahib street,Royapuram,Chennai=13");
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("600013");
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys("123456790");
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		WebDriver_Utility.takesScreenshot(driver);
		Reporter.log("Test1", true);
		
		
	}
	
	@Test(priority = 2)
	public void updateAddress() throws IOException {
		
		
		driver.findElement(By.xpath("//div[@class='header-links']/descendant::a[@class='account']")).click();
		driver.findElement(By.xpath("//strong[text()='My account']/ancestor::div[@class='block block-account-navigation']/descendant::a[text()='Addresses']")).click();
		driver.findElement(By.xpath("//input[@value='Edit']")).click();
		driver.findElement(By.id("Address_LastName")).sendKeys("A");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		WebDriver_Utility.takesScreenshot(driver);
		Reporter.log("Test2", true);
		
		
	}
	
	@Test(priority = 3)
	public void removeAddress() throws InterruptedException, IOException {
		
		
		driver.findElement(By.xpath("//div[@class='header-links']/descendant::a[@class='account']")).click();
		driver.findElement(By.xpath("//strong[text()='My account']/ancestor::div[@class='block block-account-navigation']/descendant::a[text()='Addresses']")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		driver.switchTo().alert().accept();
		
		WebDriver_Utility.takesScreenshot(driver);
		Reporter.log("Test3", true);
		
	}
	

}
