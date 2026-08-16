package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic_Utilities.BaseTest;
import generic_Utilities.File_Utility;
import objectRepository.HomePage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest() {
		
		
		
		String email = File_Utility.getPropertyData("email");
		
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(hp.getAccountLink().getText(),"abc",email+"Log in process failed...");
	
	
	}

}
