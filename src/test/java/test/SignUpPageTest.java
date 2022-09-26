package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.SignUpPage;
import pom.ZerodhaLoginPage;
import utility.Parametrization;
import utility.Screenshot;

public class SignUpPageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser () {
	  driver = LaunchBrowser.chromeBrowser();
	}
	
	@Test
	public void ZerodhaSignUpTest () throws EncryptedDocumentException, IOException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignup();
		zerodhaLoginPage.switchToSignUpPage(driver);
		
		SignUpPage signUpPage = new SignUpPage(driver);
		String mobno = Parametrization.getData("Credentials", 4, 1);
		signUpPage.enterMobileNumber(mobno,driver);
		signUpPage.clickOnContinue();
		
		Screenshot.takesScreenshot(driver, "signup");
	}

}
