package generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	
	public static void takesScreenshot(WebDriver driver){
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/DWS_"+ Java_Utility.getName()+".png");
		try {
			FileHandler.copy(src, dest);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void takesScreenshot(WebElement element) {
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/DWS_"+Java_Utility.getName()+".png");
		
		try {
			FileHandler.copy(src, dest);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void selectDropdownOption(WebElement element, String option) {
		Select sel= new Select(element);
		sel.selectByVisibleText(option);
	}
	
	public static void deselectDropdownOption(WebElement element, String option) {
		Select sel= new Select(element);
		if(sel.isMultiple()) {
			sel.deselectByVisibleText(option);
		}else {
			throw new UnsupportedOperationException("De-selection is not possible in Single select dropdown");
		}
		
	}
	public static List<WebElement> getDropdownOptions(WebElement element) {
		Select sel= new Select(element);
		return sel.getOptions();
	}
	
	public static void click(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void enterData(WebDriver driver, WebElement element, String data) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='" +data+"';", element);
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)",element);
	}
	
	public static void switchToWindow(WebDriver driver, String title) {
		String parentWindowID=driver.getWindowHandle();
		Set<String> allWindowIDs=driver.getWindowHandles();
		
		allWindowIDs.remove(parentWindowID);
		for(String windowID : allWindowIDs) {
			driver.switchTo().window(windowID);
			if(driver.getTitle().contains(title)) {
				break;
			}
		}
	}

}
