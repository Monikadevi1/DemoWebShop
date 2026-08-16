package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public ShoppingCartPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[contains(@name,'itemquantity')]")
	private WebElement quantTF;
	
	@FindBy(name = "updatecart")
	private WebElement updateBT;

	public WebElement getQuantTF() {
		return quantTF;
	}

	public WebElement getUpdateBT() {
		return updateBT;
	}
	
	@FindBy(name = "removefromcart")
	private WebElement removeCB;

	public WebElement getRemoveCB() {
		return removeCB;
	}
	
	
	

}
