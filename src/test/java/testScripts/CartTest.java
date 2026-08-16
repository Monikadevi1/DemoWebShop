package testScripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_Utilities.BaseTest;
import generic_Utilities.WebDriver_Utility;
import objectRepository.HomePage;
import objectRepository.ShoppingCartPage;

public class CartTest extends BaseTest{
	@Test(priority = 1)
	public void addToCartTest(){
		HomePage hp = new HomePage(driver);
		WebElement addToCart = hp.getHpProduct();
		WebDriver_Utility.scrollToElement(driver, addToCart);
		hp.getHpProduct().click();
		hp.getCartLink().click();
		Assert.assertEquals(driver.getTitle().contains("Shopping Cart"),true);
	}
	@Test(priority = 2)
	public void updateProductCountTest(){
		HomePage hp = new HomePage(driver);
		hp.getCartLink().click();
		Assert.assertEquals(driver.getTitle().contains("Shopping Cart"),true);
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		sp.getQuantTF().clear();
		sp.getQuantTF().sendKeys("5");
		sp.getUpdateBT().click();	
	}
	@Test(priority = 3)
	public void removeProductTest(){
		
		HomePage hp = new HomePage(driver);
		hp.getCartLink().click();
		Assert.assertEquals(driver.getTitle().contains("Shopping Cart"),true);
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		
		sp.getRemoveCB().click();
		sp.getUpdateBT().click();
		
		
		
	}

}
