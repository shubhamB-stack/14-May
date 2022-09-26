package pom;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {
	
	@FindBy (xpath ="//input[@id='userid']") private WebElement userId;
	@FindBy (xpath ="//input[@id='password']") private WebElement password;
	@FindBy (xpath ="//button[@type='submit']") private WebElement login;
	@FindBy (xpath ="//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath ="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
	@FindBy (xpath ="//input[@id='pin']") private WebElement pin;
	@FindBy (xpath ="//button[@type='submit']") private WebElement submitPin;
	
	
	public ZerodhaLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId (String user) {
		userId.sendKeys(user);
	}
	
	public void enterPassword (String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin () {
		login.click();
	}
	
	public void clickOnForgot () {
		forgot.click();
	}
	
	public void clickOnSignup () {
		signUp.click();
	}
	
	public void enterPin (String pinNumber,WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));  // Excplit wait
//		wait.until(ExpectedConditions.visibilityOf(pin));
		
		FluentWait <WebDriver> wait = new FluentWait <WebDriver> (driver);  // Fluent wait
		wait.withTimeout(Duration.ofMillis(2000));
		wait.pollingEvery(Duration.ofMillis(50));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinNumber);
	}
	
	public void clickOnContinue () {
		submitPin.click();
	}
	
	public void switchToSignUpPage (WebDriver driver) {
		Set <String> handles = driver.getWindowHandles();
		Iterator <String> i = handles.iterator();
		
		while (i.hasNext()) {
			String handle = i.next();
			driver.switchTo().window(handle);
			String title = driver.getTitle();
			
			if (title.equals("Signup and open a Zerodha trading and demat account online and start investing – Zerodha")) {
				break;
				
			}
			
			}
		}

}
