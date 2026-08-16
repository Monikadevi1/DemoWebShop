package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='header-links']/descendant::a[@class='account']")
	private WebElement accountLink;

	public WebElement getAccountLink() {
		return accountLink;
	}
	
	@FindBy(xpath ="//div[@class='header-links']/descendant::a[@class='ico-cart']")
	private WebElement cartLink;
	
	@FindBy(xpath ="//div[@class='header-links']/descendant::a[@class='ico-wishlist']")
	private WebElement wlistLink;

	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getWlistLink() {
		return wlistLink;
	}
	
	@FindBy(xpath="//a[text()='14.1-inch Laptop']/ancestor::div[@class='details']/descendant::input")
	private WebElement hpProduct;

	public WebElement getHpProduct() {
		return hpProduct;
	}
	
	
	
	
	

}
