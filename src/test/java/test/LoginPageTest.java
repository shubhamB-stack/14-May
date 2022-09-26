package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.ForgotPage;
import pom.SignUpPage;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parametrization;
import utility.Reports;

@Listeners (utility.Listeners.class)
public class LoginPageTest extends BaseTest {
	// WebDriver driver;    base test ka use hora
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void addReports () {
		 reports = Reports.generatereports();
	}
	
	@BeforeMethod
	public void launchBrowser () {
		 driver = LaunchBrowser.chromeBrowser();
	}
	
	@DataProvider (name = "DataForTest")
	public Object [] [] data () {
		return new Object [] [] {{5,10,"Velocity"},{10,15,"Katraj"},{15,20,"Pune"}};
	}
	
	@Test (dataProvider  = "DataForTest")
	public void data (int a, int b, String s) {
		test = reports.createTest("data");
		System.out.println(a+b);
		System.out.println(s);
	}
	
	@Test
	public void zerodhaLoginTest () throws EncryptedDocumentException, IOException, InterruptedException {
		test = reports.createTest("zerodhaLoginTest");
		ZerodhaLoginPage zerodhaLoginpage = new ZerodhaLoginPage (driver);
		String user = Parametrization.getData("Credentials", 0, 1);
		String pass = Parametrization.getData("Credentials", 1, 1);
		String pin  = Parametrization.getData("Credentials", 2, 1);
		zerodhaLoginpage.enterUserId(user);
		zerodhaLoginpage.enterPassword(pass);
		zerodhaLoginpage.clickOnLogin();
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));  // implicit wait or Universal wait
		zerodhaLoginpage.enterPin(pin,driver);
		zerodhaLoginpage.clickOnContinue();
		
		Assert.assertTrue(false);
	}
	
	@Test (priority = 1)
	public void forgotPageTest () throws EncryptedDocumentException, IOException {
		test =reports.createTest("forgotPageTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnForgot();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000)); // implicit wait
		
		ForgotPage forgotPage = new ForgotPage(driver);
		
		String userid = Parametrization.getData("Credentials", 0, 1);
		String pan = Parametrization.getData("Credentials", 6, 1);
		String mob = Parametrization.getData("Credentials", 4, 1);
		String email = Parametrization.getData("Credentials", 7, 1);
		
		forgotPage.clickOnIrememberMyUserId();
		forgotPage.enterUserId(userid);
		forgotPage.enterPan(pan);
		forgotPage.clickOnReceiveOnSms();
		forgotPage.enterMobileNumber(mob);
		forgotPage.clickOnReset();
	}
	
	@Test (priority = 2)
	public void signUpPageTest () throws EncryptedDocumentException, IOException, InterruptedException {
		test = reports.createTest("signUpPageTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.clickOnSignup();
		zerodhaLoginPage.switchToSignUpPage(driver);
		//Thread.sleep(1000);
		
		SignUpPage signUpPage = new SignUpPage(driver);
		String mob = Parametrization.getData("Credentials", 4, 1);
		signUpPage.enterMobileNumber(mob, driver);
		signUpPage.clickOnContinue();

	}
	
	@AfterMethod 
	public void postTest (ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
		
	}
	
	@AfterTest
	public void flushReport () {
		reports.flush();
	}
	
    

}
