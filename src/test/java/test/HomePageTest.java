package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Parametrization;

public class HomePageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser () throws EncryptedDocumentException, IOException {
		driver = LaunchBrowser.chromeBrowser();
		ZerodhaLoginPage zerodhaLoginpage = new ZerodhaLoginPage (driver);
		String user = Parametrization.getData("Credentials", 0, 1);
		String pass = Parametrization.getData("Credentials", 1, 1);
		String pin  = Parametrization.getData("Credentials", 2, 1);
		zerodhaLoginpage.enterUserId(user);
		zerodhaLoginpage.enterPassword(pass);
		zerodhaLoginpage.clickOnLogin();
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));  // implicit wait or Universal wait
		zerodhaLoginpage.enterPin(pin,driver);
		zerodhaLoginpage.clickOnContinue();
		
	}
	
	@Test
	public void searchStockTest () {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Reliance",driver);
		int number = zerodhaHomePage.getSearchResultNumber();
		Assert.assertTrue(number > 0);
		//Assert.assertNotNull(number);
	}
	
	@Test
	public void searchStockAndClickOnBuy () throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		zerodhaHomePage.searchStock("Tata", driver);
		Thread.sleep(1000);
	    zerodhaHomePage.searchAndSelectDesiredStock("TATAPOWER", driver);
		zerodhaHomePage.clickOnSearchResultBuy();
		
		String title = zerodhaHomePage.getStockResultTitle();
		Assert.assertEquals(title, "TATAPOWER");
	}
	
	
}
